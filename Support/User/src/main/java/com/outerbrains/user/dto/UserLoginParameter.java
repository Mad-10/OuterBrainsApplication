package com.outerbrains.user.dto;

import com.outerbrains.base.parameter.OuterBrainsParameter;
import com.outerbrains.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginParameter extends OuterBrainsParameter<User> {

}
