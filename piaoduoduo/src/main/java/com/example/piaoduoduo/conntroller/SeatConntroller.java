package com.example.piaoduoduo.conntroller;
import com.example.piaoduoduo.mapper.MovieDao;
import com.example.piaoduoduo.mapper.OrderDao;
import com.example.piaoduoduo.mapper.SeatDao;
import com.example.piaoduoduo.model.*;
import com.example.piaoduoduo.service.SeatService;
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
    private SeatService seatService;

    @GetMapping("select")
    public List<Seat> select(Integer key) throws IOException {
            return seatService.select(key);
    }

    @GetMapping("order")
    public int order(Integer id,Integer i,Integer j,Integer key,Integer totalprice){
        return seatService.order(id,i,j,key,totalprice);
    }

    @GetMapping("cancel")
    public void cancel(String key,Integer mid){
        seatService.cancel(key,mid);
    }

    @GetMapping("selectmovie")
    public List<Movie> selectmovie(){
            return seatService.selectmovie();
    }

    @GetMapping("orderlist")
    public List<OrderList> orderList(){
        return seatService.orderList();
    }

}
