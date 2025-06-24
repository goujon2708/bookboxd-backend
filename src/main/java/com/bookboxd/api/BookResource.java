package com.bookboxd.api;

import com.bookboxd.model.Book;
import com.bookboxd.service.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    private BookService bookService;

    @GET
    @Path("/search")
    public List<Book> getBooks(@QueryParam("query") String query) {

        return bookService.getBooks(query);
    }
}
