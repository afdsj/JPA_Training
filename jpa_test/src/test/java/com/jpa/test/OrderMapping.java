package com.jpa.test;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderMapping implements Serializable {

    @Column(name = "order_num")
    private int orderNum; // 주문번호 (fk)

    @Column(name = "product_num")
    private int productNum; // 제품번호 (fk)
}
