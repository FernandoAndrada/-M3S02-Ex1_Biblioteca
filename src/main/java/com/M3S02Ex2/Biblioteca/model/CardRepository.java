package com.M3S02Ex2.Biblioteca.model;

import com.M3S02Ex2.Biblioteca.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByNumber(String number);

}
