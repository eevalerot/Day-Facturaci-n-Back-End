package com.daycam.facturar.api.cliente.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.daycam.facturar.api.cliente.dto.ClienteDto;
import com.daycam.facturar.api.cliente.entities.Cliente;

@Component
public interface ClienteService {

	Boolean saveCliente(Cliente cliente);
	
	List<ClienteDto> extractCliente();
	
	ClienteDto findClienteDocumento(String documento);
	
	Boolean updateCliente(ClienteDto clienteDto, String Documento);
}
