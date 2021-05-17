package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "tb_student")
public class Student {

    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    @TableField(value = "stu_name")
    private String stuName;
    private Date borndate;

    private String email;
    @TableField(exist = false)
    private Integer age;


}
