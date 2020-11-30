package com.shihe.caching.runner;

import com.shihe.caching.dao.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName AppRunner2
 * @Description TODO
 * @Author admin
 * @Date 2020-11-30 10:48
 * @Version 1.0
 */
@Component
@Order(value = 2)
public class AppRunner3 implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(AppRunner3.class);

    private BookRepository bookRepository;

    public AppRunner3(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(".... Fetching books");
        log.info("isbn-2 -->" + bookRepository.getByIsbn("isbn-2"));
    }
}
