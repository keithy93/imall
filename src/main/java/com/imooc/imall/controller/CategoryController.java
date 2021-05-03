package com.imooc.imall.controller;

import com.imooc.imall.common.ApiRestResponse;
import com.imooc.imall.common.Constant;
import com.imooc.imall.domain.ImoocMallUser;
import com.imooc.imall.exception.ImoocMallExceptionEnum;
import com.imooc.imall.request.AddCategoryReq;
import com.imooc.imall.service.CategoryService;
import com.imooc.imall.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CategoryController {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    @ApiOperation("后台添加目录")
    @PostMapping("/admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(HttpSession httpSession, @Valid @RequestBody AddCategoryReq addCategoryReq) {
        if (addCategoryReq.getName() == null || addCategoryReq.getType() == null || addCategoryReq.getParentId() == null || addCategoryReq.getOrderNum() == null) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.PARA_NOT_NULL);
        }
        ImoocMallUser currentUser = (ImoocMallUser) httpSession.getAttribute(Constant.IMOOC_MALL_USER);
        //校验用户是否登录
        if (currentUser == null)
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_LOGIN);
        //校验用户是否为管理员
        boolean adminRole = userService.checkAdminRole(currentUser);
        if (adminRole) {
            categoryService.add(addCategoryReq);
            return ApiRestResponse.success();
        }
        else {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_ADMIN);
        }
    }

}
