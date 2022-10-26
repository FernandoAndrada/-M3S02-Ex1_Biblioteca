package com.M3S02Ex2.Biblioteca.controller;
/*
import com.M3S02Ex2.Biblioteca.Entity.Card;
import com.M3S02Ex2.Biblioteca.service.interfaces.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> salvar(@RequestBody Card card){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.cardService.salvar(card));
    }
    @PutMapping
    public ResponseEntity<Card> atualizar(@RequestBody Card card) {
        return ResponseEntity.ok(this.cardService.atualizar(card));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> buscar(@PathVariable Long id){
        Card card = this.cardService.buscar(id);

        if(card == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.cardService.buscar(id));
    }

    @GetMapping("/buscar-por-nome")
    public ResponseEntity<Card> buscarPorNumber(@PathParam("number") String number){
        return ResponseEntity.ok(this.cardService.buscarPorNumber(number));
    }

    @GetMapping
    public List<Card> listar(){

        return ResponseEntity.ok((this.cardService.listar())).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        this.cardService.excluir(id);
        return ResponseEntity.ok("Excluido com sucesso!");
    }

}
        */