package event_after.service.event.impl;

import event_after.service.event.AfterBid;
import event_after.service.event.AfterLoan;
import event_after.service.event.AfterRegsiter;
import event_after.service.event.UseEventEnable;

@UseEventEnable
public class DefaultEvent extends AbstractEvent implements AfterRegsiter, AfterBid, AfterLoan {

    @Override
    public void afterBid(Integer orderId) {
        System.out.println(Thread.currentThread().getName() + "DefaultEvent-afterBid" + orderId);
    }

    @Override
    public void afterRegsiter(Integer userId) {
        System.out
                .println(Thread.currentThread().getName() + "DefaultEvent-afterRegsiter" + userId);
    }

    @Override
    public void afterLoan(Integer orderId) {
        System.out.println(Thread.currentThread().getName() + "DefaultEvent-afterLoan" + orderId);
    }

}
