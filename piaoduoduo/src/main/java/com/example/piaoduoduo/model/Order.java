package com.example.piaoduoduo.model;

import java.io.Serializable;
import lombok.Data;

/**
 * order
 * @author 
 */
@Data
public class Order implements Serializable {
    private Integer mid;

    private Integer id;//user's id

    private Integer key;

    private String i;

    private String j;

    private static final long serialVersionUID = 1L;
}