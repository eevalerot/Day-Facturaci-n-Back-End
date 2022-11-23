package com.daycam.facturar.api.menu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daycam.facturar.api.menu.services.impl.MenuImpl;
import com.daycam.facturar.api.security.enums.RolNombre;

@CrossOrigin("*")
@RestController
@RequestMapping("/menu")
public class MenuApi {

	@Autowired
	private MenuImpl menuImpl;

	@GetMapping(value = "/all/{rolNombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> seeMenu(@PathVariable("rolNombre") RolNombre rolNombre) {

		try {
			return ResponseEntity.ok(this.menuImpl.findByMenu(rolNombre));
		} catch (Exception e) {
			e.getStackTrace();
		}
			return null;
	}
}
