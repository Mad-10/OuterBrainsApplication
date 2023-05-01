package com.outerbrains.base.result;

public enum OuterBrainsResultEnum implements OuterBrainsResultInterface {
    SUCCESS(0, "操作成功！"),
    FAILURE(-1, "操作失败！");

    private final Integer code;
    private final String message;

    OuterBrainsResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
