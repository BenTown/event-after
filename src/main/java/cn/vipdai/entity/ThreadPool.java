package cn.vipdai.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static final int PoolSize = 128;
    /**
     * 活动
     */
    private static final ExecutorService threedPoolEvent = Executors.newFixedThreadPool(PoolSize);
    /**
     * 通知（sms/email/letter）
     */
    private static final ExecutorService threedPoolNotice = Executors.newFixedThreadPool(PoolSize);

    private ThreadPool() {
    }

    public static ExecutorService getThreedPoolEvent() {
        return threedPoolEvent;
    }

    public static ExecutorService getThreedPoolNotice() {
        return threedPoolNotice;
    }
}
