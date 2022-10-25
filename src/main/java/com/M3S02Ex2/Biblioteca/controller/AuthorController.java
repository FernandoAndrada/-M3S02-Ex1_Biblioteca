package com.M3S02Ex2.Biblioteca.controller;

import com.M3S02Ex2.Biblioteca.Entity.Author;
import com.M3S02Ex2.Biblioteca.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> salvar(@RequestBody Author author){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.authorService.salvar(author));
    }

    @PutMapping
    public ResponseEntity<Author> atualizar(@RequestBody Author author) {
        return ResponseEntity.ok(this.authorService.atualizar(author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> buscar(@PathVariable Long id){
        Author author = this.authorService.buscar(id);

        if(author == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.authorService.buscar(id));
    }

    @GetMapping("/buscar-por-nome")
    public ResponseEntity<Author> buscarPorNome(@PathParam("nome") String nome){
        return ResponseEntity.ok(this.authorService.buscarPorNome(nome));
    }

    @GetMapping
    public List<Author> listar(){

        return ResponseEntity.ok((this.authorService.listar())).getBody();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        this.authorService.excluir(id);
        return ResponseEntity.ok("Excluido com sucesso!");
    }


}
