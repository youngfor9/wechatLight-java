package com.yang.service;

import com.yang.entity.AnswerInfo;
import com.yang.entity.UserInfo;

import java.util.List;

public interface UserService {

    Object saveUser(UserInfo data);

    UserInfo getUser(String nickName);

    List<UserInfo> getUsers(Integer num);
}
