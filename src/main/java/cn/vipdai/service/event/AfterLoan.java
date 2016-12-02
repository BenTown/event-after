package cn.vipdai.service.event;

public interface AfterLoan extends After {
    void afterLoan(Integer orderId);
}
