package org.shihe.pojo;

/**
 * @ClassName Order
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 14:46
 * @Version 1.0
 */
public class Order {
    private String orderNo;

    public Order(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
