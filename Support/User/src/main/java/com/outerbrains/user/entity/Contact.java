package com.outerbrains.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Contact {
    private String type;
    private String value;
    @JsonIgnore
    private String userId;

    public Contact(String type, String value, String userId) {
        this.type = type;
        this.value = value;
        this.userId = userId;
    }
}
