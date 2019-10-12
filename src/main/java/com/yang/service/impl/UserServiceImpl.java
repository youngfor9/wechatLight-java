package com.yang.service.impl;


import com.yang.Utils.JsonUtils;

import com.yang.dao.UserMapper;

import com.yang.entity.UserInfo;
import com.yang.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    //保存user对象
    @Override
    public Object saveUser(UserInfo userInfo) {
       // UserInfo userInfo = (UserInfo) JsonUtils.toObject(data, UserInfo.class);
        UserInfo user = getUser(userInfo.getNickName());
        Long id ;
        if (user == null) {
            userInfo.setuTime(new Date());
            userInfo.setcTime(new Date());
            userInfo.setScore(user.getScore()+userInfo.getLastScore());
             id = userMapper.insertUser(userInfo);
        }else{
            userInfo.setuTime(new Date());
            id = userMapper.updateUser(userInfo);
        }
        Map<String,Object> res = new HashMap<>();
        if(id!=null){
            res.put("status",1);
            res.put("msg","保存成功");
        }
        return res;
    }
    //获取user对象
    @Override
    public UserInfo getUser(String  nickName) {
        return userMapper.getUser(nickName);
    }
}
