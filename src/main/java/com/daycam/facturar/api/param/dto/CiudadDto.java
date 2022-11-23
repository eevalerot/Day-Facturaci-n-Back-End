package com.daycam.facturar.api.param.dto;

import java.io.Serializable;

public class CiudadDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6603661173226426508L;

	private String nombre;
	private int id;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
