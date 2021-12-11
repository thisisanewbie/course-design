package com.example.piaoduoduo.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.example.piaoduoduo.mapper.UserDao;
import com.example.piaoduoduo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public SaTokenInfo login(String name, String pwd){
        if(userDao.selectByName(name).equals(pwd)) {

            StpUtil.login(userDao.selectIdByName(name));
            return StpUtil.getTokenInfo();
        }
        return null;
    }

    public User userin(){
        return userDao.selectByPrimaryKey(Integer.parseInt(StpUtil.getLoginId().toString()));
    }
}
