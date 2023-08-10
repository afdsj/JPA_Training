package com.rest.training.menu.controller;

import com.rest.training.menu.entity.Menu;
import com.rest.training.menu.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* @RestController
 *  : @Controller에 @ResponseBody가 결합된 어노테이션
 *    컨트롤러 클래스에 @RestController를 붙이면 컨트롤러 클래스 하위 메서드에
 *    @ResponseBody 어노테이션을 붙이지 않아도 문자열과 JSON 등을 전송할 수 있다
 *
 *  @RequestMapping
 *  : 요청이 왔을 때 어떤 컨트롤러가 호출이 되어야 하는지 알려주는 지표 같은 것이다 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    /* RestAPI 기반 작성법
     *  GET(조회): /menus/1 -> 메뉴들 중 한가지를 확인하고자 할 때
     *  GET(조회): /menus? -> 메뉴 전체를 대상으로 무언가를 하고 싶을 때(ex.주문 목록 확인할 때 /menus?order)
     *  POST(등록): /menus
     *  PUT(수정): /menus/1?
     *  DELETE(삭제): /menus/1 -> /menus일 경우, 전체를 삭제한다는 의미이기 떄문에 말이 안됨...
     * */

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        /* final은 기본값이 없기 때문에 초기화를 통해 값을 등록해주기*/
        this.menuService = menuService;
    }

    /*  메뉴코드 조회
     *  http Get 요청이 {menuCode}로 들어오면 메서드 호출
     *  {menuCode} : URL 경로에 있는 변수 나타냄
     *              ex) "/1" 요청 들어오면 menuCode에 1이 할당된다
     * */
    @GetMapping("/{menuCode}")
    /* ResponseEntity<Object> : http 응답을 나타내는 클래스, 어떤 객체도 담을 수 있도록 'Object'로 지정
     *  menuCode : ex) 포스트맨 localhost:8000/menu/1
     *                 -> 1번이 {menuCode}로 들어가서 int menuCode에 할당된다 */
    public ResponseEntity<Object> findMenuByCode(@PathVariable int menuCode) {

        /* menuService를 통해 menuCode에 해당하는 메뉴를 검색해서 menu 변수에 할당*/
        Menu menu = menuService.findMenuByCode(menuCode);

        /* menu가 null인 경우 (해당 메뉴 코드에 해당하는 메뉴가 존재하지 않을 경우) */
        if (Objects.isNull(menu)) {
            /* 404상태 코드를 가진 ResponseEntity를 생성하고 응답 본문에 문자열을 담아서 반환 */
            return ResponseEntity.status(404).body(new String("해당 메뉴는 존재하지 않습니다"));
        }
        /* ResponseEntity.ok()는 http 상태 코드 200(ok)를 가진 ResponseEntity를 생성한다
         *  body(menu)는 응답 본문에 menu 객체를 담아서 반환 (포스트맨 창으로 반환)*/
        return ResponseEntity.ok().body(menu);
    }

    /* 메뉴 리스트 조회
     * http Get 요청이 /list 경로로 들어오면 메서드 호출 */
    @GetMapping("/list")
    /* ResponseEntity를 반환하는 메서드
     *  List<?> 타입을 포함한 임의의 타입의 리스트를 반환한다*/
    public ResponseEntity<List<?>> findAllMenu() {
        /* menuService의 findAllMenu 메서드를 호출해서 모든 메뉴 리스트를 가져온다 */
        List<Menu> menuList = menuService.findAllMenu();
        /* menuList의 크기가 0보다 작거나 같을 경우 ( 메뉴가 없는 경우) */
        if (menuList.size() <= 0) {

            List<String> error = new ArrayList<>();
            error.add("String");
            return ResponseEntity.status(404).body(error);
        }
        return ResponseEntity.ok().body(menuList);
    }

}
