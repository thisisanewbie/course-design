package com.example.piaoduoduo.mapper;

import com.example.piaoduoduo.model.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SeatDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Seat record);

    int insertSelective(Seat record);

    Seat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);

    int update(Integer id);

    void canceled(@Param("id") Integer id);

    List<Seat> selectByMovieKey(Integer moviekey);
}