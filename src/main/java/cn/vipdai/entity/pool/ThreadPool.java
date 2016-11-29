package cn.vipdai.entity.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static final int PoolSize = 100;

    /**
     * 活动
     */
    ExecutorService threedPoolEvent = Executors.newCachedThreadPool();
    /**
     * 通知（sms/email/letter）
     */
    ExecutorService threedPoolNotice = Executors.newFixedThreadPool(PoolSize);

    private ThreadPool() {
    }

    public ExecutorService getThreedPoolEvent() {
        return threedPoolEvent;
    }
    
    public ExecutorService getThreedPoolNotice() {
        return threedPoolNotice;
    }
}
