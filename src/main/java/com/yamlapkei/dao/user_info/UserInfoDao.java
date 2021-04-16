package com.yamlapkei.dao.user_info;

import com.yamlapkei.view.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoDao {
    UserInfo selectUser(@Param("name") String name, @Param("password") String password);
}
