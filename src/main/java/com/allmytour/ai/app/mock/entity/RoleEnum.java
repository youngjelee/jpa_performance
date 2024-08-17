package com.allmytour.ai.app.mock.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {

    ADMIN("admin")
    , USER("user")
    ,GUEST("guest") ;

    private final String name;
}
