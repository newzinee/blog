package com.treasurebear.menu.controller;

import com.treasurebear.menu.domain.MenuResult;
import com.treasurebear.menu.domain.dto.MenuParam;
import com.treasurebear.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/menu")
    public ResponseEntity<Map<String, Long>> addMenu(@RequestBody MenuParam param) {
        Long id = menuService.addMenu(param);
        return ResponseEntity.ok().body(Map.of("id", id));
    }
}
