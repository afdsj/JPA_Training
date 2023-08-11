package com.rest_api.training.menu.controller;

import com.rest_api.training.menu.entity.Menu;
import com.rest_api.training.menu.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/menus")
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

    /*  메뉴 부분 조회
     *  http Get 요청이 {menuCode}로 들어오면 메서드 호출
     *  {menuCode} : URL 경로에 있는 변수 나타냄
     *              ex) "/1" 요청 들어오면 menuCode에 1이 할당된다
     * */
    @GetMapping("/{menuCode}")
    /* ResponseEntity<Object> : http 응답을 나타내는 클래스, 어떤 객체도 담을 수 있도록 'Object'로 지정
     * ResponseEntity : httpentity를 상속 받음으로써 HpptHeader와 body를 가질 수 있다
     * @PathVariable  : 스프링 프레임워크에서 경로 변수를 메서드 매개변수로 받아오기 위해 사용되는 어노테이션
     *  menuCode : ex) 포스트맨 localhost:8000/menu/1
     *                 -> 1번이 {menuCode}로 들어가서 int menuCode에 할당된다 */
    public ResponseEntity<Object> findMenuByCode(@PathVariable int menuCode) {

        /* menuService를 통해 menuCode에 해당하는 메뉴를 검색해서 menu 변수에 할당*/
        Menu menu = menuService.findMenuByCode(menuCode);

        /* menu가 null인 경우 (해당 메뉴 코드에 해당하는 메뉴가 존재하지 않을 경우) */
        if (Objects.isNull(menu)) {
            /* 404상태 코드를 가진 ResponseEntity를 생성하고 응답 본문에 문자열을 담아서 반환 */
            return ResponseEntity.status(404).body(new String("해당 메뉴코드는 존재하지 않습니다"));
        }
        /* ResponseEntity.ok()는 http 상태 코드 200(ok)를 가진 ResponseEntity를 생성한다
         *  body(menu)는 응답 본문에 menu 객체를 담아서 반환 (포스트맨 창으로 반환)*/
        return ResponseEntity.ok().body(menu);
    }

    /* 전체 메뉴 리스트 조회
     * http Get 요청이 /list 경로로 들어오면 메서드 호출 */
    @GetMapping("/list")
    /* ResponseEntity를 반환하는 메서드
     *  List<?> 타입을 포함한 임의의 타입의 리스트를 반환한다*/
    public ResponseEntity<List<?>> findAllMenus() {
        /* menuService의 findAllMenu 메서드를 호출해서 모든 메뉴 리스트를 가져온다 */
        List<Menu> menuList = menuService.findAllMenus();
        /* menuList의 크기가 0보다 작거나 같을 경우 (메뉴가 없는 경우) */
        if (menuList.size() <= 0) {
            /* error 이름의 List 객체 생성 */
            List<String> error = new ArrayList<>();
            /* error 리스트에 문자열 String을 추가
             *  오류가 발생 했을때 오류 메시지를 담기 위한 용도로 사용 */
            error.add("String");
            /* 404상태 코드를 가진 ResponseEntity 객체 생성
             *  body(error) : 생성한 ResponseEntity 객체에 error 리스트 담기 */
            return ResponseEntity.status(404).body(error);
        }
        /* ResponseEntity.ok()는 http 상태 코드 200(ok)를 가진 ResponseEntity를 생성한다
         *  body(menuList)는 응답 본문에 menuList 객체를 담아서 반환 (포스트맨 창으로 반환)*/
        return ResponseEntity.ok().body(menuList);
    }

    /* 메뉴 등록
     *  http Post 요청이 /regist 경로로 들어오면 메서드 호출 */
    @PostMapping("/regist")
    public ResponseEntity<?> regist(Menu menu) {
        /* menuService의 registMenu 메서드를 호출해서 메뉴를 등록한다
         *  result에 등록 결과가 저장된다 */
        int result = menuService.registMenu(menu);
        /* 메뉴 등록이 성공한 경우 200상태의 코드와 함꼐 메시지를 반환한다*/
        return ResponseEntity.ok().body("등록 성공");
    }

    /* 메뉴 수정
     * http Put 요청이 /update 경로로 들어오면 메서드 호출
     * 포스트맨 body에서 작성 후 출력 확인하기 */
    @PutMapping("/update")
    public ResponseEntity<?> update(Menu menu) {
        /* menuService의 findMenuByCode 메서드를 호출해서 메뉴 코드에 해당하는 메뉴를 조회한다
         *  조회된 메뉴 정보를 findmenu 변수에 할당 */
        Menu findmenu = menuService.findMenuByCode(menu.getMenuCode());

        /*  조회 성공 시 : 엔티티가 존재함
         *  조회 실패 시 : 업데이트를 할 대상이 존재하지 않음
         *
         *  findmenu가 null일 경우 (메뉴 조회에 실패한 경우)*/
        if (Objects.isNull(findmenu)) {
            /* 메시지를 응답 본문으로 반환*/
            return ResponseEntity.ok().body("데이터가 존재하지 않습니다");
        }
        /* menuService의 updateMenu 메서드를 호출해서 메뉴를 업데이트 한다
         *  업데이트 결과를 result 변수에 저장한다 */
        int result = menuService.updateMenu(findmenu, menu);

        /* result가 0보다 클 경우 (업데이트가 성공한 경우) */
        if (result > 0) {
            /* 메시지를 응답 본문으로 반환*/
            return ResponseEntity.ok().body("수정 완료");
        /* 업데이트가 실패한 경우*/
        }else {
            /* 400 상태 코드와 함께 메시지를 응답 본문으로 반환 */
            return ResponseEntity.status(400).body("수정 실패");
        }
    }

    /* 메뉴 삭제
     * http Get 요청이 {delete}로 들어오면 메서드 호출
     * {delete} : URL 경로에 있는 변수 나타냄
     *            ex) "/1" 요청 들어오면 delete에 1이 할당된다
     * */
    @DeleteMapping("/{delete}")
    public ResponseEntity<?> delete(@PathVariable int delete){
        /* menuService의 deleteCode 메서드를 호출해서 해당하는 메뉴를 삭제 */
        menuService.deleteCode(delete);
        /* 삭제가 성공하면 메시지를 응답 본문으로 반환*/
        return ResponseEntity.ok().body("삭제 성공");
    }
}
