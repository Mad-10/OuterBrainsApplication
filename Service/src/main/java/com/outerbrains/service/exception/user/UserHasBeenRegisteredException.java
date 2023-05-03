package com.outerbrains.service.exception.user;

import com.outerbrains.base.exception.OuterBrainsException;

public class UserHasBeenRegisteredException extends OuterBrainsException {
    public UserHasBeenRegisteredException() {
        super("用户已经注册过！");
    }
    public UserHasBeenRegisteredException(String message) {
        super(message);
    }

}
