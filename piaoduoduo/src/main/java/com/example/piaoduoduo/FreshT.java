package com.example.piaoduoduo;
import com.example.piaoduoduo.model.Seat;
import lombok.SneakyThrows;
import com.example.piaoduoduo.conntroller.Select;

import java.util.List;

public class FreshT implements Runnable{

    private Integer key;

    public FreshT(Integer key){
        this.key=key;
    }

    @SneakyThrows
    @Override
    public void run() {
        Select s=new Select();
        List<Seat> seatList = s.seatDao.selectByMovieKey(this.key);
        while (true){
            if(seatList.containsAll(s.seatDao.selectByMovieKey(key)))continue;
            seatList=s.seatDao.selectByMovieKey(key);
            s.sendInfo("999");
            Thread.sleep(100);
        }
    }
}
