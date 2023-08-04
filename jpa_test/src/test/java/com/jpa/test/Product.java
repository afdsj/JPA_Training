package com.jpa.test;

import javax.persistence.*;

@Entity(name = "test_product")
@Table(name = "study_product")
public class Product {

    @Id
    @Column(name = "product_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productNum; // 제품번호

    @Column(name = "product_name", unique = true)
    private String productName; // 제품명

    @Column(name = "price"+"원")
    private int price; // 제품가격
}
