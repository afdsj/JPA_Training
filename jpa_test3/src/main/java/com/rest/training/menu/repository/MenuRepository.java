package com.rest.training.menu.repository;

import com.rest.training.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/* Menu : 엔티티 클래스를 의미
*  Integer : 엔티티의 식별자(ID) 타입을 의미
*            Menu 엔티티에 대한 DB 조작을 지원하는 메서드들이 제공된다*/
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    /* 해당 메뉴 코드에 해당하는 메뉴를 DB에서 찾아서 반환한다 */
    Menu findById(int menuCode);
}
