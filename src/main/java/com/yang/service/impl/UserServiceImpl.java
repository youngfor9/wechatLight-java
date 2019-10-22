package com.yang.service.impl;


import com.yang.Utils.JsonUtils;

import com.yang.dao.UserMapper;

import com.yang.entity.UserInfo;
import com.yang.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.Collator;
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
        Long id;
        if (user == null) {
            userInfo.setuTime(new Date());
            userInfo.setcTime(new Date());
            id = userMapper.insertUser(userInfo);
        } else {
            user.setuTime(new Date());
            if(null == user.getScore()){
                user.setScore(0l);
            }
            if (userInfo.getLastScore() != null) {
                user.setLastScore(userInfo.getScore());
                user.setScore(user.getScore() + userInfo.getScore());
            }
            id = userMapper.updateUser(user);
        }
        Map<String, Object> res = new HashMap<>();
        if (id != null) {
            res.put("status", 1);
            res.put("msg", "保存成功");
        }
        return res;
    }

    //获取user对象
    @Override
    public UserInfo getUser(String nickName) {
        UserInfo user = userMapper.getUser(nickName);
        if(null == user) return null;
        Long score = user.getScore();
        if(null == score){
            user.setRank("0");
            user.setScore(0l);
            return user;
        }
        List<String> sameUsers = new ArrayList<String>();
        //只计算20以内
        List<UserInfo> users = getUsers(20);
        long rank = -1;
        //20名开外不进行排序
        for (int i = 0; i < users.size(); i++) {
            Long perScore = users.get(i).getScore();
            if(null == perScore) continue;
            if (  perScore == score) {
                sameUsers.add(users.get(i).getNickName());
            }
            if (perScore <= score && rank==-1 ) {
                rank = i+1;
            }
        }
        //重复
        if (sameUsers.size() > 1) {
            String[] strs = new String[sameUsers.size()];
            sameUsers.toArray(strs);
            //进行名字排序
            Comparator<Object> model = Collator.getInstance(java.util.Locale.CHINA);
            Arrays.sort(strs, model);
            String target = user.getNickName();
            String temp = strs[0];
            int len = strs.length;
            int i = 1;
            while (!target.equals(temp)&&i < len) {
                rank++;
                temp = strs[i];
                i++;
            }
        }
        user.setRank(rank+"");
        return user;
    }

    @Override
    public List<UserInfo> getUsers(Integer num) {
        return userMapper.getUsers(num);
    }
}
