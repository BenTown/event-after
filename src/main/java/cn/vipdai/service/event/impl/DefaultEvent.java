package cn.vipdai.service.event.impl;

import cn.vipdai.service.event.AfterBid;
import cn.vipdai.service.event.AfterFirstBid;
import cn.vipdai.service.event.AfterRegsiter;
import cn.vipdai.service.event.Event;

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