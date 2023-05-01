package com.outerbrains.user.entity;

import lombok.Data;

@Data
public class Contact {
    private String type;
    private String value;

    public Contact(String type, String value) {
        this.type = type;
        this.value = value;
    }
}
