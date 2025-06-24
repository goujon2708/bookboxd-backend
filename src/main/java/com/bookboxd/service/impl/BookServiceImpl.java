package com.bookboxd.service.impl;

import com.bookboxd.model.Book;
import com.bookboxd.service.BookService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getBooks(String query) {

        List<Book> results = new ArrayList<>();
        if (query == null || query.isBlank()) return results;

        results.add(new Book(1L, "Harry Potter à l'école des sorciers", "J.K. Rowling"));
        results.add(new Book(2L, "Harry Potter et la chambre des secrets", "J.K. Rowling"));
        results.add(new Book(3L, "Le Seigneur des Anneaux", "J.R.R. Tolkien"));

        return results.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }
}
