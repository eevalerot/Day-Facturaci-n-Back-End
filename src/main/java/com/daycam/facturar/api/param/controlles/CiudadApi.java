package com.daycam.facturar.api.param.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daycam.facturar.api.param.service.implement.CiudadImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/ciudad")
public class CiudadApi {
	
	@Autowired
	private CiudadImpl ciudadImpl;

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> seeMenu() {

		try {
			return ResponseEntity.ok(this.ciudadImpl.findCiudadAll());
		} catch (Exception e) {
			e.getStackTrace();
		}
			return null;
	}
}
