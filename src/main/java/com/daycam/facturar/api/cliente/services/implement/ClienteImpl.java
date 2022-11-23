package com.daycam.facturar.api.cliente.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daycam.facturar.api.cliente.dto.ClienteDto;
import com.daycam.facturar.api.cliente.entities.Cliente;
import com.daycam.facturar.api.cliente.repositories.ClienteRepository;
import com.daycam.facturar.api.cliente.service.ClienteService;
import com.daycam.facturar.api.commons.MHelpers;

@Service
public class ClienteImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Boolean saveCliente(Cliente cliente) {
		
		if (cliente != null) {
			this.clienteRepository.save(cliente);
			return true;
		}
		return false;
	}

	@Override
	public List<ClienteDto> extractCliente() {
		List<ClienteDto> clienteaddList = new ArrayList<>();
		Iterable<Cliente> listaClientes = clienteRepository.findByCliente();
		
		for (Cliente cliente : listaClientes) {
			ClienteDto c = MHelpers.modelMapper().map(cliente, ClienteDto.class);
			clienteaddList.add(c);
		}
		return clienteaddList;
	}

	@Override
	public ClienteDto findClienteDocumento(String documento) {
		Cliente cliente = clienteRepository.findByDocumento(documento);
		ClienteDto clienteDto = MHelpers.modelMapper().map(cliente, ClienteDto.class);
		
		return clienteDto;
	}

	@Override
	public Boolean updateCliente(ClienteDto clienteDto, String documento) {
		try {
			Cliente cliente = this.clienteRepository.findByDocumento(documento);
			//Proveedor proveedor = pvOptional.get();
			
			cliente.setFullName(clienteDto.getFullName());
			cliente.setDocumento(clienteDto.getDocumento());
			cliente.setDireccion(clienteDto.getDireccion());
			cliente.setTelefono(clienteDto.getTelefono());
			cliente.setEmail(clienteDto.getEmail());
			cliente.setEnabled(clienteDto.getEnabled());
			cliente.setCiudad(clienteDto.getCiudad());
			cliente.setNombreRemitente(clienteDto.getNombreRemitente());
			cliente.setDocumentoRemitente(clienteDto.getDocumentoRemitente());
			cliente.setTelefonoRemitente(clienteDto.getTelefonoRemitente());
			
			this.clienteRepository.save(cliente);
			
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	

}
