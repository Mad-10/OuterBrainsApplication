package com.outerbrains.user.mapper;

import com.outerbrains.user.entity.Role;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface RoleMapper {

    @Insert("INSERT INTO Role(id, name, description, createTime, updateTime, roleTypeName) " +
            "VALUES(#{id}, #{name}, #{description}, #{createTime}, #{updateTime}, #{roleTypeName})")
    int insert(Role role);

    @Select("SELECT * FROM Role WHERE id = #{id}")
    @Results({
            @Result(property = "roleTypeName", column = "roleTypeName")
    })
    Role getById(String id);

    @Select("SELECT * FROM Role WHERE name = #{name}")
    @Results({
            @Result(property = "roleTypeName", column = "roleTypeName")
    })
    Role getByName(String name);

    @Update("UPDATE Role SET name=#{name}, description=#{description}, updateTime=#{updateTime}, roleTypeName=#{roleTypeName} WHERE id =#{id}")
    int update(Role role);

    @Delete("DELETE FROM Role WHERE id =#{id}")
    int delete(String id);

    @Select("SELECT * FROM Role")
    @Results({
            @Result(property = "roleTypeName", column = "roleTypeName")
    })
    List<Role> getAll();
}
