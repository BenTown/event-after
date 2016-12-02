package cn.vipdai.service.event;

public abstract class Event {

    /**
     * 活动是否进行
     * 
     * @return enable
     */
    abstract public boolean enable();

    /**
     * 是否首次投资
     * 
     * @return isFirstBid
     */
    abstract public boolean isFirstBid();

}