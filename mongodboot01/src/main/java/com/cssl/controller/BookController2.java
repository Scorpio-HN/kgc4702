package com.cssl.controller;

import com.cssl.bean.Book;
import com.cssl.service.BookService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController2 {

    @Autowired
    private BookService2 bookService2;


    @RequestMapping("/mongo/save2")
    public String saveObj(@RequestBody Book book) {
        //book=new Book();

        return bookService2.saveBook(book);
    }

    @RequestMapping("/mongo/findAll2")
    public List<Book> findAll() {
        return bookService2.findAll();
    }


    @RequestMapping("/mongo/findById2")
    public Book findById(Integer id){
        return bookService2.findById(id);
    }

}
