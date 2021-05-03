package com.imooc.imall.service.impl;

import com.imooc.imall.domain.ImoocMallUser;
import com.imooc.imall.domain.ImoocMallUserExample;
import com.imooc.imall.exception.ImoocMallException;
import com.imooc.imall.exception.ImoocMallExceptionEnum;
import com.imooc.imall.mapper.ImoocMallUserMapper;
import com.imooc.imall.service.UserService;
import com.imooc.imall.util.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    ImoocMallUserMapper imoocMallUserMapper;

    @Override
    public ImoocMallUser getUser() {
        return imoocMallUserMapper.selectByPrimaryKey(1);
    }

    @Override
    public void register(Integer id, String username, String password) throws ImoocMallException {
        //查询用户名是否存在，不允许重名
//        ImoocMallUserExample userExample = new ImoocMallUserExample();
//        ImoocMallUserExample.Criteria criteria = userExample.createCriteria();
        ImoocMallUser result = imoocMallUserMapper.selectByName(username);
        if (result != null)
            throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTED);
        ImoocMallUser user = new ImoocMallUser();
        user.setId(id);
        user.setUsername(username);
        try {
            user.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        int count = imoocMallUserMapper.insertSelective(user);
        if (count == 0)
            throw new ImoocMallException(ImoocMallExceptionEnum.INSERT_FAILED);
    }

    @Override
    public ImoocMallUser login(String username, String password) throws ImoocMallException {
        String md5 = null;
        try {
            md5 = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        ImoocMallUser user = imoocMallUserMapper.selectByLogin(username, password);
        if (user == null)
            throw new ImoocMallException(ImoocMallExceptionEnum.WRONG_PASSWORD);
        return user;
    }

    @Override
    public void updateInfomation(ImoocMallUser user) throws ImoocMallException {
        int updateCnt = imoocMallUserMapper.updateByPrimaryKeySelective(user);
        if (updateCnt > 1)
            throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }

    @Override
    public boolean checkAdminRole(ImoocMallUser user) {
        return user.getRole().equals(2);
    }
}
