package com.treasurebear.menu.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/02/16
 */
@Audited
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Menu parent;

    private String name;

    private int listOrder;

    @OneToMany(mappedBy = "parent")
    private List<Menu> children = new ArrayList<>();

    @Builder
    public Menu(final String name) {
        this.name = name;
    }

}
