package com.cssl.service;

import com.cssl.bean.Book;
import com.cssl.dao.BookMongoDbDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService2 {

    @Autowired
    private BookMongoDbDao bookMongoDbDao;


    //添加对象
    public String saveBook(Book book){
        System.out.println("mongoDB--saveBook");
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());

        bookMongoDbDao.save(book);
        return "添加成功";
    }


    //查询全部
    public List<Book> findAll(){
        System.out.println("mongoDB--findAll");
        Book book=new Book();
        return bookMongoDbDao.queryList(book);
    }


    //根据id查询
    public Book findById(Integer id){
        Book book = bookMongoDbDao.queryById(id);
        return book;
    }

}
