package com.thomasvitale.bookservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

}

record Book(String title) {}

@RestController
class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping("books")
    public Iterable<Book> getBooks() {
        log.info("Returning list of books in the catalog");
        return List.of(
                new Book("His Dark Materials"),
                new Book("The Hobbit"),
                new Book("The Lord of the Rings"));
    }

}
