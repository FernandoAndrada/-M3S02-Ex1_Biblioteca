package com.M3S02Ex2.Biblioteca.controller;

import com.M3S02Ex2.Biblioteca.Entity.Book;
import com.M3S02Ex2.Biblioteca.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> salvar(@RequestBody Book book){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.bookService.salvar(book));
    }

    @PutMapping
    public ResponseEntity<Book> atualizar(@RequestBody Book book) {
        return ResponseEntity.ok(this.bookService.atualizar(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> buscar(@PathVariable Long id){
        Book book = this.bookService.buscar(id);

        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.bookService.buscar(id));
    }

    @GetMapping("/buscar-por-titulo")
    public ResponseEntity<Book> buscarPorTitulo(@PathParam("title") String title){
        return ResponseEntity.ok(this.bookService.buscarPorTitulo(title));
    }

    @GetMapping
    public List<Book> listar(){

        return ResponseEntity.ok((this.bookService.listar())).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        this.bookService.excluir(id);
        return ResponseEntity.ok("Excluido com sucesso!");
    }




}
