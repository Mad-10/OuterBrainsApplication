package com.outerbrains.team.entity;

import com.outerbrains.base.entity.OuterBrainsObject;
import com.outerbrains.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Team extends OuterBrainsObject {
    private List<User> members;

    public Team() {
        super();
        members = new ArrayList<>();
    }

    public Team(String name, String description) {
        super(name, description);
        this.members = new ArrayList<>();
    }
}

