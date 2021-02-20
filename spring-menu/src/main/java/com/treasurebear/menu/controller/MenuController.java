package com.treasurebear.menu.controller;

import com.treasurebear.menu.domain.MenuResult;
import com.treasurebear.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/02/19
 */
@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/v1/menus")
    public ResponseEntity<List<MenuResult>> getMenus() {
        final List<MenuResult> menus = menuService.getV1Menus();
        return ResponseEntity.ok(menus);
    }
}
