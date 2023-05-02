package com.outerbrains.score.mapper;

import com.outerbrains.project.entity.Project;
import com.outerbrains.score.entity.Score;
import com.outerbrains.team.entity.Team;
import com.outerbrains.user.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ScoreMapper {

    @Select("SELECT * FROM Score WHERE id = #{id}")
    @Results({
            @Result(property = "user", column = "user_id", javaType = User.class,
                    one = @One(select = "com.outerbrains.user.mapper.UserMapper.findById")),
            @Result(property = "team", column = "team_id", javaType = Team.class,
                    one = @One(select = "com.outerbrains.team.mapper.TeamMapper.findById")),
            @Result(property = "project", column = "project_id", javaType = Project.class,
                    one = @One(select = "com.outerbrains.project.mapper.ProjectMapper.findById"))
    })
    Score findById(String id);

    @Insert("INSERT INTO Score (id, name, description, user_id, team_id, project_id, score, create_time)"
            + " VALUES (#{id}, #{name}, #{description}, #{user.id}, #{team.id}, #{project.id}, #{score}, #{createTime})")
    void insert(Score score);

    @Update("UPDATE Score SET name = #{name}, description = #{description}, user_id = #{user.id}, team_id = #{team.id},"
            + " project_id = #{project.id}, score = #{score}, create_time = #{createTime} WHERE id = #{id}")
    void update(Score score);

    @Delete("DELETE FROM Score WHERE id = #{id}")
    void delete(String id);
}
