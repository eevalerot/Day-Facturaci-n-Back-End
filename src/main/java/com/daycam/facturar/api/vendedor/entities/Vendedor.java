package com.daycam.facturar.api.vendedor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vendedor")
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedorIdGenerator")
	@SequenceGenerator(name = "proveedorIdGenerator", initialValue = 1, allocationSize = 1, sequenceName = "proveedor_id_seq")
	private int id;
	@NotNull(message = "el nombre completo no puede ser nulo")
	@Column(unique = true)
	private String nombre;
	@NotNull(message = "el documento completo no puede ser nulo")
	@Column(unique = true)
	private String documento;
	@NotNull(message = "la dirección completo no puede ser nulo")
	private String direccion;
	@NotNull(message = "el número de teléfono no puede ser nulo")
	private String telefono;
	@NotNull(message = "el email no puede ser nulo")
	private String email;
	@NotNull(message = "el estado no puede ser nulo")
	private String estado;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
