package com.outerbrains.service.exception.user;

import com.outerbrains.base.exception.OuterBrainsException;

public class UserHaveNotBeenRegisiterException extends OuterBrainsException {
    public UserHaveNotBeenRegisiterException() {
        super("用户尚未注册！");
    }

    public UserHaveNotBeenRegisiterException(String message) {
        super(message);
    }
}
