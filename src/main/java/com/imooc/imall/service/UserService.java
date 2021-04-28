package com.imooc.imall.service;

import com.imooc.imall.domain.ImoocMallUser;
import com.imooc.imall.exception.ImoocMallException;

public interface UserService {
    ImoocMallUser getUser();
    void register(Integer id, String username, String password) throws ImoocMallException;
}
