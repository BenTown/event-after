package cn.vipdai.event.impl;

import cn.vipdai.event.AfterBid;
import cn.vipdai.event.AfterRegsiter;
import cn.vipdai.event.Event;

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
