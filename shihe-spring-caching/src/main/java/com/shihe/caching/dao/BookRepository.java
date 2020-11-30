package com.shihe.caching.dao;

import com.shihe.caching.pojo.Book;

/**
 * @ClassName BookRepository
 * @Description TODO
 * @Author admin
 * @Date 2020-11-30 10:06
 * @Version 1.0
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
