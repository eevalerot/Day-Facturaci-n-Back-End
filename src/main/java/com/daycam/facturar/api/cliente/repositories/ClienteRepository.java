package com.daycam.facturar.api.cliente.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daycam.facturar.api.cliente.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Query("SELECT c FROM Cliente c")
	List<Cliente> findByCliente();
	
	@Transactional(readOnly = false)
	Cliente findByDocumento(String documento);
	

}
