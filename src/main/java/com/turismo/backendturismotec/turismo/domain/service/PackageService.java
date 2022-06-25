package com.turismo.backendturismotec.turismo.domain.service;

import com.turismo.backendturismotec.turismo.domain.model.entity.Packages;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PackageService {
    List<Packages> getAll();

    Packages getById(Long packageId);

    Packages create(Packages packages);

    Packages update(Long id, Packages request);

    ResponseEntity<?> delete(Long packageId);
}
