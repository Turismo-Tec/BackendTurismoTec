package com.turismo.backendturismotec.turismo.domain.persistence;


import com.turismo.backendturismotec.turismo.domain.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
