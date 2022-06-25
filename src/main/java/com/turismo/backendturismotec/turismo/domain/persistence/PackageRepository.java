package com.turismo.backendturismotec.turismo.domain.persistence;

import com.turismo.backendturismotec.turismo.domain.model.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Packages,Long> {
}
