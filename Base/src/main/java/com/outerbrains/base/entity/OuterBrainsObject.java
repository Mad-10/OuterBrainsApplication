package com.outerbrains.base.entity;

import lombok.Data;

import java.time.Instant;
import java.util.Random;

@Data
public class OuterBrainsObject {
    protected String id;
    protected String name;
    protected String description;
    protected Instant createTime;
    protected Instant updateTime;

    public OuterBrainsObject() {
        super();
        this.id = generateId();
        this.createTime = Instant.now();
        this.updateTime = Instant.now();
    }

    public OuterBrainsObject(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public OuterBrainsObject(String name) {
        this(name, "");
    }

    public String generateId() {
        long timestamp = System.currentTimeMillis();
        Random random = new Random();
        long digit = Math.abs(Thread.currentThread().getId() + timestamp + random.nextLong());
        return this.getClass().getSimpleName() + "_" + digit;
    }

}
