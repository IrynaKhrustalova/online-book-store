package org.example.repository;

import java.util.List;
import java.util.Optional;
import org.example.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByIsDeletedFalse(Pageable pageable);

    Optional<Book> findByIdAndIsDeletedFalse(Long id);
}
