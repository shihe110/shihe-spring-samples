package com.shihe.caching.controller;

import com.shihe.caching.dao.BookRepository;
import com.shihe.caching.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author admin
 * @Date 2020-11-30 10:03
 * @Version 1.0
 */
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("getBook")
    public String getBook(){
        Book byIsbn = bookRepository.getByIsbn("isbn-1234");
        return byIsbn.toString();
    }
}
