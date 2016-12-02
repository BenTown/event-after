package event_after;

import event_after.service.EventService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        new EventService().afterRegister(0);
        new EventService().afterBid(0);
        new EventService().afterLoan(0);
        System.out.println("end");
    }
}
