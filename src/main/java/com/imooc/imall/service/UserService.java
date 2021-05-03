package com.imooc.imall.service;

import com.imooc.imall.domain.ImoocMallUser;
import com.imooc.imall.exception.ImoocMallException;

public interface UserService {
    ImoocMallUser getUser();
    void register(Integer id, String username, String password) throws ImoocMallException;

    ImoocMallUser login(String username, String password) throws ImoocMallException;

    void updateInfomation(ImoocMallUser user) throws ImoocMallException;

    boolean checkAdminRole(ImoocMallUser user);
}
