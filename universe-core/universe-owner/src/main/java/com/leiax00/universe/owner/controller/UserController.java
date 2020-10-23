package com.leiax00.universe.owner.controller;

import org.leiax00.universe.common.bean.dto.BaseFilterCond;
import org.leiax00.universe.common.bean.dto.PageCond;
import com.leiax00.universe.owner.service.UserService;
import org.leiax00.universe.common.bean.dto.PageRst;
import org.leiax00.universe.common.bean.dto.ResponseRst;
import org.leiax00.universe.owner.api.bean.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/query/all")
    public ResponseRst<PageRst<UserInfo>> queryAll(PageCond<BaseFilterCond> pageCond) {
        return ResponseRst.<PageRst<UserInfo>>build()
                .withData(userService.queryAll(pageCond))
                .withOk();
    }
}
