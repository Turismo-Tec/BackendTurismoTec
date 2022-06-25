package com.turismo.turismoapi.turismo.services;

import com.turismo.turismoapi.shared.exceptions.ResourceNotFoundException;
import com.turismo.turismoapi.shared.exceptions.ResourceValidationException;
import com.turismo.turismoapi.turismo.domain.model.entity.Packages;
import com.turismo.turismoapi.turismo.domain.persistence.PackageRepository;
import com.turismo.turismoapi.turismo.domain.service.PackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PackageServiceImpl implements PackageService {

    private static final String ENTITY = "Packages";
    private final PackageRepository packageRepository;
    private final Validator validator;

    public PackageServiceImpl(PackageRepository packageRepository, Validator validator) {
        this.packageRepository = packageRepository;
        this.validator = validator;
    }

    @Override
    public List<Packages> getAll() {
        return packageRepository.findAll();
    }

    @Override
    public Packages getById(Long packageId) {
        return packageRepository.findById(packageId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, packageId));
    }

    @Override
    public Packages create(Packages packages) {
        Set<ConstraintViolation<Packages>> violations = validator.validate(packages);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return packageRepository.save(packages);
    }

    @Override
    public Packages update(Long id, Packages request) {
        Set<ConstraintViolation<Packages>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return packageRepository.findById(id).map(packages ->
                        packageRepository.save(packages
                                .withDescription(request.getDescription())
                                .withCountry(request.getCountry())
                                .withPrice(request.getPrice())))
                                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> delete(Long packageId) {
        return packageRepository.findById(packageId).map(packages -> {
            packageRepository.delete(packages);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, packageId));
    }
}
