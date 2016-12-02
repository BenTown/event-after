package cn.vipdai.service.event.impl;

import cn.vipdai.service.event.AfterBid;
import cn.vipdai.service.event.AfterLoan;
import cn.vipdai.service.event.AfterRegsiter;

public class DefaultEvent extends AbstractEvent implements AfterRegsiter, AfterBid, AfterLoan {

    @Override
    public void afterBid() {
        System.out.println("DefaultEvent-afterBid");
    }

    @Override
    public void afterRegsiter() {
        System.out.println("DefaultEvent-afterRegsiter");
    }

    @Override
    public void afterLoan() {
        System.out.println("DefaultEvent-afterFirstBid");
    }

}
