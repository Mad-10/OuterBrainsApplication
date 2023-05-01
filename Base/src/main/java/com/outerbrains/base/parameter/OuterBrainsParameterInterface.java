package com.outerbrains.base.parameter;

import com.outerbrains.base.entity.OuterBrainsObject;

public interface OuterBrainsParameterInterface<T extends OuterBrainsObject> {
    String getToken();
    Long getTimestamp();
    T getData();
}
