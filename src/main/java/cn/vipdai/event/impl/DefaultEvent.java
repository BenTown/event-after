package cn.vipdai.event.impl;

import cn.vipdai.event.AfterBid;
import cn.vipdai.event.AfterFirstBid;
import cn.vipdai.event.AfterRegsiter;
import cn.vipdai.event.Event;

public class DefaultEvent extends Event implements AfterRegsiter, AfterBid, AfterFirstBid {

    @Override
    public void afterBid() {
        System.out.println("DefaultEvent-afterBid");
    }

    @Override
    public void afterRegsiter() {
        System.out.println("DefaultEvent-afterRegsiter");
    }

    @Override
    public void afterFirstBid() {
        System.out.println("DefaultEvent-afterFirstBid");
    }

}
