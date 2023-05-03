package com.outerbrains.service.user;

import com.outerbrains.base.exception.OuterBrainsException;
import com.outerbrains.service.exception.user.UserHaveNotBeenRegisiterException;
import com.outerbrains.service.exception.user.UserIncorrectPasswordException;
import com.outerbrains.user.dto.UserLoginResult;
import com.outerbrains.user.entity.User;
import com.outerbrains.user.mapper.UserMapper;
import com.outerbrains.service.exception.user.UserHasBeenRegisteredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserMapper userMapper;


    @Test
    void testLogin() throws OuterBrainsException {
        //创建要测试的UserService对象
        UserService userService = new UserService(userMapper);

        // 模拟用户对象
        User user = new User();
        user.setName("testUser");
        user.setPassword("testPassword");

        // 模拟从数据库中查询到的用户对象
        User dbUser = new User();
        dbUser.setName("testUser");
        dbUser.setPassword("testPassword");

        // 设置模拟行为
        Mockito.when(userMapper.findByName(user.getName())).thenReturn(dbUser);

        // 调用UserService的login方法
        UserLoginResult result = userService.login(user);

        // 验证是否成功登录
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getData().getName(), dbUser.getName());
        Assertions.assertEquals(result.getData().getPassword(), dbUser.getPassword());

        // 测试输入密码错误的情况
        user.setPassword("wrongPassword");
        Assertions.assertThrows(UserIncorrectPasswordException.class, () -> userService.login(user));

        // 测试用户未注册的情况
        Mockito.when(userMapper.findByName(user.getName())).thenReturn(null);
        Assertions.assertThrows(UserHaveNotBeenRegisiterException.class, () -> userService.login(user));
    }


    @Test
    void testRegister() throws OuterBrainsException {
        //创建要测试的UserService对象
        UserService userService = new UserService(userMapper);

        //创建一个新用户对象
        User newUser = new User();
        newUser.setName("test");
        newUser.setPassword("password");

        //模拟findByName方法返回null，即用户不存在
        Mockito.when(userMapper.findByName("test")).thenReturn(null);

        //模拟insert方法返回1，即插入一行新用户记录成功
        Mockito.when(userMapper.insert(Mockito.any(User.class))).thenReturn(1);

        //调用register方法进行测试
        userService.register(newUser);

        //验证是否成功插入新用户记录
        Mockito.verify(userMapper).insert(Mockito.any(User.class));
    }

    @Test
    void testRegisterThrowsException() {
        //创建要测试的UserService对象
        UserService userService = new UserService(userMapper);

        //创建一个已存在的用户对象
        User existingUser = new User();
        existingUser.setName("test");
        existingUser.setPassword("password");

        //模拟findByName方法返回existingUser，即用户已存在
        Mockito.when(userMapper.findByName("test")).thenReturn(existingUser);

        //调用register方法并验证是否抛出UserHasBeenRegisteredException异常
        Assertions.assertThrows(UserHasBeenRegisteredException.class, () -> userService.register(existingUser));

        //验证是否未调用insert方法
        Mockito.verify(userMapper, Mockito.never()).insert(Mockito.any(User.class));
    }

}
