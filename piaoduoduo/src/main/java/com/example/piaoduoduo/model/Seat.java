package com.example.piaoduoduo.model;

import java.io.Serializable;
import lombok.Data;

/**
 * seat
 * @author 
 */
@Data
public class Seat implements Serializable {
    private Integer id;

    private Integer state;

    private Integer moviekey;

    private static final long serialVersionUID = 1L;
}