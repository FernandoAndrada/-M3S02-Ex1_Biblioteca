package com.M3S02Ex2.Biblioteca.model;

import com.M3S02Ex2.Biblioteca.Entity.Author;
import com.M3S02Ex2.Biblioteca.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    Optional<Book> findByTitle(String title);

    Book save(Book book);

    Optional<Book> findById(Long id);

    List<Book> findAll();

    void deleteById(Long id);
}
