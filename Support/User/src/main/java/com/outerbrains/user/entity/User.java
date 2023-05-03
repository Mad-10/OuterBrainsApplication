package com.outerbrains.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outerbrains.base.entity.OuterBrainsObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends OuterBrainsObject {
    @JsonIgnore
    private String password;
    private List<Contact> contacts;
    private File avatar;//用户头像
    @JsonProperty("password")
    public String getPasswordForSerialization() {
        return password;
    }

}
