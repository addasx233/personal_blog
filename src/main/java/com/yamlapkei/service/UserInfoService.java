package com.yamlapkei.service;

import com.yamlapkei.dao.user_info.UserInfoDao;
import com.yamlapkei.view.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserInfoService")
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    public UserInfo selectUser(String name,String password){
        return userInfoDao.selectUser(name,password);
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }
}
