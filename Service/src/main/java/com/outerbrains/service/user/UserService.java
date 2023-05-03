package com.outerbrains.service.user;

import com.outerbrains.base.exception.OuterBrainsException;
import com.outerbrains.service.exception.user.UserHasBeenRegisteredException;
import com.outerbrains.service.exception.user.UserHaveNotBeenRegisiterException;
import com.outerbrains.service.exception.user.UserIncorrectPasswordException;
import com.outerbrains.user.dto.UserLoginResult;
import com.outerbrains.user.entity.User;
import com.outerbrains.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserService {


    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserLoginResult login(User user) throws UserHaveNotBeenRegisiterException, UserIncorrectPasswordException {
        //先判断用户是否注册过，如果还没有注册，抛出异常
        User result = userMapper.findByName(user.getName());
        if (result == null) {
            throw new UserHaveNotBeenRegisiterException("用户" + user.getName() + "尚未注册！");
        } else {//如果已经注册了，继续登录
            if (user.getPassword().equals(result.getPassword())) {
                return new UserLoginResult(result);
            } else {
                throw new UserIncorrectPasswordException();
            }
        }
    }

    public void register(User user) throws OuterBrainsException {
        //先根据用户名判断用户是否存在，存在则抛出异常
        User result = userMapper.findByName(user.getName());
        if (result != null) {
            throw new UserHasBeenRegisteredException();
        } else {
            //如果不存在，就将用户信息添加到数据库
            result = user;
            user = new User();
            user.setName(result.getName());
            user.setPassword(result.getPassword());
            int affectedRow = userMapper.insert(user);
            if (affectedRow <= 0) {
                throw new OuterBrainsException("由于未知原因，在向数据库新增记录时失败！注册信息：" + user);
            }
        }
    }

}
