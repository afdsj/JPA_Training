package com.rest_api.training.menu.service;

import com.rest_api.training.menu.entity.Menu;
import com.rest_api.training.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        /* final은 기본값이 없기 때문에 초기화를 통해 값을 등록해주기*/
        this.menuRepository = menuRepository;
    }

    /* menuCode를 사용해서 메뉴를 검색하는 메서드*/
    public Menu findMenuByCode(int menuCode) {
        /* menuRepository를 통해 DB에서 menuCode에 해당하는 메뉴를 찾아와서 menu 변수에 할당 */
        Menu menu = menuRepository.findById(menuCode);
        /* 메뉴 코드에 해당하는 메뉴를 반환한다 */
        return menu;
    }

    /* Menu 엔티티의 모든 메뉴를 조회하여 리스트로 반환하는 메서드*/
    public List<Menu> findAllMenus() {
        /* menuRepository를 통해 DB에서 모든 메뉴를 조회해서
         *  조회된 메뉴들은 Menu 엔티티의 객체로 구성된 리스트로 반환한다
         *  menuList 변수에 조회된 메뉴 리스트를 할당
         *
         * findAll() : JpaRepository에서 제공해주는 메소드이기 때문에
         * menuRepository에서 따로 메소드를 작성 안해줘도 된다 */
        List<Menu> menuList = menuRepository.findAll();
        /* 조회한 메뉴 리스트를 반환 */
        return menuList;
    }

    /* 스프링 프레임워크에서 트랜잭션을 관리하기 위해 사용되는 어노테이션
    *  메서드나 클래스에 적용될 수 있으며 해당 메서드나 클래스 내에서 실행되는
    *  데이터베이스 관련 작업들을 하나의 트랜잭션으로 묶어준다 */
    @Transactional
    /* 메뉴를 등록하는 기능을 수행하는 메서드 */
    public int registMenu(Menu menu) {
        /* save() : 엔티티를 DB에 저장하는 역할, JpaRepository에서 제공해주는 메소드
         *           엔티티를 새로 추가할때 사용되거나 이미 존재하는 엔티티의 내용을 수정할 때에도 활용된다
         *
         * menuRepository를 사용하여 menu 객체를 DB에 저장한다
         * result 변수에는 저장된 Menu 객체가 할당된다 */
        Menu result = menuRepository.save(menu);
        System.out.println(result);

        /* result가 null인지 확인*/
        if (Objects.isNull(result)) {
            /* null인 경우 (메뉴 등록에 실패한 경우) 0을 반환 */
            return 0;
        } else {
            /* null이 아닌 경우 (메뉴 등록에 성공한 경우) 1을 반환*/
            return 1;
        }
    }

    /* 메뉴 정보를 수정하는 기능을 수행하는 메서드 */

    /* findmenu : 업데이트 대상 메뉴 객체
    *  upmenu   : 업데이트할 내용을 가진 메뉴 객체 */
    public int updateMenu(Menu findmenu, Menu upmenu) {
        /* upmenu 객체의 MenuName이 null이 아닌 경우 (업데이트할 이름이 존재하면) */
        if (!Objects.isNull(upmenu.getMenuName())) {
            /* findmenu의 MenuName을 upmenu의 MenuName으로 업데이트한다*/
            findmenu.setMenuName(upmenu.getMenuName());
            System.out.println("menu -> : " + findmenu.getMenuName());
        }
        /* 수정된 findmenu 객체를 DB에 저장하여 업데이트 작업을 수행한다
        *  업데이트 결과를 result 변수에 할당 */
        Menu result = menuRepository.save(findmenu);

        /* result가 null인 경우 (업데이트에 실패한 경우) */
        if (Objects.isNull(result)) {
            return 0;
        /* null이 아닌 경우 (업데이트에 성공한 경우) */
        } else {
            return 1;
        }
    }

    /* 메뉴 정보를 삭제하는 기능을 수행하는 메서드 */
    public void deleteCode(int delete) {
        /* menuRepository의 deleteById 메서드를 호출해서 메뉴 코드에 해당하는
        *  메뉴를 DB에서 삭제 */
        menuRepository.deleteById(delete);
        /* 삭제된 메뉴 코드에 해당하는 메뉴를 DB에서 조회한 후 메뉴 정보를 menu 변수에 할당 */
        Menu menu = menuRepository.findById(delete);
        System.out.println(menu);
    }
}
