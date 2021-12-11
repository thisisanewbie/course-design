package com.example.piaoduoduo.mapper;

import com.example.piaoduoduo.model.Order;
import com.example.piaoduoduo.model.OrderList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {
    int insert(Order record);

    int insertSelective(Order record);

    List<OrderList> orderlist(@Param("id") Integer id);

    void cancel(@Param("id") Integer id,@Param("key") Integer key,@Param("mid") Integer mid);
}