package com.treasurebear.menu.domain.dto;

import com.treasurebear.menu.domain.PriorityType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/03/04
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MenuParam {

    private String name;

    private String ip;

    private Long userId;

    private Long parentId;

    private PriorityType priority;
}
