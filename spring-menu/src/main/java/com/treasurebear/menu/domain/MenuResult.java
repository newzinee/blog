package com.treasurebear.menu.domain;

import lombok.Getter;

import java.util.List;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/02/17
 */
@Getter
public class MenuResult {

    private Long id;

    private String name;

    private int listOrder;

    private List<Menu> children;

    public MenuResult(final Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.listOrder = menu.getListOrder();
        this.children = menu.getChildren();
    }

}
