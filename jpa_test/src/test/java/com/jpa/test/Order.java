package com.jpa.test;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "test_order")
@Table(name = "study_order")
public class Order {

    @Id
    @Column(name = "order_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNum; // 주문번호

    @Column(name = "member_code")
    private int memberCode;

    @Column(name = "order_status")
    private String orderStatus; // 상태

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate; // 주문일

    @Column(name = "order_modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderModifyDate; // 주문 수정일

    @Column(name = "order_delete_date")
    @Temporal(TemporalType.DATE)
    private Date orderDeleteDate; // 주문 삭제일


}
