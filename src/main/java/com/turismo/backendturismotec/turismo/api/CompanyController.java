package com.turismo.backendturismotec.turismo.api;

import com.turismo.backendturismotec.turismo.domain.service.CompanyService;
import com.turismo.backendturismotec.turismo.mapping.CompanyMapper;
import com.turismo.backendturismotec.turismo.resources.company.CompanyResource;
import com.turismo.backendturismotec.turismo.resources.company.CreateCompanyResource;
import com.turismo.backendturismotec.turismo.resources.company.UpdateCompanyResource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper mapper;

    public CompanyController(CompanyService companyService, CompanyMapper mapper){
        this.companyService = companyService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<CompanyResource> getAllCompanies(Pageable pageable) {
        return mapper.modelListPage(companyService.getAll(), pageable);
    }

    @GetMapping("{companyId}")
    public CompanyResource getCompaniesById(@PathVariable Long companyId){
        return mapper.toResource(companyService.getById(companyId));
    }

    @PostMapping
    public CompanyResource createCompanies(@RequestBody CreateCompanyResource resource){
        return mapper.toResource(companyService.create(mapper.toModel(resource)));
    }

    @PutMapping("{companyId}")
    public CompanyResource updateCompanies(@PathVariable Long companyId,
                                                   @RequestBody UpdateCompanyResource resource){
        return mapper.toResource(companyService.update(companyId, mapper.toModel(resource)));
    }

    @DeleteMapping("{companyId}")
    public ResponseEntity<?> deleteCompanies(@PathVariable Long companyId){
        return companyService.delete(companyId);
    }
}
