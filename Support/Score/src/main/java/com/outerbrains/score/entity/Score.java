package com.outerbrains.score.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.outerbrains.base.entity.OuterBrainsObject;
import com.outerbrains.project.entity.Project;
import com.outerbrains.team.entity.Team;
import com.outerbrains.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
@EqualsAndHashCode(callSuper = true)
@Data
public class Score extends OuterBrainsObject {
    private int score; // score value
    private User user; // user who earned the score
    private Team team; // team to which the user belongs
    private Project project; // project to which the score is associated

    public Score() {
        super();
    }
}
