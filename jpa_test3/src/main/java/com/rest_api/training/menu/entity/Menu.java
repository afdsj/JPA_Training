package com.rest_api.training.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* JPA를 사용하여 DB와 연동하는 엔티티 클래스
*  JPA가 알아서 쿼리를 돌리면 여기에 담겨서 보여줌
*
* @Entity : 이 클래스가 JPA 엔티티임을 나타낸다 DB에서 저장되고 관리되는 실제 데이터
*           인스턴스들이 DB의 레코드와 매핑된다
* @Table  : 엔티티와 매핑할 테이블 지정, name 속성으로 매핑할 테이블 이름 지정이 가능하다 (테이블 이름과 동일 해야 함) */
@Entity
@Table(name = "tbl_menu")
public class Menu {

    @Id // 필드가 엔티티의 기본 키(pk)
    @Column(name = "menu_code") // menu_code 컬럼과 매핑
    private int menuCode;

    @Column(name = "menu_name") // menu_name 컬럼과 매핑
    private String menuName;

    @Column(name = "menu_price") // menu_price 컬럼과 매핑
    private int menuPrice;

    @Column(name = "category_code") // category_code 컬럼과 매핑
    private int categoryCode;

    @Column(name = "orderable_status") // orderable_status 컬럼과 매핑
    private String orderableStatus;

    public Menu() {
    }

    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
