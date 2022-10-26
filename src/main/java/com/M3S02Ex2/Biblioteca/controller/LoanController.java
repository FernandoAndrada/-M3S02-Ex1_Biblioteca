package com.M3S02Ex2.Biblioteca.controller;

import com.M3S02Ex2.Biblioteca.Entity.Loan;
import com.M3S02Ex2.Biblioteca.service.interfaces.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> salvar(@RequestBody Loan loan) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.loanService.salvar(loan));
    }

    @PutMapping
    public ResponseEntity<Loan> atualizar(@RequestBody Loan loan) {
        return ResponseEntity.ok(this.loanService.atualizar(loan));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> buscar(@PathVariable Long id){
        Loan loan = this.loanService.buscar(id);

        if(loan == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.loanService.buscar(id));
    }


    @GetMapping
    public List<Loan> listar(){

        return ResponseEntity.ok((this.loanService.listar())).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        this.loanService.excluir(id);
        return ResponseEntity.ok("Excluido com sucesso!");
    }

}
