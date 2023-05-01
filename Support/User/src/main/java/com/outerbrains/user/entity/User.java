package com.outerbrains.user.entity;

import com.outerbrains.base.entity.OuterBrainsObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends OuterBrainsObject {
    private String password;
    private List<Contact> contacts;
    private String email;
    private Role role;

    public User() {
        super();
        contacts = new ArrayList<>();
    }

    public User(String name, String description, String password, List<Contact> contacts, String email) {
        super(name, description);
        this.password = password;
        this.contacts = contacts;
        this.email = email;
    }
    public User(String name, String password, List<Contact> contacts, String email, Role role) {
        super(name);
        this.password = password;
        this.contacts = contacts;
        this.email = email;
        this.role = role;
    }
}
