package com.turismo.backendturismotec.turismo.services;

import com.turismo.backendturismotec.shared.exceptions.ResourceNotFoundException;
import com.turismo.backendturismotec.shared.exceptions.ResourceValidationException;
import com.turismo.backendturismotec.turismo.domain.model.entity.Sales;
import com.turismo.backendturismotec.turismo.domain.persistence.SaleRepository;
import com.turismo.backendturismotec.turismo.domain.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class SalesServiceImpl implements SaleService {

    private static final String ENTITY = "Sales";
    private final SaleRepository saleRepository;
    private final Validator validator;

    public SalesServiceImpl(SaleRepository saleRepository, Validator validator) {
        this.saleRepository = saleRepository;
        this.validator = validator;
    }

    @Override
    public List<Sales> getAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sales getById(Long saleId) {
        return saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, saleId));
    }

    @Override
    public Sales create(Sales sales) {
        Set<ConstraintViolation<Sales>> violations = validator.validate(sales);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return saleRepository.save(sales);
    }

    @Override
    public Sales update(Long id, Sales request) {
        Set<ConstraintViolation<Sales>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return saleRepository.findById(id).map(packages ->
                        saleRepository.save(packages.withDate(request.getDate())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> delete(Long saleId) {
        return saleRepository.findById(saleId).map(packages -> {
            saleRepository.delete(packages);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, saleId));
    }
}
