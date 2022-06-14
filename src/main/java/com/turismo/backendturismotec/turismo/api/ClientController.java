package com.turismo.backendturismotec.turismo.api;

import com.turismo.backendturismotec.turismo.domain.service.ClientService;
import com.turismo.backendturismotec.turismo.mapping.ClientMapper;
import com.turismo.turismoapi.turismo.resources.client.ClientResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {
  
   private final ClientService clientService;
    private final ClientMapper mapper;

    public ClientController(ClientService clientService, ClientMapper mapper){
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ClientResource> getAllClients(Pageable pageable) {
        return mapper.modelListPage(clientService.getAll(), pageable);
    }

    @GetMapping("{clientId}")
    public ClientResource getClientsById(@PathVariable Long clientId){
        return mapper.toResource(clientService.getById(clientId));
    }

    @PostMapping
    public ClientResource createClients(@RequestBody CreateClientResource resource){
        return mapper.toResource(clientService.create(mapper.toModel(resource)));
    }

    @PutMapping("{clientId}")
    public ClientResource updateClients(@PathVariable Long clientId,
                                           @RequestBody UpdateClientResource resource){
        return mapper.toResource(clientService.update(clientId, mapper.toModel(resource)));
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<?> deleteClients(@PathVariable Long clientId){
        return clientService.delete(clientId);
    }
  
}
