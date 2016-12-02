package event_after.service.event.impl;

import event_after.service.event.Event;

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
