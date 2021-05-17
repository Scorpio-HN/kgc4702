package com.cssl.service;

import com.cssl.bean.Book;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Service中主要来实现CURD的操作
 * 此处需要说明的是Mongodb的修改操作大致有3种：
 *
 * mongoTemplate.updateFirst操作：修改第一条
 * mongoTemplate.updateMulti操作：修改符合条件的所有
 * this.mongoTemplate.upsert操作：修改时如果不存在则添加.

 * */



@Service
public class BookService1 {


    //注入模板
    @Autowired
    private MongoTemplate mongoTemplate;


    //添加对象
    public String saveBook(Book book){
        System.out.println("mongoDB--saveBook");
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());

        mongoTemplate.save(book);
        return "添加成功";
    }


    //查询全部
    public List<Book> findAll(){
        System.out.println("mongoDB--findAll");
        return mongoTemplate.findAll(Book.class);
    }

    //根据id查询
    public Book getBookById(String id){
        System.out.println("mongoDB--getBookById");

        //创建查询条件
        Query query=new Query(Criteria.where("_id").is(id));

        return mongoTemplate.findOne(query,Book.class);

    }


    //根据名字查询
    public Book getBookByName(String name){
        System.out.println("mongoDB--getBookByName");

        //创建查询条件
        Query query=new Query(Criteria.where("name").is(name));

        return mongoTemplate.findOne(query,Book.class);
    }



    //修改对象
    public String updateBook(Book book){
         System.out.println("MongodDB--updateBook");
         //Query query=new Query(Criteria.where("id").is(book.getId()));

         Query query=new Query();
         Update upate=
                 new Update().set("publish",book.getPublish())
                 .set("info",book.getInfo())
                 .set("updateTime",book.getUpdateTime())
                 .set("name",book.getName())
                 .set("price",book.getPrice());

         //upadteFirst 更新查询返回结果集的第一条
        UpdateResult updateResult = mongoTemplate.updateFirst(query, upate, Book.class);

        //更新查询返回结果集的全部
        //UpdateResult updateResult = mongoTemplate.updateMulti(query, upate, Book.class);


        //更新对象不存在就去添加
        //UpdateResult updateResult = mongoTemplate.upsert(query, upate, Book.class);
        //System.out.println("结果："+updateResult);

        return "success";
    }


    //删除对象
    public String deleteBook(Book book){
        System.out.println("deleteBook删除对象");
        DeleteResult remove = mongoTemplate.remove(book);

        System.out.println("输出删除对象："+remove);

        return "success";
    }



    //根据id删除
    public String deleteBookById(String id){
        System.out.println("根据id删除******deleteBookById");
        Book book = getBookById(id);
         return  deleteBook(book);

    }

}
