package com.turismo.backendturismotec.turismo.domain.service;

import com.turismo.backendturismotec.turismo.domain.model.entity.Companies;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {
    List<Companies> getAll();
    Companies getById(Long companyId);
    Companies create(Companies company);
    Companies update(Long id, Companies request);
    ResponseEntity<?> delete(Long companyId);
}
