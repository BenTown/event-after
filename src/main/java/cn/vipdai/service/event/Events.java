package cn.vipdai.service.event;

import java.lang.reflect.InvocationTargetException;
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
                doAfter(AfterFirstBid.class);
                break;
            default:
                break;
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
                | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void doAfter(Class afterClazz, Object... args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {

        // 获取所有活动实现类
        String packageName = DefaultEvent.class.getPackage().getName();
        List<String> classNames = ClassUtil.getClassName(packageName, false);
        // 遍历所有活动实现类
        if (classNames != null) {
            for (String className : classNames) {
                Class eventClazz = Class.forName(className);
                // 判断活动实现类是否继承了After接口
                boolean isImpl = afterClazz.isAssignableFrom(eventClazz);
                if (isImpl) {
                    // 调用After接口函数
                    eventClazz.getMethod(afterClazz.getMethods()[0].getName()).invoke(eventClazz.newInstance(), args);
                }
            }
        }

    }
}
