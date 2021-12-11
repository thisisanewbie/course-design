package com.example.piaoduoduo.mapper;

import com.example.piaoduoduo.model.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieDao {
    int deleteByPrimaryKey(Integer key);

    int insert(Movie record);

    int insertSelective(Movie record);

    int selectByPrimaryKey(@Param("key") Integer key);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    List<Movie> selectMovie();
}