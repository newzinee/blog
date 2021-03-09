package com.treasurebear.menu.service;

import com.treasurebear.menu.domain.Menu;
import com.treasurebear.menu.domain.MenuResult;
import com.treasurebear.menu.domain.User;
import com.treasurebear.menu.domain.dto.MenuParam;
import com.treasurebear.menu.repository.MenuQuerydslRepository;
import com.treasurebear.menu.repository.MenuRepository;
import com.treasurebear.menu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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

    private final MenuQuerydslRepository menuQuerydslRepository;

    private final UserRepository userRepository;

    public List<MenuResult> getV1Menus() {
        final List<Menu> all = menuRepository.findAll();
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

    public List<MenuResult> getV2Menus() {
        final List<Menu> all = menuRepository.findAllByParentIsNull();
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

    @Transactional
    public Long addMenu(final MenuParam param) {
        final User user = userRepository.findById(param.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 User 입니다."));

        final Menu parent = menuRepository.findById(param.getParentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Menu 입니다."));


        final Menu menu = Menu.builder()
                .name(param.getName())
                .ipAddress(param.getIp())
                .parent(parent)
                .user(user)
                .priorityType(param.getPriority())
                .build();
        final Menu savedMenu = menuRepository.save(menu);
        return savedMenu.getId();
    }

    public List<MenuResult> getV3Menus() {
        final List<Menu> all = menuQuerydslRepository.findAllWithQuerydsl();
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

}
