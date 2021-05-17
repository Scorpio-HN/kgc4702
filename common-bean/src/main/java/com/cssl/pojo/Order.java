package com.cssl.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Order implements Serializable {
 private String oid;
 private Integer user_id;
 private Integer money;
 private Integer status;



}
