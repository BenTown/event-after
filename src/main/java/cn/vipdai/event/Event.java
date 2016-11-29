package cn.vipdai.event;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import cn.vipdai.event.impl.DefaultEvent;
import cn.vipdai.util.ClassUtil;

public abstract class Event {

    public static final int Register = 1;
    public static final int Bid = 2;
    public static final int FirstBid = 3;

    /**
     * 活动是否进行
     * 
     * @return enable
     */
    public boolean enable() {
        return true;
    }

    /**
     * 是否首次投资
     * 
     * @return isFirstBid
     */
    public boolean isFirstBid() {
        return true;
    }

    public static void doAfter(int type, Object... args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            switch (type) {
            case Register:
                doSpecificAfter(AfterRegsiter.class);
                break;
            case Bid:
                doSpecificAfter(AfterBid.class);
                break;
            case FirstBid:
                doSpecificAfter(AfterFirstBid.class);
                break;
            default:
                break;
            }
        } finally {
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void doSpecificAfter(Class afterClazz, Object... args)
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
                    eventClazz
                        .getMethod(afterClazz.getMethods()[0].getName())
                        .invoke(eventClazz.newInstance(), args);
                }
            }
        }

    }

}