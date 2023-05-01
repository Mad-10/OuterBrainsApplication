package com.outerbrains.user.mapper;


import com.outerbrains.file.entity.File;
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

    // 添加头像
    @Update("UPDATE users SET avatar_id=#{avatar.id} WHERE id=#{id}")
    int updateAvatar(@Param("id") String id, @Param("avatar") File avatar);

    // 下载头像
    @Select("SELECT * FROM users LEFT JOIN files ON users.avatar_id = files.id WHERE users.id=#{id}")
    User findByIdWithAvatar(String id);


}

