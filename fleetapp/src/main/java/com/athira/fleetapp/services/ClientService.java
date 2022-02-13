package com.athira.fleetapp.services;

import com.athira.fleetapp.entities.Client;
import com.athira.fleetapp.repositories.ClientRepository;
import com.athira.fleetapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
