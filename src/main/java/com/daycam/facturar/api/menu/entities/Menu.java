package com.daycam.facturar.api.menu.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.daycam.facturar.api.security.entity.Rol;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2183226237713509377L;
	
	@Id
	private int id;
	@NotNull(message = "no puede ser nulo")
	@Column(name = "imagen_modulo")
	private String imagenModulo;
	@NotNull(message = "no puede ser nulo")
	private String modulo;
	@NotNull(message = "no puede ser nulo")
	private String ruta;
	@NotNull(message = "no puede ser nulo")
	private Boolean estado;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol", nullable = false)
	private Rol rol;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
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
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	

}
