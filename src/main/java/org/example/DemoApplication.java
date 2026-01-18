package org.example;

import java.math.BigDecimal;
import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BookService bookService) {
        return args -> {
            // sample data
            Book book = new Book("Effective Java", "Joshua Bloch", "978-0134685991",
                    BigDecimal.valueOf(45.00), "A must-read for Java devs", null);
            bookService.save(book);

            System.out.println("Books in DB: " + bookService.findAll().size());
        };
    }
}
