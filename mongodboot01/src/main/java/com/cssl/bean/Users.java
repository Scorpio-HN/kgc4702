package com.cssl.bean;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by tym on 2018/8/31 0031.
 */
//这个是让保存到数据库时候，默认表名为这个名字
@Document(collection = "Users")
public class Users implements Serializable {

    @Id
    private Integer id;
    private String name;
    private int age;

    public Users() {

    }

    public Users(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
