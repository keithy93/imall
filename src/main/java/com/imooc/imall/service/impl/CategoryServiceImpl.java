package com.imooc.imall.service.impl;

import com.imooc.imall.domain.ImoocMallCategory;
import com.imooc.imall.exception.ImoocMallException;
import com.imooc.imall.exception.ImoocMallExceptionEnum;
import com.imooc.imall.mapper.ImoocMallCategoryMapper;
import com.imooc.imall.request.AddCategoryReq;
import com.imooc.imall.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ImoocMallCategoryMapper categoryMapper;

    @Override
    public void add(AddCategoryReq addCategoryReq) {
        ImoocMallCategory category = new ImoocMallCategory();

        //将addCategoryReq中的属性拷贝到新建的category对象中
        BeanUtils.copyProperties(addCategoryReq, category);
        ImoocMallCategory categoryOld = categoryMapper.selectByName(category.getName());

        if (categoryOld != null) {
            throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTED);
        }
        int cnt = categoryMapper.insertSelective(category);
        if (cnt == 0)
            throw new ImoocMallException(ImoocMallExceptionEnum.CREATE_FAIL);
    }
}
