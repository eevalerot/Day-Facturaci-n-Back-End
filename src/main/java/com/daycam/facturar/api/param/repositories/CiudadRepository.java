package com.daycam.facturar.api.param.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daycam.facturar.api.param.entities.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long>{
	
}
