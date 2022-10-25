package com.M3S02Ex2.Biblioteca.service;

import com.M3S02Ex2.Biblioteca.Entity.Author;
import com.M3S02Ex2.Biblioteca.Entity.Book;
import com.M3S02Ex2.Biblioteca.model.BookRepository;
import com.M3S02Ex2.Biblioteca.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceIml implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public Book salvar(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book atualizar(Book book) {
        Optional<Book> bookPesquisado = this.bookRepository.findById(book.getId());

        if(bookPesquisado.isPresent()) {
            bookPesquisado.get().setTitle(book.getTitle());
            return this.bookRepository.save(bookPesquisado.get());
        }
        return null;
    }

    @Override
    public Book buscar(Long id) {
        Optional<Book> book = this.bookRepository.findById(id);

        if(Book.isPresent()){
            return book.get();
        }
        return null;
    }

    @Override
    public Book buscarPorTitulo(String title) {
        return this.bookRepository.findByTitle(title).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possível encontrar um livro com o nome: " + title);
        });
    }

    @Override
    public List<Book> listar() {
        return this.bookRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        this.bookRepository.deleteById(id);

    }
}
