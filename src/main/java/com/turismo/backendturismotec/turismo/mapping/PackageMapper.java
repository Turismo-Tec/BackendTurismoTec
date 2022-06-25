package com.turismo.backendturismotec.turismo.mapping;

import com.turismo.backendturismotec.shared.mapping.EnhanceModelMapper;
import com.turismo.backendturismotec.turismo.domain.model.entity.Packages;
import com.turismo.backendturismotec.turismo.resources.packages.CreatePackageResource;
import com.turismo.backendturismotec.turismo.resources.packages.PackageResource;
import com.turismo.backendturismotec.turismo.resources.packages.UpdatePackageResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PackageMapper {

    @Autowired
    EnhanceModelMapper mapper;

    public PackageResource toResource(Packages model) {
        return mapper.map(model, PackageResource.class);
    }

    public Page<PackageResource> modelListPage(List<Packages> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PackageResource.class),
                pageable, modelList.size());
    }

    public Packages toModel(CreatePackageResource resource) {
        return mapper.map(resource, Packages.class);
    }

    public Packages toModel(UpdatePackageResource resource) {
        return mapper.map(resource, Packages.class);
    }

}
