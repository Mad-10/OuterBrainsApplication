package com.outerbrains.controller.user;

import com.outerbrains.base.result.OuterBrainsResultEnum;
import com.outerbrains.controller.exception.NotFoundUserInfoException;
import com.outerbrains.service.exception.user.UserHasBeenRegisteredException;
import com.outerbrains.service.exception.user.UserHaveNotBeenRegisiterException;
import com.outerbrains.service.exception.user.UserIncorrectPasswordException;
import com.outerbrains.service.user.UserService;
import com.outerbrains.user.dto.UserParameter;
import com.outerbrains.user.dto.UserResult;
import com.outerbrains.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResult> login(@RequestBody UserParameter userParameter) {
        UserResult result;
        try {
            if (userParameter.getData() == null) {
                throw new NotFoundUserInfoException();
            }
            result = userService.login(userParameter.getData());
            return ResponseEntity.ok(result);
        } catch (UserHaveNotBeenRegisiterException | UserIncorrectPasswordException | NotFoundUserInfoException e) {
            result = new UserResult(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserResult> register(@RequestBody UserParameter userParameter) {
        try {
            User user = new User(userParameter.getData().getName(), userParameter.getData().getPassword());
            int result = userService.register(user);
            if (result > 0) {
                return ResponseEntity.ok(new UserResult(OuterBrainsResultEnum.SUCCESS));
            } else {
                return ResponseEntity.badRequest().body(new UserResult("注册失败！原因：在向数据库增加记录时，操作失败！"));
            }
        } catch (UserHasBeenRegisteredException e) {
            return ResponseEntity.badRequest().body(new UserResult(e.getMessage()));
        }
    }

}
