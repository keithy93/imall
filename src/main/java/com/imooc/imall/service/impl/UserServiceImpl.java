package com.imooc.imall.service.impl;

import com.imooc.imall.domain.ImoocMallUser;
import com.imooc.imall.domain.ImoocMallUserExample;
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

    @Override
    public void register(String username, String password) {
        //查询用户名是否存在，不允许重名
//        ImoocMallUserExample userExample = new ImoocMallUserExample();
//        ImoocMallUserExample.Criteria criteria = userExample.createCriteria();
        ImoocMallUser user = imoocMallUserMapper.selectByName(username);
        if (user != null)
            return;
    }
}
