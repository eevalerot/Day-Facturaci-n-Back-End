package com.daycam.facturar.api.proveedor.repositories.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daycam.facturar.api.commons.MHelpers;
import com.daycam.facturar.api.proveedor.dto.ProveedorDto;
import com.daycam.facturar.api.proveedor.entities.Proveedor;
import com.daycam.facturar.api.proveedor.repositories.ProveedorRepository;
import com.daycam.facturar.api.proveedor.repositories.services.ProveedorService;

@Service
public class ProveedorImpl implements ProveedorService{

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public Boolean saveProveedor(Proveedor proveedor) {
		if (proveedor != null) {
			this.proveedorRepository.save(proveedor);
			return true;
		}
		return false;
	}

	@Override
	public List<Proveedor> listarProveedores() {
		
		return this.proveedorRepository.findAll();
	}

	@Override
	public ProveedorDto findProveedorDocumento(String documento) {
		
		Proveedor proveedor = proveedorRepository.findByDocumento(documento);
		ProveedorDto proveedorDto = MHelpers.modelMapper().map(proveedor, ProveedorDto.class);
		
		return proveedorDto;
	}

	@Override
	public Boolean updateProveedor(ProveedorDto proveedorDto, String documento) {
		
		try {
			Proveedor proveedor = this.proveedorRepository.findByDocumento(documento);
			//Proveedor proveedor = pvOptional.get();
			
			proveedor.setNombre(proveedorDto.getNombre());
			proveedor.setDocumento(proveedorDto.getDocumento());
			proveedor.setDireccion(proveedorDto.getDireccion());
			proveedor.setTelefono(proveedorDto.getTelefono());
			proveedor.setEmail(proveedorDto.getEmail());
			proveedor.setEstado(proveedorDto.getEstado());
			
			this.proveedorRepository.save(proveedor);
			
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}

	}

}
