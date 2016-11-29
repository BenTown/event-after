package cn.vipdai.event;

public abstract class Event {

    /**
     * 活动是否进行
     * 
     * @return enable
     */
    public boolean enable() {
        return true;
    }

    /**
     * 是否首次投资
     * 
     * @return enable
     */
    public boolean isFirstBid() {
        return true;
    }
}