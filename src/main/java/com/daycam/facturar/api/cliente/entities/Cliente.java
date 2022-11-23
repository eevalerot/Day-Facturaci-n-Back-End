package com.daycam.facturar.api.cliente.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.daycam.facturar.api.commons.Base;
import com.daycam.facturar.api.param.entities.Ciudad;

@Entity
@Table(name = "cliente")
public class Cliente extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7582401018241105896L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clienteIdGenerator")
	@SequenceGenerator(name = "clienteIdGenerator", initialValue = 1, allocationSize = 1, sequenceName = "cliente_id_seq")
	private int id;
	@NotNull(message = "el nombre completo no puede ser nulo")
	@Column(name = "full_name", unique = true)
	private String fullName;
	@NotNull(message = "el documento no puede ser nulo")
	@Column(unique = true)
	private String documento;
	@NotNull(message = "la dirección no puede ser nulo")
	private String direccion;
	@NotNull(message = "el telefono no puede ser nulo")
	private String telefono;
	@NotNull(message = "el correo no puede ser nulo")
	private String email;
	@NotNull(message = "el nombre del remitente no puede ser nulo")
	@Column(name = "nombre_remitente")
	private String nombreRemitente;
	@NotNull(message = "el documento del remitente no puede ser nulo")
	@Column(name = "documento_remitente")
	private String documentoRemitente;
	@NotNull(message = "el telefono del remitente no puede ser nulo")
	@Column(name = "telefono_remitente")
	private String telefonoRemitente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ciudad", nullable = true)
	private Ciudad ciudad;
	
	
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


}
