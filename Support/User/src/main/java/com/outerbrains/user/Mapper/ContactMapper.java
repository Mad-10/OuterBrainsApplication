package com.outerbrains.user.Mapper;

import com.outerbrains.user.entity.Contact;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContactMapper {

    @Insert("INSERT INTO contact(type, value, user_id) VALUES (#{type}, #{value}, #{userId})")
    void insert(Contact contact);

    @Select("SELECT * FROM contact WHERE user_id = #{userId}")
    List<Contact> findByUserId(String userId);

    @Delete("DELETE FROM contact WHERE user_id = #{userId}")
    void deleteByUserId(String userId);

    @Update("UPDATE Contact SET value = #{value} WHERE user_id = #{userId} AND type = #{type}")
    void update(Contact contact);
}
