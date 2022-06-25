package com.turismo.backendturismotec.turismo.domain.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SalesService {
    List<Sales> getAll();

    Sales getById(Long saleId);

    Sales create(Sales sales);

    Sales update(Long id, Sales request);

    ResponseEntity<?> delete(Long saleId);
}
