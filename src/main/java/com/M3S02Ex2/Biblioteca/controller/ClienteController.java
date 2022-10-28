package com.M3S02Ex2.Biblioteca.controller;

import com.M3S02Ex2.Biblioteca.Entity.Client;
import com.M3S02Ex2.Biblioteca.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid Client client) {
        if(clientService.existsByCpf(client.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O CPF já está em uso!");
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.clientService.salvar(client));
    }

    @PutMapping
    public ResponseEntity<Client> atualizar(@RequestBody Client client) {
        return ResponseEntity.ok(this.clientService.atualizar(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscar(@PathVariable @Valid Long id){
        Client client = this.clientService.buscar(id);

        if(client == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este Id não existe!");
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.clientService.buscar(id));

//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(this.clientService.buscar(id));
    }

    @GetMapping("/buscar-por-nome")
    public ResponseEntity<Client> buscarPorName(@PathParam("name") String name){
        return ResponseEntity.ok(this.clientService.buscarPorName(name));
    }

    @GetMapping
    public List<Client> listar(){

        return ResponseEntity.ok((this.clientService.listar())).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        this.clientService.excluir(id);
        return ResponseEntity.ok("Excluido com sucesso!");
    }

}
