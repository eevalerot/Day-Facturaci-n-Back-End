package com.daycam.facturar.api.vendedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daycam.facturar.api.vendedor.entities.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>{
	
	@Transactional(readOnly = false)
	Vendedor findByDocumento(String documento);
}
