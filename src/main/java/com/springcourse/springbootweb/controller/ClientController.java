package com.springcourse.springbootweb.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcourse.springbootweb.exceptions.ClientNotFoundException;
import com.springcourse.springbootweb.model.ClientModel;
import com.springcourse.springbootweb.repository.ClientRepo;

@RestController
public class ClientController {

    private ClientRepo clientRepo;

    public ClientController(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @GetMapping("/client")
    List<ClientModel> findAll() {
        return clientRepo.findAll();
    }

    @GetMapping("/client/{id}")
    ClientModel getById(@PathVariable UUID id) {
        return clientRepo.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @PostMapping("/client")
    ClientModel save(@RequestBody ClientModel clientModel) {
        return clientRepo.save(clientModel);
    }

    @PutMapping("/client/{id}")
    ClientModel update(@PathVariable UUID id, @RequestBody ClientModel newClient) {
        return clientRepo.findById(id).map(client -> {
            client.setEmail(newClient.getEmail());
            client.setName(newClient.getName());

            return client;

        }).orElseGet(() -> {
            newClient.setId(id);
           return clientRepo.save(newClient);
        });
    }

    @DeleteMapping("/client/{id}")
    void delete(@PathVariable UUID id) {
        clientRepo.deleteById(id);
    }
}
