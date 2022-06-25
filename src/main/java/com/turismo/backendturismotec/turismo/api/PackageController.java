package com.turismo.backendturismotec.turismo.api;

import com.turismo.backendturismotec.turismo.domain.service.PackageService;
import com.turismo.backendturismotec.turismo.mapping.PackageMapper;
import com.turismo.backendturismotec.turismo.resources.packages.CreatePackageResource;
import com.turismo.backendturismotec.turismo.resources.packages.PackageResource;
import com.turismo.backendturismotec.turismo.resources.packages.UpdatePackageResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/packages")
public class PackageController {
    private final PackageService packageService;
    private final PackageMapper mapper;

    public PackageController(PackageService packageService, PackageMapper mapper){
        this.packageService = packageService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<PackageResource> getAllPackages(Pageable pageable) {
        return mapper.modelListPage(packageService.getAll(), pageable);
    }

    @GetMapping("{packageId}")
    public PackageResource getPackagesById(@PathVariable Long packageId){
        return mapper.toResource(packageService.getById(packageId));
    }

    @PostMapping
    public PackageResource createPackages(@RequestBody CreatePackageResource resource){
        return mapper.toResource(packageService.create(mapper.toModel(resource)));
    }

    @PutMapping("{packageId}")
    public PackageResource updatePackages(@PathVariable Long packageId,
                                          @RequestBody UpdatePackageResource resource){
        return mapper.toResource(packageService.update(packageId, mapper.toModel(resource)));
    }

    @DeleteMapping("{packageId}")
    public ResponseEntity<?> deletePackages(@PathVariable Long packageId){
        return packageService.delete(packageId);

    }
}