package com.shihe.caching.dao;

import com.shihe.caching.pojo.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @ClassName SimpleBookRepository
 * @Description TODO
 * @Author admin
 * @Date 2020-11-30 10:07
 * @Version 1.0
 */
@Component
public class SimpleBookRepository implements BookRepository{
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        System.out.println(isbn+"===========");
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
