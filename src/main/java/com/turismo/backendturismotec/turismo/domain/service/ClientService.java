package com.turismo.backendturismotec.turismo.domain.service;

import com.turismo.backendturismotec.turismo.domain.model.entity.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Client getById(Long clientId);
    Client create(Client client);
    Client update(Long id, Client request);
    ResponseEntity<?> delete(Long clientId);
}
