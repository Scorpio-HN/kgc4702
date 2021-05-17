package com.cssl.dao;

import com.cssl.bean.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMongoDbDao extends MongoDbDao<Book> {
    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }



}
