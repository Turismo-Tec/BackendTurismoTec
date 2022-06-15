package com.turismo.backendturismotec.turismo.resources.services;

import com.turismo.backendturismotec.shared.exceptions.ResourceNotFoundException;
import com.turismo.backendturismotec.shared.exceptions.ResourceValidationException;
import com.turismo.backendturismotec.turismo.domain.persistence.CompanyRepository;
import com.turismo.backendturismotec.turismo.domain.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final String ENTITY = "Companies";
    private final CompanyRepository companyRepository;
    private final Validator validator;

    public CompanyServiceImpl(CompanyRepository companyRepository, Validator validator) {
        this.companyRepository = companyRepository;
        this.validator = validator;
    }

    @Override
    public List<com.turismo.turismoapi.turismo.domain.model.entity.Companies> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public com.turismo.turismoapi.turismo.domain.model.entity.Companies getById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, companyId));
    }

    @Override
    public com.turismo.turismoapi.turismo.domain.model.entity.Companies create(com.turismo.turismoapi.turismo.domain.model.entity.Companies company) {
        Set<ConstraintViolation<com.turismo.turismoapi.turismo.domain.model.entity.Companies>> violations = validator.validate(company);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return companyRepository.save(company);
    }

    @Override
    public com.turismo.turismoapi.turismo.domain.model.entity.Companies update(Long id, com.turismo.turismoapi.turismo.domain.model.entity.Companies request) {
        Set<ConstraintViolation<com.turismo.turismoapi.turismo.domain.model.entity.Companies>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return companyRepository.findById(id).map(company ->
                        companyRepository.save(company
                                        .withName(request.getName()))
                                .withEmail(request.getEmail())
                                .withDescription(request.getDescription()))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> delete(Long companyId) {
        return companyRepository.findById(companyId).map(company -> {
            companyRepository.delete(company);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, companyId));
    }
}
