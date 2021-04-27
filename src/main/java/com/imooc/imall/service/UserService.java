package com.imooc.imall.service;

import com.imooc.imall.domain.ImoocMallUser;

public interface UserService {
    ImoocMallUser getUser();
    void register(String username, String password);
}
