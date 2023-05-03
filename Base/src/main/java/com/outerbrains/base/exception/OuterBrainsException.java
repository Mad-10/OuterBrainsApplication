package com.outerbrains.base.exception;

public class OuterBrainsException extends Exception{
    public OuterBrainsException() {
        super("OuterBrains 默认异常。");
    }
    public OuterBrainsException(String message) {
        super(message);
    }

}
