package com.M3S02Ex2.Biblioteca.service.interfaces;


import com.M3S02Ex2.Biblioteca.Entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book salvar(Book book);

    Book atualizar(Book book);

    Book buscar(Long id);

    Book buscarPorTitulo(String nome);

    List<Book> listar();

    void excluir(Long id);
}
