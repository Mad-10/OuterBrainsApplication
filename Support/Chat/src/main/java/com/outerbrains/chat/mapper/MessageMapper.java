package com.outerbrains.chat.mapper;

import com.outerbrains.chat.entity.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM message WHERE id = #{id}")
    Message getMessageById(@Param("id") String id);

    @Select("SELECT * FROM message WHERE sender_id = #{senderId} AND recipient_id = #{recipientId} ORDER BY timestamp DESC")
    List<Message> getChatHistory(@Param("senderId") String senderId, @Param("recipientId") String recipientId);

    @Insert("INSERT INTO message (id, message_type, message_status, content, sender_id, recipient_id, timestamp) " +
            "VALUES (#{id}, #{messageType}, #{messageStatus}, #{content}, #{senderId}, #{recipientId}, #{timestamp})")
    void insertMessage(Message message);

    @Update("UPDATE message SET message_status = #{messageStatus} WHERE id = #{id}")
    void updateMessageStatus(@Param("id") String id, @Param("messageStatus") Message.MessageStatus messageStatus);

}
