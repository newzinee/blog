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
    public ResponseEntity<List<MenuResult>> getV1Menus() {
        final List<MenuResult> menus = menuService.getV1Menus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/v2/menus")
    public ResponseEntity<List<MenuResult>> getV2Menus() {
        final List<MenuResult> menus = menuService.getV2Menus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/v3/menus")
    public ResponseEntity<List<MenuResult>> getV3Menus() {
        final List<MenuResult> menus = menuService.getV3Menus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/v4/menus")
    public ResponseEntity<List<MenuResult>> getV4Menus() {
        final List<MenuResult> menus = menuService.getV4Menus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/v5/menus")
    public ResponseEntity<List<MenuResult>> getV5Menus() {
        final List<MenuResult> menus = menuService.getV5Menus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/v6/menus")
    public ResponseEntity<List<MenuResult>> getV6Menus() {
        final List<MenuResult> menus = menuService.getV6Menus();
        return ResponseEntity.ok(menus);
    }
}
