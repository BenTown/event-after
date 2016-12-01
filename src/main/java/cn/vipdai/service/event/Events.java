package cn.vipdai.service.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import cn.vipdai.service.event.impl.DefaultEvent;
import cn.vipdai.util.ClassUtil;

public class Events implements Runnable {

    public static final int Register = 1;
    public static final int Bid = 2;
    public static final int FirstBid = 3;

    public int type;
    Object[] args;

    public Events(int type, Object... args) {
        this.type = type;
        this.args = args;
    }

    @Override
    public void run() {
        try {
            switch (this.type) {
            case Register:
                doAfter(AfterRegsiter.class);
                break;
            case Bid:
                doAfter(AfterBid.class);
                break;
            case FirstBid:
                doAfter(AfterLoan.class);
                break;
            default:
                break;
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
                | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void doAfter(Class<?> afterClazz, Object... args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
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
                    Method method = eventClazz.getMethod(afterClazz.getMethods()[0].getName());
                    // 判断活动实现方法是否使用父类默认isFirstBid()
                    if (UseIsFirstBId(method)) {
                        if (!event.isFirstBid()) {
                            continue;
                        }
                    }
                    // 调用After接口函数
                    method.invoke(event, args);
                }
            }
        }
    }

    private boolean useEnable(Class<?> eventClazz) {
        return eventClazz.isAnnotationPresent(UseEventEnable.class);
    }

    private boolean isImpl(Class<?> afterClazz, Class<?> eventClazz) {
        return afterClazz.isAssignableFrom(eventClazz);
    }

    private boolean UseIsFirstBId(Method method) {
        // 只对实现了AfterBid的方法起作用
        return method.getName().equals(AfterBid.class.getMethods()[0].getName())
                && method.isAnnotationPresent(UseIsFirstBId.class);
    }

}
