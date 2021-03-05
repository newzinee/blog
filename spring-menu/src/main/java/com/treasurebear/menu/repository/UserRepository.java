package com.treasurebear.menu.repository;

import com.treasurebear.menu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/03/05
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
