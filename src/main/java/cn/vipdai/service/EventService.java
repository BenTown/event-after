package cn.vipdai.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import cn.vipdai.entity.ThreadPool;
import cn.vipdai.service.event.AfterBid;
import cn.vipdai.service.event.AfterLoan;
import cn.vipdai.service.event.AfterRegsiter;
import cn.vipdai.service.event.Event;
import cn.vipdai.service.event.UseEventEnable;
import cn.vipdai.service.event.UseIsFirstBId;
import cn.vipdai.service.event.impl.DefaultEvent;
import cn.vipdai.util.ClassUtil;

public class EventService {

    public void afterRegister(int userId) {
        ThreadPool.getThreedPoolEvent().execute(new Events(AfterRegsiter.class, userId));
    }

    public void afterBid(int orderId) {
        ThreadPool.getThreedPoolEvent().execute(new Events(AfterBid.class, orderId));
    }

    public void afterLoan(int orderId) {
        ThreadPool.getThreedPoolEvent().execute(new Events(AfterLoan.class, orderId));
    }

    class Events implements Runnable {

        Class<?> afterClazz;
        int id;

        public Events(Class<?> afterClazz, int id) {
            Thread.currentThread().setName("执行操作"+afterClazz.getName()+"-"+id);
            this.afterClazz = afterClazz;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                // 获取所有活动实现类
                String packageName = DefaultEvent.class.getPackage().getName();
                List<String> classNames = ClassUtil.getClassName(packageName, false);
                // 遍历所有活动实现类
                if (classNames != null) {
                    for (String className : classNames) {
                        Class<?> eventClazz = Class.forName(className);
                        Event event = (Event) eventClazz.newInstance();
                        // 判断活动实现类是否使用父类默认enable()
                        if (useEnable(eventClazz)) {
                            if (!event.enable()) {
                                continue;
                            }
                        }
                        // 判断活动实现类是否继承了After接口
                        if (isImpl(afterClazz, eventClazz)) {
                            Method method = eventClazz
                                    .getMethod(afterClazz.getMethods()[0].getName(), Integer.class);
                            // 判断活动实现方法是否使用父类默认isFirstBid()
                            if (useIsFirstBId(method)) {
                                if (!event.isFirstBid()) {
                                    continue;
                                }
                            }
                            // 调用After接口函数
                            method.invoke(event, id);
                        }
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | NoSuchMethodException | SecurityException | IllegalArgumentException
                    | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean useEnable(Class<?> eventClazz) {
        return eventClazz.isAnnotationPresent(UseEventEnable.class);
    }

    private boolean isImpl(Class<?> afterClazz, Class<?> eventClazz) {
        return afterClazz.isAssignableFrom(eventClazz);
    }

    private boolean useIsFirstBId(Method method) {
        // 只对实现了AfterBid的方法起作用
        return method.getName().equals(AfterBid.class.getMethods()[0].getName())
                && method.isAnnotationPresent(UseIsFirstBId.class);
    }

}
