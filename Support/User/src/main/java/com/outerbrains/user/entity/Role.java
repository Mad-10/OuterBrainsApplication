package com.outerbrains.user.entity;

import com.outerbrains.base.entity.OuterBrainsObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends OuterBrainsObject {

    public enum RoleName {
        ROLE_ADMIN,
        ROLE_USER
    }

    private RoleName roleName;

    public Role() {
        super();
    }

    public Role(String name, String description, RoleName roleName) {
        super(name);
        this.description = description;
        this.roleName = roleName;
    }
}
