package com.daycam.facturar.api.proveedor.repositories.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.daycam.facturar.api.proveedor.dto.ProveedorDto;
import com.daycam.facturar.api.proveedor.entities.Proveedor;

@Component
public interface ProveedorService {
	
	Boolean saveProveedor(Proveedor proveedor);
	
	List<Proveedor> listarProveedores();
	
	ProveedorDto findProveedorDocumento(String documento);
	
	Boolean updateProveedor(ProveedorDto proveedorDto, String Documento);
}
