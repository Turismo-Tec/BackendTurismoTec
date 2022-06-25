package com.turismo.turismoapi.turismo.domain.persistence;

import com.turismo.turismoapi.turismo.domain.model.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Packages,Long> {
}
