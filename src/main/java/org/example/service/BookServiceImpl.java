package org.example.service;

import jakarta.transaction.Transactional;
import java.util.List;
import org.example.model.Book;
import org.example.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
