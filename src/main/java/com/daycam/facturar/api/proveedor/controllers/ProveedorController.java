package com.daycam.facturar.api.proveedor.controllers;

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
import com.daycam.facturar.api.proveedor.dto.ProveedorDto;
import com.daycam.facturar.api.proveedor.entities.Proveedor;
import com.daycam.facturar.api.proveedor.repositories.services.impl.ProveedorImpl;
import com.daycam.facturar.api.security.dto.Mensaje;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@CrossOrigin("*")
@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorImpl proveedorImpl;
	
	@PostMapping("/save")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<MensajeSaveDto> login(@RequestBody Proveedor proveedor, BindingResult bilBindingResult) {
		
		String mensajeOk = "{\"mensajeOK\":\"Se ha guardado el proveedor con exito\"}";
		GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        MensajeSaveDto user = gson.fromJson(mensajeOk,MensajeSaveDto.class);
        
		if(bilBindingResult.hasErrors()) 
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		
		Boolean response = this.proveedorImpl.saveProveedor(proveedor);
		if(response) {
			return new ResponseEntity(user, HttpStatus.OK);
		}else {
			return new ResponseEntity(new Mensaje("error al guardar el proveedor"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> seeProveedor() {

		try {
			return ResponseEntity.ok(this.proveedorImpl.listarProveedores());
		} catch (Exception e) {
			e.getStackTrace();
		}
			return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/documento/{documento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getProveedor(@PathVariable String documento) {

		try {
			return ResponseEntity.ok(this.proveedorImpl.findProveedorDocumento(documento));
		} catch (Exception e) {
			e.getStackTrace();
		}
			return new ResponseEntity(new Mensaje("no hay registros"), HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/update/{documento}")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<MensajeSaveDto> login(@RequestBody ProveedorDto proveedorDto, @PathVariable String documento, BindingResult bilBindingResult) {
		
		String mensajeOk = "{\"mensajeOK\":\"Se ha editado el proveedor con exito\"}";
		GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        MensajeSaveDto user = gson.fromJson(mensajeOk,MensajeSaveDto.class);
        
		if(bilBindingResult.hasErrors()) 
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		
		Boolean response = this.proveedorImpl.updateProveedor(proveedorDto, documento);
		if(response) {
			return new ResponseEntity(user, HttpStatus.OK);
		}else {
			return new ResponseEntity(new Mensaje("error al guardar el proveedor"), HttpStatus.BAD_REQUEST);
		}
		
	}
}
