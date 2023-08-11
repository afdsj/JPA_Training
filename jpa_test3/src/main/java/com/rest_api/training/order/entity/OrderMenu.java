package com.rest_api.training.order.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order_menu")
public class OrderMenu {

    @EmbeddedId
    private OrderPK orderPK;

    @Column(name = "order_code")
    private int orderCode;

    @Column(name = "menu_code")
    private int menuCode;

    @Column(name = "order_amount")
    private int orderAmount;

    public OrderMenu() {
    }

    public OrderMenu(OrderPK orderPK, int orderCode, int menuCode, int orderAmount) {
        this.orderPK = orderPK;
        this.orderCode = orderCode;
        this.menuCode = menuCode;
        this.orderAmount = orderAmount;
    }

    public OrderPK getOrderPK() {
        return orderPK;
    }

    public void setOrderPK(OrderPK orderPK) {
        this.orderPK = orderPK;
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

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "orderPK=" + orderPK +
                ", orderCode=" + orderCode +
                ", menuCode=" + menuCode +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
