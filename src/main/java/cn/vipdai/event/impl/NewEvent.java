package cn.vipdai.event.impl;

import cn.vipdai.event.AfterBid;
import cn.vipdai.event.AfterFirstBid;
import cn.vipdai.event.AfterRegsiter;
import cn.vipdai.event.Event;

public class NewEvent extends Event implements AfterRegsiter, AfterBid, AfterFirstBid {

    public void afterFirstBid() {
        System.out.println("afterFirstBid");
    }

    public void afterBid() {
        System.out.println("afterBid");
    }

    public void afterRegsiter() {
        System.out.println("afterRegsiter");
    }

}
