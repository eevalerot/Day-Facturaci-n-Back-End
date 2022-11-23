package com.daycam.facturar.api.vendedor.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daycam.facturar.api.commons.MHelpers;
import com.daycam.facturar.api.vendedor.dto.VendedorDto;
import com.daycam.facturar.api.vendedor.entities.Vendedor;
import com.daycam.facturar.api.vendedor.repositories.VendedorRepository;
import com.daycam.facturar.api.vendedor.services.VededorService;

@Service
public class VendedorImpl implements VededorService{

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Override
	public Boolean saveVendedor(Vendedor vendedor) {
		if (vendedor != null) {
			this.vendedorRepository.save(vendedor);
			return true;
		}
		return false;
	}

	@Override
	public List<Vendedor> listarVendedor() {
		
		return this.vendedorRepository.findAll();
	}

	@Override
	public VendedorDto findVendedorDocumento(String documento) {
		Vendedor vendedor = vendedorRepository.findByDocumento(documento);
		VendedorDto vendedorDto = MHelpers.modelMapper().map(vendedor, VendedorDto.class);
		
		return vendedorDto;
	}

	@Override
	public Boolean updateVendedor(VendedorDto vendedorDto, String documento) {
		try {
			Vendedor vendedor = this.vendedorRepository.findByDocumento(documento);
			//Proveedor proveedor = pvOptional.get();
			
			vendedor.setNombre(vendedorDto.getNombre());
			vendedor.setDocumento(vendedorDto.getDocumento());
			vendedor.setDireccion(vendedorDto.getDireccion());
			vendedor.setTelefono(vendedorDto.getTelefono());
			vendedor.setEmail(vendedorDto.getEmail());
			vendedor.setEstado(vendedorDto.getEstado());
			
			this.vendedorRepository.save(vendedor);
			
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
}
