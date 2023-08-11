package com.rest_api.training.order.dto;

public class OrderDTO {

    private int orderCode; // 주문코드 (PK)
    private String orderDate; // 주문일자
    private String orderTiem; // 주문시간
    private int totalOrderPrice; // 총주문금액

    public OrderDTO() {
    }

    public OrderDTO(int orderCode, String orderDate, String orderTiem, int totalOrderPrice) {
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.orderTiem = orderTiem;
        this.totalOrderPrice = totalOrderPrice;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTiem() {
        return orderTiem;
    }

    public void setOrderTiem(String orderTiem) {
        this.orderTiem = orderTiem;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(int totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderCode=" + orderCode +
                ", orderDate='" + orderDate + '\'' +
                ", orderTiem='" + orderTiem + '\'' +
                ", totalOrderPrice=" + totalOrderPrice +
                '}';
    }
}
