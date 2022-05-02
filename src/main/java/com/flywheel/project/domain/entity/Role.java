package com.flywheel.project.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum Role {

    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER");


    private final String value;
}
