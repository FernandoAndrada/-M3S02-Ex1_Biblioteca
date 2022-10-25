package com.M3S02Ex2.Biblioteca.service.interfaces;


import com.M3S02Ex2.Biblioteca.Entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    Author salvar(Author author);

    Author buscar(Long id);

    Author buscarPorNome(String nome);

    List<Author> listar();

    Author atualizar(Author author);

    List<Author> findAll();

    void excluir(Long id);
}
