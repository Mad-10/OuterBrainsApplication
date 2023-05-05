package com.outerbrains.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outerbrains.service.exception.user.UserHasBeenRegisteredException;
import com.outerbrains.service.exception.user.UserHaveNotBeenRegisiterException;
import com.outerbrains.service.exception.user.UserIncorrectPasswordException;
import com.outerbrains.user.dto.UserResult;
import com.outerbrains.user.entity.User;
import com.outerbrains.user.mapper.UserMapper;

@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 用户登录
     *
     * @param user 登录用户的信息
     * @return 返回用户信息
     * @throws UserHaveNotBeenRegisiterException 当用户尚未注册时，抛出此异常
     * @throws UserIncorrectPasswordException    当用户输入的密码不正确时，抛出此异常
     */
    public UserResult login(User user) throws UserHaveNotBeenRegisiterException, UserIncorrectPasswordException {
        Optional<User> optional = Optional.ofNullable(userMapper.findByName(user.getName()));
        User result = optional.orElseThrow(() -> new UserHaveNotBeenRegisiterException("用户" + user.getName() + "尚未注册！"));

        if (!user.getPassword().equals(result.getPassword())) {
            throw new UserIncorrectPasswordException();
        }
        result.setPassword("********");
        return new UserResult(result);
    }
    /**
     * 用户注册
     *
     * @param user 要注册的用户信息
     * @return 注册成功返回 1，失败返回 0
     * @throws UserHasBeenRegisteredException 当用户已经注册过时，抛出此异常
     */
    public int register(User user) throws UserHasBeenRegisteredException {
        User existingUser = userMapper.findByName(user.getName());
        if (existingUser != null) {
            throw new UserHasBeenRegisteredException("用户" + user.getName() + "已经注册过。");
        } else {
            System.out.println(user);
            User newUser = new User(user.getName(), user.getPassword());
            return userMapper.insert(newUser);
        }
//        Optional<User> optional = Optional.ofNullable(userMapper.findByName(user.getName()));
//        User existingUser = optional.orElseGet(() -> {
//            userMapper.insert(user);
//            return user;
//        });
//        throw new UserHasBeenRegisteredException("用户" + user.getName() + "已经注册过。");
    }

}
