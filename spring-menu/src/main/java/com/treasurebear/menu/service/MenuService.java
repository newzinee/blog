package com.treasurebear.menu.service;

import com.treasurebear.menu.domain.Menu;
import com.treasurebear.menu.domain.MenuResult;
import com.treasurebear.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/02/17
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<MenuResult> getV1Menus() {
        final List<Menu> all = menuRepository.findAll();
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

    public List<MenuResult> getV2Menus() {
        final List<Menu> all = menuRepository.findAllByParentIsNull();
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

    public List<MenuResult> getV3Menus() {
        final List<Menu> all = menuRepository.findAll(Sort.by(Sort.Direction.ASC, "listOrder"));
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

    public List<MenuResult> getV4Menus() {
        final List<Menu> all = menuRepository.findAllByParentIsNull(Sort.by(Sort.Direction.ASC, "listOrder"));
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

    public List<MenuResult> getV5Menus() {
        final List<Menu> all = menuRepository.findAllWithJpql();
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

}
