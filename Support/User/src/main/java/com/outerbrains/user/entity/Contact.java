package com.outerbrains.user.entity;

import lombok.Data;

@Data
public class Contact {
    private String type;
    private String value;
    private String userId;

    public Contact(String type, String value, String userId) {
        this.type = type;
        this.value = value;
        this.userId = userId;
    }
}
