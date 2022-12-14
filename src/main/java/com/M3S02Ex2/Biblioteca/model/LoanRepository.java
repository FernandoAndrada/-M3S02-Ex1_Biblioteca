package com.M3S02Ex2.Biblioteca.model;

import com.M3S02Ex2.Biblioteca.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
