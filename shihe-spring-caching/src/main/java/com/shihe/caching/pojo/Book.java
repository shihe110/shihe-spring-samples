package com.shihe.caching.pojo;

/**
 * @ClassName Book
 * @Description TODO
 * @Author admin
 * @Date 2020-11-30 10:05
 * @Version 1.0
 */
public class Book {
    private String isbn;
    private String title;

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
