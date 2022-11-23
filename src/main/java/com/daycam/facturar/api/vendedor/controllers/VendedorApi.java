package com.daycam.facturar.api.vendedor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daycam.facturar.api.cliente.dto.MensajeSaveDto;
import com.daycam.facturar.api.security.dto.Mensaje;
import com.daycam.facturar.api.vendedor.dto.VendedorDto;
import com.daycam.facturar.api.vendedor.entities.Vendedor;
import com.daycam.facturar.api.vendedor.services.impl.VendedorImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@CrossOrigin("*")
@RestController
@RequestMapping("/vendedor")
public class VendedorApi {

	@Autowired
	private VendedorImpl vendedorImpl;
	
	@PostMapping("/save")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<MensajeSaveDto> saveVendedor(@RequestBody Vendedor vendedor, BindingResult bilBindingResult) {
		
		String mensajeOk = "{\"mensajeOK\":\"Se ha guardado el vendedor con exito\"}";
		GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        MensajeSaveDto user = gson.fromJson(mensajeOk,MensajeSaveDto.class);
        
		if(bilBindingResult.hasErrors()) 
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		
		Boolean response = this.vendedorImpl.saveVendedor(vendedor);
		if(response) {
			return new ResponseEntity(user, HttpStatus.OK);
		}else {
			return new ResponseEntity(new Mensaje("error al guardar el vendedor"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> seeVendedor() {

		try {
			return ResponseEntity.ok(this.vendedorImpl.listarVendedor());
		} catch (Exception e) {
			e.getStackTrace();
		}
			return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/documento/{documento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getVendeddor(@PathVariable String documento) {

		try {
			return ResponseEntity.ok(this.vendedorImpl.findVendedorDocumento(documento));
		} catch (Exception e) {
			e.getStackTrace();
		}
			return new ResponseEntity(new Mensaje("no hay registros"), HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/update/{documento}")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<MensajeSaveDto> login(@RequestBody VendedorDto vendedorDto, @PathVariable String documento, BindingResult bilBindingResult) {
		
		String mensajeOk = "{\"mensajeOK\":\"Se ha editado el vendedor con exito\"}";
		GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        MensajeSaveDto user = gson.fromJson(mensajeOk,MensajeSaveDto.class);
        
		if(bilBindingResult.hasErrors()) 
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		
		Boolean response = this.vendedorImpl.updateVendedor(vendedorDto, documento);
		if(response) {
			return new ResponseEntity(user, HttpStatus.OK);
		}else {
			return new ResponseEntity(new Mensaje("error al actualizar el vendedor"), HttpStatus.BAD_REQUEST);
		}
		
	}
}
