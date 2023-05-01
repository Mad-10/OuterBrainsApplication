package com.outerbrains.team.mapper;

import com.outerbrains.team.entity.Team;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeamMapper {

    @Select("SELECT * FROM team")
    List<Team> findAll();

    @Select("SELECT * FROM team WHERE id = #{id}")
    Team findById(Long id);

    @Insert("INSERT INTO team (name, description) VALUES (#{name}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Team team);

    @Update("UPDATE team SET name=#{name}, description=#{description} WHERE id=#{id}")
    void update(Team team);

    @Delete("DELETE FROM team WHERE id=#{id}")
    void delete(Long id);
}

