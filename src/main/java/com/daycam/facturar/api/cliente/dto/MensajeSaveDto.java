package com.daycam.facturar.api.cliente.dto;

import java.io.Serializable;

public class MensajeSaveDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5742634109588617324L;
	
	private String mensajeOK;

	public String getMensajeOK() {
		return mensajeOK;
	}

	public void setMensajeOK(String mensajeOK) {
		this.mensajeOK = mensajeOK;
	}
	
	

}
