package com.outerbrains.chat.entity;

import java.util.ArrayList;
import java.util.List;

import com.outerbrains.base.entity.OuterBrainsObject;
import com.outerbrains.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChatGroup extends OuterBrainsObject {
    // 群组id
//    private Long id;
    // 群组名称
//    private String name;
    // 群组创建者
    private User creator;
    // 群组成员
    private List<User> members = new ArrayList<>();
    // 群组公告
    private String announcement;
    // 群组简介
//    private String introduction;
    // 群组头像
    private String avatar;
    //所属项目
    private String projectId;
    //所属团队
    private String teamId;
}
