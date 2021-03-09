package com.treasurebear.menu.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.treasurebear.menu.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.treasurebear.menu.domain.QMenu.menu;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/03/09
 */
@Repository
@RequiredArgsConstructor
public class MenuQuerydslRepository {

    private final JPAQueryFactory query;

    public List<Menu> findAllWithQuerydsl() {
        return query.selectFrom(menu)
                .where(menu.parent.isNull())
                .orderBy(menu.listOrder.asc())
                .fetch();
    }

}
