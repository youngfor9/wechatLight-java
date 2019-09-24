package com.yang.controller;
import com.yang.Utils.JsonUtils;
import com.yang.entity.UserInfo;
import com.yang.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(@RequestBody UserInfo userInfo) {
        return JsonUtils.toJsonString(this.userService.saveUser(userInfo));
    }
    @RequestMapping("/getUser")
    public String getUser(String nickName) {
        return JsonUtils.toJsonString(this.userService.getUser(nickName));
    }
}
