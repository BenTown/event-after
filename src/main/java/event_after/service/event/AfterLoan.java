package event_after.service.event;

public interface AfterLoan extends After {
    void afterLoan(Integer orderId);
}
