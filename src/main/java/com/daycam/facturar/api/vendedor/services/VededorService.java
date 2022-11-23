package com.daycam.facturar.api.vendedor.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.daycam.facturar.api.vendedor.dto.VendedorDto;
import com.daycam.facturar.api.vendedor.entities.Vendedor;

@Component
public interface VededorService {
	
	Boolean saveVendedor(Vendedor vendedor);
	
	List<Vendedor> listarVendedor();
	
	VendedorDto findVendedorDocumento(String documento);
	
	Boolean updateVendedor(VendedorDto vendedorDto, String Documento);
}
