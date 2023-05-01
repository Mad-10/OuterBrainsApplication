package com.outerbrains.user.entity;

import com.outerbrains.base.entity.OuterBrainsObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends OuterBrainsObject {

    public enum RoleType {
        ROLE_ADMIN,
        ROLE_USER,
        ROLE_LEADER,
        ROLE_MEMBER
    }

    private String roleTypeName;

    public Role() {
        super();
    }

    public Role(String name, String description, String roleTypeName) {
        super(name);
        this.description = description;
        this.roleTypeName = roleTypeName;
    }
}