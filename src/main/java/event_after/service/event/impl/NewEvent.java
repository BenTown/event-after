package event_after.service.event.impl;

import event_after.service.event.AfterBid;
import event_after.service.event.AfterLoan;
import event_after.service.event.AfterRegsiter;
import event_after.service.event.UseIsFirstBId;

public class NewEvent extends AbstractEvent implements AfterRegsiter, AfterBid, AfterLoan {

    @Override
    @UseIsFirstBId
    public void afterBid(Integer orderId) {
        System.out.println(Thread.currentThread().getName() + "NewEvent-afterBid" + ":" + orderId);
    }

    @Override
    public void afterRegsiter(Integer userId) {
        System.out.println(Thread.currentThread().getName() + "NewEvent-afterRegsiter" + ":" + userId);
    }

    @Override
    public void afterLoan(Integer orderId) {
        System.out.println(Thread.currentThread().getName() + "NewEvent-afterLoan" + ":" + orderId);
    }

}
