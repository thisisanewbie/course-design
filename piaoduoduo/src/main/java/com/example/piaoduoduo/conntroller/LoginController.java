package com.example.piaoduoduo.conntroller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.example.piaoduoduo.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    public UserDao userDao;

    @GetMapping("islogin")
    public boolean islogin(){
        return StpUtil.isLogin();
    }


    @GetMapping("login")
    public SaTokenInfo login(String name, String pwd){
        if(userDao.selectByName(name).equals(pwd)) {

            StpUtil.login(userDao.selectIdByName(name));
            return StpUtil.getTokenInfo();
        }
        return null;
    }

    @GetMapping("logout")
    public void logout(){
        StpUtil.logout();
    }
}
