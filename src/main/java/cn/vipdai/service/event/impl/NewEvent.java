package cn.vipdai.service.event.impl;

import cn.vipdai.service.event.AfterBid;
import cn.vipdai.service.event.AfterLoan;
import cn.vipdai.service.event.AfterRegsiter;
import cn.vipdai.service.event.UseIsFirstBId;

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
