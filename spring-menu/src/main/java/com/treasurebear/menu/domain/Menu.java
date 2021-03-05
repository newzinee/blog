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
public class Menu extends CreatedAuditing {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Menu parent;

    private String name;

    private int listOrder;

    @Enumerated(EnumType.STRING)
    private PriorityType priorityType;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "ipAddress", column = @Column(name = "ip")),
    })
    private IPAddress ipAddress;

    @OneToMany(mappedBy = "parent")
    private List<Menu> children = new ArrayList<>();

//    @Audited(targetAuditMode = NOT_AUDITED)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Menu(final String name, final User user, final String ipAddress, final Menu parent, final PriorityType priorityType) {
        this.name = name;
        this.user = user;
        this.ipAddress = IPAddress.from(ipAddress);
        this.parent = parent;
        this.priorityType = priorityType;
    }

}
