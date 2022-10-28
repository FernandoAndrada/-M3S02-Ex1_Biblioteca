package com.M3S02Ex2.Biblioteca.service;

import com.M3S02Ex2.Biblioteca.Entity.Loan;
import com.M3S02Ex2.Biblioteca.model.LoanRepository;
import com.M3S02Ex2.Biblioteca.service.interfaces.CardService;
import com.M3S02Ex2.Biblioteca.service.interfaces.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImp implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CardService cardService;


    @Override
    public Loan salvar(Loan loan) {
        return this.loanRepository.save(loan);
    }

    @Override
    public Loan atualizar(Loan loan) {
        Optional<Loan> loanPesquisado = this.loanRepository.findById(loan.getId());

        if(loanPesquisado.isPresent()) {
            loanPesquisado.get().setId(loan.getId());
            return this.loanRepository.save(loanPesquisado.get());
        }
        return null;
    }

    @Override
    public Loan buscar(Long id) {
        Optional<Loan> loan = this.loanRepository.findById(id);

        if(Loan.isPresent()){
            return loan.get();
        }
        return null;
    }


    @Override
    public List<Loan> listar() {
        return this.loanRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        this.loanRepository.deleteById(id);
    }

    @Override
    public Loan fecharLoan(Long idLoan, String numeroCartao) {
        return null;
    }
}
