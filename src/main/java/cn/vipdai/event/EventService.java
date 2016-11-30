package cn.vipdai.event;

import cn.vipdai.entity.pool.ThreadPool;

public class EventService {

    public void afterRegister(int userId) {
        ThreadPool.getThreedPoolEvent().execute(new Events(Events.Register, userId));
    }

    public void afterBid(int bidId) {
        ThreadPool.getThreedPoolEvent().execute(new Events(Events.Bid, bidId));
    }

}
