package com.daycam.facturar.api.cliente.controllers;

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

import com.daycam.facturar.api.cliente.dto.ClienteDto;
import com.daycam.facturar.api.cliente.dto.MensajeSaveDto;
import com.daycam.facturar.api.cliente.entities.Cliente;
import com.daycam.facturar.api.cliente.services.implement.ClienteImpl;
import com.daycam.facturar.api.security.dto.Mensaje;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@CrossOrigin("*")
@RestController
@RequestMapping("/cliente")
public class ClientteApi {

	@Autowired
	private ClienteImpl clienteImpl;
	
	@PostMapping("/save")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<MensajeSaveDto> login(@RequestBody Cliente cliente, BindingResult bilBindingResult) {
		
		String mensajeOk = "{\"mensajeOK\":\"Se ha guardado el cliente con exito\"}";
		GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        MensajeSaveDto user = gson.fromJson(mensajeOk,MensajeSaveDto.class);
        
		if(bilBindingResult.hasErrors()) 
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		
		Boolean response = this.clienteImpl.saveCliente(cliente);
		if(response) {
			return new ResponseEntity(user, HttpStatus.OK);
		}else {
			return new ResponseEntity(new Mensaje("error al guardar el cliente"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> seeCliente() {

		try {
			return ResponseEntity.ok(this.clienteImpl.extractCliente());
		} catch (Exception e) {
			e.getStackTrace();
		}
			return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/documento/{documento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCliente(@PathVariable String documento) {

		try {
			return ResponseEntity.ok(this.clienteImpl.findClienteDocumento(documento));
		} catch (Exception e) {
			e.getStackTrace();
		}
			return new ResponseEntity(new Mensaje("no hay registros"), HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/update/{documento}")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<MensajeSaveDto> updateCliente(@RequestBody ClienteDto clienteDto, @PathVariable String documento, BindingResult bilBindingResult) {
		
		String mensajeOk = "{\"mensajeOK\":\"Se ha editado el cliente con exito\"}";
		GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        MensajeSaveDto user = gson.fromJson(mensajeOk,MensajeSaveDto.class);
        
		if(bilBindingResult.hasErrors()) 
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		
		Boolean response = this.clienteImpl.updateCliente(clienteDto, documento);
		if(response) {
			return new ResponseEntity(user, HttpStatus.OK);
		}else {
			return new ResponseEntity(new Mensaje("error al actualizar el cliente"), HttpStatus.BAD_REQUEST);
		}
		
	}
}
