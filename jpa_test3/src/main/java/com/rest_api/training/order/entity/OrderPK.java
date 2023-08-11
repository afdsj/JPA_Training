package com.rest_api.training.order.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderPK implements Serializable {

    @Column(name = "order_code")
    private int orderCode; // 주문코드
    @Column(name = "menu_code")
    private int menuCode; // 메뉴코드

    public OrderPK() {
    }

    public OrderPK(int orderCode, int menuCode) {
        this.orderCode = orderCode;
        this.menuCode = menuCode;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    @Override
    public String toString() {
        return "OrderPK{" +
                "orderCode=" + orderCode +
                ", menuCode=" + menuCode +
                '}';
    }
}
