package com.example.piaoduoduo.conntroller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.piaoduoduo.mapper.UserDao;
import com.example.piaoduoduo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/userin")
    public User userin(){
        return userDao.selectByPrimaryKey(Integer.parseInt(StpUtil.getLoginId().toString()));
    }
}
