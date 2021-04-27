package com.imooc.imall.controller;

import com.imooc.imall.common.ApiRestResponse;
import com.imooc.imall.domain.ImoocMallUser;
import com.imooc.imall.exception.ImoocMallExceptionEnum;
import com.imooc.imall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
用户控制器
 */
@RestController
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/test")
    public ImoocMallUser personalPage() {
        return userService.getUser();
    }

    @PostMapping("/register")
    public ApiRestResponse register(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (StringUtils.isEmpty(username)) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_PASSWORD);
        }
        //密码长度校验
        if (password.length() < 8) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.PASSWORD_TOO_SHORT);
        }

    }
}
