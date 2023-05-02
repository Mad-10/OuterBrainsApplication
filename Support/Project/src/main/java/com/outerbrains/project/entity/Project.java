package com.outerbrains.project.entity;

import com.outerbrains.base.entity.OuterBrainsObject;
import com.outerbrains.team.entity.Team;
import com.outerbrains.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Project extends OuterBrainsObject {
    private String description;
    private Team team;
    private User leader;
    private List<User> administrators;
    private List<User> members;

    public void addMember(User member) {
        if (!members.contains(member)) {
            members.add(member);
        }
    }

    public void removeMember(User member) {
        members.remove(member);
    }

    public boolean isMember(User user) {
        return members.contains(user);
    }
}
