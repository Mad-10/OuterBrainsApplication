package com.outerbrains.user.mapper;


import com.outerbrains.file.entity.File;
import com.outerbrains.user.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(id, name, description, createTime, updateTime, password) VALUES(#{id}, #{name}, #{description}, #{createTime}, #{updateTime}, #{password})")
    int insert(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(String id);

    @Select("SELECT * FROM user WHERE name = #{name} ")
    User findByName(String name);

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Update("UPDATE user SET name=#{name}, description=#{description}, password=#{password} WHERE id=#{id}")
    int update(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    int delete(String id);

    // 添加头像
    @Update("UPDATE user SET avatar_id=#{avatar.id} WHERE id=#{id}")
    int updateAvatar(@Param("id") String id, @Param("avatar") File avatar);

    // 下载头像
    @Select("SELECT * FROM user LEFT JOIN files ON user.avatar_id = files.id WHERE user.id=#{id}")
    User findByIdWithAvatar(String id);


    
}

