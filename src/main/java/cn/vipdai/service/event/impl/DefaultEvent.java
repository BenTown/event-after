package cn.vipdai.service.event.impl;

import cn.vipdai.service.event.AfterBid;
import cn.vipdai.service.event.AfterLoan;
import cn.vipdai.service.event.AfterRegsiter;
import cn.vipdai.service.event.UseEventEnable;

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
