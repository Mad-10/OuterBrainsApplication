package com.outerbrains.service.user;

import com.outerbrains.base.exception.OuterBrainsException;
import com.outerbrains.service.exception.user.UserHasBeenRegisteredException;
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

    public void login(User user) {

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
                throw new OuterBrainsException("由于未知原因，注册失败！注册信息：" + user);
            }
        }
    }

}
