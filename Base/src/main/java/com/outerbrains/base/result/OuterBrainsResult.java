package com.outerbrains.base.result;

import com.outerbrains.base.entity.OuterBrainsObject;
import com.outerbrains.base.result.OuterBrainsResultEnum;

public class OuterBrainsResult<T extends OuterBrainsObject> {
    OuterBrainsResultEnum result;
    String errorMessage;
    protected T data;

    public OuterBrainsResult() {//默认成功，无数据
        this.result = OuterBrainsResultEnum.SUCCESS;
        this.data = null;
    }

    public OuterBrainsResult(T data) {//只传入数据的时候默认成功
        this.result = OuterBrainsResultEnum.SUCCESS;
        this.data = data;
    }

    public OuterBrainsResult(OuterBrainsResultEnum result, T data) {//自定义操作结果
        this.result = result;
        this.data = data;
    }
}
