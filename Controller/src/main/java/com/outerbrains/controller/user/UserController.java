package com.outerbrains.controller.user;

import com.outerbrains.user.dto.UserLoginParameter;
import com.outerbrains.user.dto.UserLoginResult;
import com.outerbrains.user.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public ResponseEntity<UserLoginResult> login(@RequestBody UserLoginParameter userLoginParameter) {
        User user = userLoginParameter.getData();
        return  null;
    }
}
