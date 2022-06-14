package com.turismo.backendturismotec.turismo.domain.persistence;

import com.turismo.turismoapi.turismo.domain.model.entity.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Companies,Long> {
}
