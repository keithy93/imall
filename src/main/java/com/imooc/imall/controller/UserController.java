package com.imooc.imall.controller;

import com.imooc.imall.common.ApiRestResponse;
import com.imooc.imall.common.Constant;
import com.imooc.imall.domain.ImoocMallUser;
import com.imooc.imall.exception.ImoocMallException;
import com.imooc.imall.exception.ImoocMallExceptionEnum;
import com.imooc.imall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    public ApiRestResponse register(@RequestParam("id") Integer id, @RequestParam("username") String username, @RequestParam("password") String password) throws ImoocMallException {
        //判断用户名是否为空
        if (StringUtils.isEmpty(username))
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_USER_NAME);

        //判断密码是否为空
        if (StringUtils.isEmpty(password))
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_PASSWORD);

        //密码长度校验
        if (password.length() < 8)
            return ApiRestResponse.error(ImoocMallExceptionEnum.PASSWORD_TOO_SHORT);

        userService.register(id, username, password);
        return ApiRestResponse.success();
    }

    @PostMapping("/login")
    public ApiRestResponse login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) throws ImoocMallException {
        //判断用户名是否为空
        if (StringUtils.isEmpty(username))
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_USER_NAME);

        //判断密码是否为空
        if (StringUtils.isEmpty(password))
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_PASSWORD);

        ImoocMallUser user = userService.login(username, password);
        user.setPassword(null);
        httpSession.setAttribute(Constant.IMOOC_MALL_USER, user);
        return ApiRestResponse.success(user);
    }

    @PostMapping("/user/update")
    public ApiRestResponse updateUserInfo(HttpSession httpSession, @RequestParam("signature") String signature) throws ImoocMallException {
        ImoocMallUser currentUser = (ImoocMallUser)httpSession.getAttribute(Constant.IMOOC_MALL_USER);
        if (currentUser == null)
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_LOGIN);
        ImoocMallUser user = new ImoocMallUser();
        user.setId(currentUser.getId());
        user.setPersonalizedSignature(signature);
        userService.updateInfomation(user);
        return ApiRestResponse.success();
    }

    @PostMapping("/user/logout")
    public ApiRestResponse logout(HttpSession httpSession) {
        if (httpSession.getAttribute(Constant.IMOOC_MALL_USER) == null)
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_LOGIN);
        httpSession.removeAttribute(Constant.IMOOC_MALL_USER);
        return ApiRestResponse.success();
    }

    @PostMapping("/adminLogin")
    public ApiRestResponse adminLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) throws ImoocMallException {
        //判断用户名是否为空
        if (StringUtils.isEmpty(username))
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_USER_NAME);

        //判断密码是否为空
        if (StringUtils.isEmpty(password))
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_PASSWORD);

        ImoocMallUser user = userService.login(username, password);
        if (userService.checkAdminRole(user)) {
            user.setPassword(null);
            httpSession.setAttribute(Constant.IMOOC_MALL_USER, user);
            return ApiRestResponse.success(user);
        }
        return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_ADMIN);
    }
}
