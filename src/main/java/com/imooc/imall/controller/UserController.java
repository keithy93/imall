package com.imooc.imall.controller;

import com.imooc.imall.domain.ImoocMallUser;
import com.imooc.imall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/*
用户控制器
 */
@Controller
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/test")
    @ResponseBody
    public ImoocMallUser personalPage() {
        return userService.getUser();
    }
}
