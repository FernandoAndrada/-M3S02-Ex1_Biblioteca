package com.M3S02Ex2.Biblioteca.model;

import com.M3S02Ex2.Biblioteca.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    Optional<Author> findByNome(String nome);

}
