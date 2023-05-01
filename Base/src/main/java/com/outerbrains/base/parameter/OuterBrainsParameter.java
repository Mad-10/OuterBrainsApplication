package com.outerbrains.base.parameter;

import com.outerbrains.base.entity.OuterBrainsObject;

public class OuterBrainsParameter<T extends OuterBrainsObject> implements  OuterBrainsParameterInterface{
    protected String token;
    protected Long timestamp;
    protected T data;


    @Override
    public String getToken() {
        return this.token;
    }

    @Override
    public Long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public T getData() {
        return this.data;
    }
}
