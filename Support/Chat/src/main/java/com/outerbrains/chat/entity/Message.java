package com.outerbrains.chat.entity;

import com.outerbrains.base.entity.OuterBrainsObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Message extends OuterBrainsObject {
    private MessageType messageType;
    private MessageStatus messageStatus;
    private String content;
    private String senderId;
    private String recipientId;
    private String timestamp;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
    public enum MessageStatus {
        UNREAD,
        READ
    }
}
