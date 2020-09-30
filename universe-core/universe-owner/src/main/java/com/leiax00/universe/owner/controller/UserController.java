package com.leiax00.universe.owner.controller;

import com.leiax00.universe.owner.service.UserService;
import org.leiax00.universe.common.bean.dto.ResponseRst;
import org.leiax00.universe.owner.api.bean.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/find/name/{username}")
    public ResponseRst<UserInfo> findByUsername(@PathVariable String username) {
        return ResponseRst.<UserInfo>build()
                .withData(userService.findByUsername(username))
                .withOk();
    }
}
