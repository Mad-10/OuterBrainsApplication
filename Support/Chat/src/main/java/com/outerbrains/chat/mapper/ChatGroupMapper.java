package com.outerbrains.chat.mapper;

import com.outerbrains.chat.entity.ChatGroup;
import com.outerbrains.user.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ChatGroupMapper {

    @Insert("INSERT INTO chat_group(name, creator_id, announcement, introduction, avatar) VALUES(#{name}, #{creator.id}, #{announcement}, #{introduction}, #{avatar})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createChatGroup(ChatGroup chatGroup);

    @Update("UPDATE chat_group SET name=#{name}, creator_id=#{creator.id}, announcement=#{announcement}, introduction=#{introduction}, avatar=#{avatar} WHERE id=#{id}")
    int updateChatGroup(ChatGroup chatGroup);

    @Delete("DELETE FROM chat_group WHERE id=#{id}")
    int deleteChatGroup(Long id);

    @Select("SELECT * FROM chat_group WHERE id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "creator", column = "creator_id", javaType = User.class, one = @One(select = "com.outerbrains.user.mapper.UserMapper.selectUserById")),
            @Result(property = "announcement", column = "announcement"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "avatar", column = "avatar")
    })
    ChatGroup selectChatGroupById(Long id);

    @Select("SELECT * FROM chat_group WHERE name=#{name}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "creator", column = "creator_id", javaType = User.class, one = @One(select = "com.outerbrains.user.mapper.UserMapper.selectUserById")),
            @Result(property = "announcement", column = "announcement"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "avatar", column = "avatar")
    })
    ChatGroup selectChatGroupByName(String name);

    @Insert("INSERT INTO chat_group_member(chat_group_id, user_id) VALUES(#{chatGroupId}, #{userId})")
    int addGroupMember(@Param("chatGroupId") Long chatGroupId, @Param("userId") Long userId);

    @Delete("DELETE FROM chat_group_member WHERE chat_group_id=#{chatGroupId} AND user_id=#{userId}")
    int removeGroupMember(@Param("chatGroupId") Long chatGroupId, @Param("userId") Long userId);

}
