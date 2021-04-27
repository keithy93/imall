package com.imooc.imall.service.impl;

import com.imooc.imall.domain.ImoocMallUser;
import com.imooc.imall.mapper.ImoocMallUserMapper;
import com.imooc.imall.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    ImoocMallUserMapper imoocMallUserMapper;

    @Override
    public ImoocMallUser getUser() {
        return imoocMallUserMapper.selectByPrimaryKey(1);
    }
}
