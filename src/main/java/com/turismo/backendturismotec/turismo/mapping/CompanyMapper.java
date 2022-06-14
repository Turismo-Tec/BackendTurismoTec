package com.turismo.backendturismotec.turismo.mapping;

import com.turismo.turismoapi.turismo.domain.model.entity.Companies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CompanyMapper {
    @Autowired
    EnhanceModelMapper mapper;

    public CompanyResource toResource(Companies model) {
        return mapper.map(model, CompanyResource.class);
    }

    public Page<CompanyResource> modelListPage(List<Companies> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CompanyResource.class),
                pageable, modelList.size());
    }

    public Companies toModel(CreateCompanyResource resource) {
        return mapper.map(resource, Companies.class);
    }

    public Companies toModel(UpdateCompanyResource resource) {
        return mapper.map(resource, Companies.class);
    }
}
