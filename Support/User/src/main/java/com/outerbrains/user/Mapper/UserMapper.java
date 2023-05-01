package com.outerbrains.user.Mapper;


import com.outerbrains.user.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users(id, name, description, password, email) VALUES(#{id}, #{name}, #{description}, #{password}, #{email})")
    int insert(User user);

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(String id);

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Update("UPDATE users SET name=#{name}, description=#{description}, password=#{password}, email=#{email} WHERE id=#{id}")
    int update(User user);

    @Delete("DELETE FROM users WHERE id=#{id}")
    int delete(String id);

}

