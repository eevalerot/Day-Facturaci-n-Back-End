package com.daycam.facturar.api.menu.Dto;

import java.io.Serializable;

public class MenuDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8658785135981258699L;
	
	private String imagenModulo;
	private String modulo;
	private String ruta;
	
	
	public String getImagenModulo() {
		return imagenModulo;
	}
	public void setImagenModulo(String imagenModulo) {
		this.imagenModulo = imagenModulo;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	

}
