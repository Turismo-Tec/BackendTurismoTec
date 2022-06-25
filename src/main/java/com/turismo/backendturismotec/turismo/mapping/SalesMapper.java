package com.turismo.backendturismotec.turismo.mapping;

import com.turismo.backendturismotec.shared.mapping.EnhanceModelMapper;
import com.turismo.backendturismotec.turismo.domain.model.entity.Sales;
import com.turismo.backendturismotec.turismo.resources.sales.CreateSalesResources;
import com.turismo.backendturismotec.turismo.resources.sales.SalesResources;
import com.turismo.backendturismotec.turismo.resources.sales.UpdateSalesResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class SalesMapper {
    @Autowired
    EnhanceModelMapper mapper;

    public SalesResources toResource(Sales model) {
        return mapper.map(model, SalesResources.class);
    }

    public Page<SalesResources> modelListPage(List<Sales> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SalesResources.class),
                pageable, modelList.size());
    }

    public Sales toModel(CreateSalesResources resource) {
        return mapper.map(resource, Sales.class);
    }

    public Sales toModel(UpdateSalesResources resource) {
        return mapper.map(resource, Sales.class);
    }
}
