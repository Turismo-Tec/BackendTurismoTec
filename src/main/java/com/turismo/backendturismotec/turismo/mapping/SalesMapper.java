package com.turismo.backendturismotec.turismo.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class SalesMapper {
    @Autowired
    EnhanceModelMapper mapper;

    public SalesResource toResource(Sales model) {
        return mapper.map(model, SalesResource.class);
    }

    public Page<SalesResource> modelListPage(List<Sales> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SalesResource.class),
                pageable, modelList.size());
    }

    public Sales toModel(CreateSalesResource resource) {
        return mapper.map(resource, Sales.class);
    }

    public Sales toModel(UpdateSalesResource resource) {
        return mapper.map(resource, Sales.class);
    }
}
