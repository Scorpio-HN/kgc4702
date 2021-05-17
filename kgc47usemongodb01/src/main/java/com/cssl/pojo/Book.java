package com.cssl.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("book")
public class Book {
    @Id
    private String id;
    private String name;
    private String desc;
}
