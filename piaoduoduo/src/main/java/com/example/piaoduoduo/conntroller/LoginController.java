package com.example.piaoduoduo.conntroller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.example.piaoduoduo.mapper.UserDao;
import com.example.piaoduoduo.model.User;
import com.example.piaoduoduo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    public LoginService loginService;

    @GetMapping("islogin")
    public boolean islogin(){
        return StpUtil.isLogin();
    }


    @GetMapping("login")
    public SaTokenInfo login(String name, String pwd){
        return loginService.login(name, pwd);
    }

    @GetMapping("logout")
    public void logout(){
        StpUtil.logout();
    }

    @GetMapping("/userin")
    public User userin(){
        return loginService.userin();
    }
}
