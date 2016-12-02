package cn.vipdai.service;

import cn.vipdai.entity.ThreadPool;
import cn.vipdai.service.event.Events;

public class EventService {

    public void afterRegister(int userId) {
        ThreadPool.getThreedPoolEvent().execute(new Events(Events.Register, userId));
    }

    public void afterBid(int bidId) {
        ThreadPool.getThreedPoolEvent().execute(new Events(Events.Bid, bidId));
    }
    
    public void afterLoan(int bidId) {
        ThreadPool.getThreedPoolEvent().execute(new Events(Events.Loan, bidId));
    }

}
