package com.turismo.backendturismotec.turismo.domain.persistence;

import com.turismo.backendturismotec.turismo.domain.model.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sales,Long> {
}
