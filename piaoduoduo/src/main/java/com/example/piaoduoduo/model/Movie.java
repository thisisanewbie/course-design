package com.example.piaoduoduo.model;

import java.io.Serializable;
import lombok.Data;

/**
 * movie
 * @author 
 */
@Data
public class Movie implements Serializable {
    private Integer key;

    private String price;

    private String oriprice;

    private String thumb;

    private String title;

    private String tag;

    private String desc;

    private static final long serialVersionUID = 1L;
}