package com.example.piaoduoduo.service;

import cn.dev33.satoken.stp.StpUtil;
import com.example.piaoduoduo.mapper.MovieDao;
import com.example.piaoduoduo.mapper.SeatDao;
import com.example.piaoduoduo.mapper.UserDao;
import com.example.piaoduoduo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.piaoduoduo.mapper.OrderDao;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SeatService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private SeatDao seatDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private MovieDao movieDao;

        public void cancel(String key,Integer mid){
            Integer id =Integer.parseInt(StpUtil.getLoginId().toString());
            orderDao.cancel(id,Integer.parseInt(key),mid);
            User user=userDao.selectByPrimaryKey(id);
            Integer price=movieDao.selectByPrimaryKey(Integer.parseInt(key));
            user.setMoney(user.getMoney()+price);
            userDao.updateByPrimaryKeySelective(user);
            seatDao.canceled(mid);
        }

        public int order(Integer id,Integer i,Integer j,Integer key,Integer totalprice){
            Order order=new Order();Integer num=Integer.parseInt(StpUtil.getLoginId().toString());
            order.setId(num);order.setKey(key);order.setI(i.toString());order.setJ(j.toString());
            order.setMid(id); orderDao.insert(order);
            User user=userDao.selectByPrimaryKey(num);
            user.setMoney(user.getMoney()-totalprice);
            userDao.updateByPrimaryKeySelective(user);
            return seatDao.update(id);
        }

    public List<Seat> select(Integer key) throws IOException {
        if(StpUtil.isLogin())return seatDao.selectByMovieKey(key);
        return null;
    }

    public List<Movie> selectmovie(){
        return movieDao.selectMovie();
    }

    public List<OrderList> orderList(){
        Integer id=Integer.parseInt(StpUtil.getLoginId().toString());
        return orderDao.orderlist(id);
    }
}
