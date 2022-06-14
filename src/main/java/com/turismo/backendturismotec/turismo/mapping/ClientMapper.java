package com.turismo.backendturismotec.turismo.mapping;

import com.turismo.backendturismotec.turismo.domain.model.entity.Client;
import com.turismo.turismoapi.turismo.resources.client.ClientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ClientMapper {
    @Autowired
    EnhanceModelMapper mapper;

    public ClientResource toResource(Client model) {
        return mapper.map(model, ClientResource.class);
    }

    public Page<ClientResource> modelListPage(List<Client> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ClientResource.class),
                pageable, modelList.size());
    }

    public Client toModel(CreateClientResource resource) {
        return mapper.map(resource, Client.class);
    }

    public Client toModel(UpdateClientResource resource) {
        return mapper.map(resource, Client.class);
    }
}
