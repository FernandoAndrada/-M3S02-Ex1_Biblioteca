package com.M3S02Ex2.Biblioteca.service;


import com.M3S02Ex2.Biblioteca.Entity.Author;
import com.M3S02Ex2.Biblioteca.model.AuthorRepository;
import com.M3S02Ex2.Biblioteca.service.interfaces.AuthorService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author salvar(Author author){

//        boolean isNomeExistente = this.authorRepository.existsByNome();
//
//        if(isNomeExistente){
//            throw new EntityExistsException("Já existe um Autor com este nome: "+ author.getNome());
//        }
        return this.authorRepository.save(author);
    }

    @Override
    public Author buscar(Long id) {
        Optional<Author> author = this.authorRepository.findById(id);

        if(Author.isPresent()){
            return author.get();
        }
        return null;
    }

    @Override
    public Author buscarPorNome(String nome) {
        return this.authorRepository.findByNome(nome).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possível encontrar um prato com o nome: " + nome);
        });
    }

    @Override
    public List<Author> listar() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author atualizar(Author author) {
        Optional<Author> authorPesquisado = this.authorRepository.findById(author.getId());

        if(authorPesquisado.isPresent()) {
            authorPesquisado.get().setNome(author.getNome());
            //BeanUtils.copyProperties(mesa, mesaPesquisada.get(),"id","status");
            return this.authorRepository.save(authorPesquisado.get());
        }
        return null;
    }




    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public void excluir(Long id) {
        this.authorRepository.deleteById(id);
    }


}
