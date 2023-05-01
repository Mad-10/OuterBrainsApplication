package com.outerbrains.user.entity;

import com.outerbrains.base.entity.OuterBrainsObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends OuterBrainsObject {
    private String password;
    private List<Contact> contacts;
    private String email;
    private Role role;
    private File avatar;//用户头像

}
