package com.turismo.backendturismotec.turismo.resources.services;

import com.turismo.backendturismotec.shared.exceptions.ResourceNotFoundException;
import com.turismo.backendturismotec.shared.exceptions.ResourceValidationException;
import com.turismo.backendturismotec.turismo.domain.model.entity.Client;
import com.turismo.backendturismotec.turismo.domain.persistence.ClientRepository;
import com.turismo.backendturismotec.turismo.domain.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Service
public class ClientServiceImpl implements ClientService {

    private static final String ENTITY = "Client";
    private final ClientRepository clientRepository;
    private final Validator validator;

    public ClientServiceImpl(ClientRepository clientRepository, Validator validator) {
        this.clientRepository = clientRepository;
        this.validator = validator;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }

    @Override
    public Client create(Client client) {
        Set<ConstraintViolation<Client>> violations = validator.validate(client);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return clientRepository.save(client);
    }

    @Override
    public Client update(Long id, Client request) {
        Set<ConstraintViolation<Client>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return clientRepository.findById(id).map(client ->
                        clientRepository.save(client
                                        .withFirstName(request.getFirstName()))
                                .withAddress(request.getAddress())
                                .withLastName(request.getLastName())
                                .withPhone(request.getPhone())
                                .withEmail(request.getEmail())
                                .withUsername(request.getUsername())
                                .withPassword(request.getPassword()))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> delete(Long clientId) {
        return clientRepository.findById(clientId).map(client -> {
            clientRepository.delete(client);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }
}
