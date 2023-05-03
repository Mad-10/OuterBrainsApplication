package com.outerbrains.user.dto;

import com.outerbrains.base.result.OuterBrainsResult;
import com.outerbrains.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginResult extends OuterBrainsResult<User> {

    public UserLoginResult(User user) {
        this.data = user;
    }
}
