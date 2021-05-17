package com.cssl.controller;

import com.cssl.bean.Book;
import com.cssl.service.BookService1;
import com.cssl.service.BookService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController1 {

    @Autowired
    private BookService1 bookService1;


    @RequestMapping("/mongo/save")
    public String saveObj(@RequestBody Book book) {
        //book=new Book();

        return bookService1.saveBook(book);
    }

    @RequestMapping("/mongo/findAll")
    public List<Book> findAll() {
        return bookService1.findAll();
    }

    @RequestMapping("/mongo/findOne")
    public Book findOne(@RequestParam String id) {

        return bookService1.getBookById(id);
    }

    @RequestMapping("/mongo/findOneByName")
    public Book findOneByName(@RequestParam String name) {
        return bookService1.getBookByName(name);
    }

    @RequestMapping("/mongo/update")
    public String update(@RequestBody Book book) {
        return bookService1.updateBook(book);
    }

    @RequestMapping("/mongo/delOne")
    public String delOne(@RequestBody Book book) {
        return bookService1.deleteBook(book);
    }

    @RequestMapping("/mongo/delById")
    public String delById(@RequestParam String id) {

        return bookService1.deleteBookById(id);
    }

}
