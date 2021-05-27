package com.LBY.web.demo.servicec.impl;

import com.LBY.web.demo.servicec.UserService;


public class UserServiceImpl implements UserService {
    @Override
    public String getUserName(String name) {
        return name+"回家！";
    }
}
