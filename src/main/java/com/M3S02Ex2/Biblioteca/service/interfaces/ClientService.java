package com.M3S02Ex2.Biblioteca.service.interfaces;

import com.M3S02Ex2.Biblioteca.Entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    Client salvar(Client client);

    Client atualizar(Client client);

    Client buscar(Long id);

    List<Client> listar();

    void excluir(Long id);

    Client buscarPorName(String name);

    boolean existsByCpf(String cpf);
}
