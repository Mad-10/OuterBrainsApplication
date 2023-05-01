package com.outerbrains.base.dto;

import com.outerbrains.base.entity.OuterBrainsObject;
import com.outerbrains.base.result.OuterBrainsResultEnum;

public class OuterBrainsDto<T extends OuterBrainsObject> {
    OuterBrainsResultEnum result;
    protected T data;

    public OuterBrainsDto() {//默认成功，无数据
        this.result = OuterBrainsResultEnum.SUCCESS;
        this.data = null;
    }

    public OuterBrainsDto(T data) {//只传入数据的时候默认成功
        this.result = OuterBrainsResultEnum.SUCCESS;
        this.data = data;
    }

    public OuterBrainsDto(OuterBrainsResultEnum result, T data) {//自定义操作结果
        this.result = result;
        this.data = data;
    }
}
