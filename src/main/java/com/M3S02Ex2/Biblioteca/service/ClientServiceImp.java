package com.M3S02Ex2.Biblioteca.service;


import com.M3S02Ex2.Biblioteca.Entity.Book;
import com.M3S02Ex2.Biblioteca.Entity.Client;
import com.M3S02Ex2.Biblioteca.model.ClientRepository;
import com.M3S02Ex2.Biblioteca.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client salvar(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public Client atualizar(Client client) {
        Optional<Client> clientPesquisado = this.clientRepository.findById(client.getId());

        if(clientPesquisado.isPresent()) {
            clientPesquisado.get().setName(client.getName());
            return this.clientRepository.save(clientPesquisado.get());
        }
        return null;
    }

    @Override
    public Client buscar(Long id) {
        Optional<Client> client = this.clientRepository.findById(id);

        if(Client.isPresent()){
            return client.get();
        }
        return null;
    }

    @Override
    public Client buscarPorName(String name) {
        return this.clientRepository.findByName(name).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possível encontrar um livro com o nome: " + name);
        });
    }


    @Override
    public List<Client> listar() {
        return this.clientRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        this.clientRepository.deleteById(id);

    }
}
