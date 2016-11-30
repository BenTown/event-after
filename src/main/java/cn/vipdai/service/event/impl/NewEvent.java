package cn.vipdai.service.event.impl;

import cn.vipdai.service.event.AfterBid;
import cn.vipdai.service.event.AfterRegsiter;
import cn.vipdai.service.event.Event;

public class NewEvent extends Event implements AfterRegsiter, AfterBid {

    @Override
    public void afterBid() {
        System.out.println("afterBid");
    }

    @Override
    public void afterRegsiter() {
        System.out.println("afterRegsiter");
    }

}
