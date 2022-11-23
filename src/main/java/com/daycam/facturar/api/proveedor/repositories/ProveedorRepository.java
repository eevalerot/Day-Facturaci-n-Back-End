package com.daycam.facturar.api.proveedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daycam.facturar.api.proveedor.entities.Proveedor;



@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
	
	@Transactional(readOnly = false)
	Proveedor findByDocumento(String documento);
	
}
