package cn.vipdai.vipdai_base;

import cn.vipdai.service.event.EventService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        new EventService().afterRegister(0);
        new EventService().afterBid(0);
        System.out.println("end");
    }
}
