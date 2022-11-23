package com.daycam.facturar.api.cliente.dto;

import java.io.Serializable;

import com.daycam.facturar.api.param.entities.Ciudad;

public class ClienteDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5477670368753739369L;
	
	private int id;
	private String fullName;
	private String documento;
	private String direccion;
	private String telefono;
	private String email;
	private String nombreRemitente;
	private String documentoRemitente;
	private String telefonoRemitente;
	private Ciudad ciudad;
	private Boolean enabled;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombreRemitente() {
		return nombreRemitente;
	}
	public void setNombreRemitente(String nombreRemitente) {
		this.nombreRemitente = nombreRemitente;
	}
	public String getDocumentoRemitente() {
		return documentoRemitente;
	}
	public void setDocumentoRemitente(String documentoRemitente) {
		this.documentoRemitente = documentoRemitente;
	}
	public String getTelefonoRemitente() {
		return telefonoRemitente;
	}
	public void setTelefonoRemitente(String telefonoRemitente) {
		this.telefonoRemitente = telefonoRemitente;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
