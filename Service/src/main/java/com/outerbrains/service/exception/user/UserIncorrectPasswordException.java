package com.outerbrains.service.exception.user;

import com.outerbrains.base.exception.OuterBrainsException;

public class UserIncorrectPasswordException extends OuterBrainsException {

    public UserIncorrectPasswordException() {
        super("用户密码输入错误！");
    }

    public UserIncorrectPasswordException(String message) {
        super(message);
    }
}
