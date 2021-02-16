package com.treasurebear.menu.repository;

import com.treasurebear.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/02/16
 */
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
