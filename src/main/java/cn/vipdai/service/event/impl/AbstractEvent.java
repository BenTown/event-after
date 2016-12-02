package cn.vipdai.service.event.impl;

import cn.vipdai.service.event.Event;

public class AbstractEvent extends Event {

    @Override
    public boolean enable() {

        return false;
    }

    @Override
    public boolean isFirstBid() {

        return false;
    }

}
