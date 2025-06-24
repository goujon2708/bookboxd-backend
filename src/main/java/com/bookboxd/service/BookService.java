package com.bookboxd.service;

import com.bookboxd.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks(String query);
}
