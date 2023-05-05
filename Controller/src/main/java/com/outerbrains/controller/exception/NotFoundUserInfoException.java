package com.outerbrains.controller.exception;

import com.outerbrains.base.exception.OuterBrainsException;

public class NotFoundUserInfoException extends OuterBrainsException {
    public NotFoundUserInfoException() {
        super("没有接收到有效的用户信息");
    }

    public NotFoundUserInfoException(String message) {
        super(message);
    }
}
