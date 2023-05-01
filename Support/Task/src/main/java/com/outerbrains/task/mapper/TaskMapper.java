package com.outerbrains.task.mapper;

import com.outerbrains.task.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("SELECT * FROM task WHERE id = #{id}")
    Task findById(@Param("id") Long id);

    @Select("SELECT * FROM task")
    List<Task> findAll();

    @Insert("INSERT INTO task (name, description, deadline, status, supervisor_id, creator_id) " +
            "VALUES (#{task.name}, #{task.description}, #{task.deadline}, #{task.status}, " +
            "#{task.supervisor.id}, #{task.creator.id})")
    @Options(useGeneratedKeys = true, keyProperty = "task.id")
    void save(@Param("task") Task task);

    @Update("UPDATE task SET name = #{task.name}, description = #{task.description}, deadline = #{task.deadline}, " +
            "status = #{task.status}, supervisor_id = #{task.supervisor.id}, creator_id = #{task.creator.id} " +
            "WHERE id = #{task.id}")
    void update(@Param("task") Task task);

    @Delete("DELETE FROM task WHERE id = #{id}")
    void deleteById(@Param("id") Long id);

}
