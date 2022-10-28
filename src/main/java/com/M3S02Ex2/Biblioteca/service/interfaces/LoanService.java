package com.M3S02Ex2.Biblioteca.service.interfaces;

import com.M3S02Ex2.Biblioteca.Entity.Loan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LoanService {
    Loan salvar(Loan loan);

    Loan atualizar(Loan loan);

    Loan buscar(Long id);

    List<Loan> listar();

    void excluir(Long id);

    Loan fecharLoan(Long id, String numeroCartao);
}
