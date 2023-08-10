package com.rest.training.menu.service;

import com.rest.training.menu.entity.Menu;
import com.rest.training.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Menu> findAllMenu() {
    }
}
