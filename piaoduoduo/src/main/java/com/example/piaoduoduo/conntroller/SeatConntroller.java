package com.example.piaoduoduo.conntroller;
import cn.dev33.satoken.stp.StpUtil;
import com.example.piaoduoduo.mapper.MovieDao;
import com.example.piaoduoduo.mapper.OrderDao;
import com.example.piaoduoduo.mapper.SeatDao;
import com.example.piaoduoduo.mapper.UserDao;
import com.example.piaoduoduo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class SeatConntroller {

    @Autowired
    public SeatDao seatDao;
    @Autowired
    public MovieDao movieDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @GetMapping("select")
    public List<Seat> select(Integer key) throws IOException {
            if(StpUtil.isLogin())return seatDao.selectByMovieKey(key);
            return null;
    }

    @GetMapping("order")
    public int order(Integer id,Integer i,Integer j, String totalprice,Integer key){
        Order order=new Order();Integer num=Integer.parseInt(StpUtil.getLoginId().toString());
        order.setId(num);order.setKey(key);order.setI(i.toString());order.setJ(j.toString());
        orderDao.insert(order);
        User user=userDao.selectByPrimaryKey(num);
        user.setMoney(user.getMoney()-Integer.parseInt(totalprice));
        userDao.updateByPrimaryKeySelective(user);
        return seatDao.update(id);
    }

    @GetMapping("selectmovie")
    public List<Movie> selectmovie(){
            return movieDao.selectMovie();
    }

    @GetMapping("orderlist")
    public List<OrderList> orderList(){
        Integer id=Integer.parseInt(StpUtil.getLoginId().toString());
        return orderDao.orderlist(id);
    }

    @GetMapping("/giao")
    public String giao(){

        return "choubao";
    }
}
