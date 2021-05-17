package com.cssl.controller;

import com.cssl.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/test")
    public  List<Book> getTest(){
        List<Book> books = mongoTemplate.findAll(Book.class);


        return books;
    }

    @RequestMapping("/test2")
    public  Book getTest2(){
        Book book=new Book();
        book.setName("茶颜悦色");
        book.setId("555");
        book.setDesc("这就是网红效应，群羊效应");

        Book save = mongoTemplate.save(book);


        return save;
    }

    @RequestMapping("/test3")
    public  Book getTest2(@RequestBody Book book){


        Book save = mongoTemplate.save(book);


        return save;
    }
}
