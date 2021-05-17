package com.cssl.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Account implements Serializable {
    private Integer aid;
    private Integer user_id;
    private Integer total;
    private Integer used;
    private Integer reside;

}
