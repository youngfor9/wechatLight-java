package com.yang.dao;

import com.yang.entity.UserInfo;

import java.util.List;

public interface UserMapper {
    //获取user
   UserInfo getUser(String nickName);
    //更新user
    Long updateUser(UserInfo userInfo);
    //新建user
    Long insertUser(UserInfo userInfo);
    //获取user列表
    List<UserInfo> getUsers(int num);
}
