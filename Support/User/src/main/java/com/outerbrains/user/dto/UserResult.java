package com.outerbrains.user.dto;

import com.outerbrains.base.result.OuterBrainsResult;
import com.outerbrains.base.result.OuterBrainsResultEnum;
import com.outerbrains.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResult extends OuterBrainsResult<User> {

    public UserResult(User user) {
        this.data = user;
    }

    public UserResult(String errorMessage) {
        super(errorMessage);
    }

    public UserResult(OuterBrainsResultEnum success) {
        super(success, null, null);
    }
}
