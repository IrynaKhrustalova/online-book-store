package org.example.service;

import jakarta.transaction.Transactional;
import java.util.List;
import org.example.dto.BookDto;
import org.example.dto.CreateBookRequestDto;
import org.example.exception.EntityNotFoundException;
import org.example.mapper.BookMapper;
import org.example.model.Book;
import org.example.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto save(CreateBookRequestDto createDto) {
        Book entity = bookMapper.toEntity(createDto);
        Book saved = bookRepository.save(entity);
        return bookMapper.toDto(saved);
    }

    @Override
    public List<BookDto> findAll() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Book with id " + id + " not found"));
        return bookMapper.toDto(book);
    }
}
