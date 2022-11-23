package com.daycam.facturar.api.param.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {
	
	@Id
	private int id;
	@Column(name = "codigo_dane")
	private int codigoDane;
	private String nombre;
	private Boolean estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pais", nullable = false)
	private Pais pais;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoDane() {
		return codigoDane;
	}

	public void setCodigoDane(int codigoDane) {
		this.codigoDane = codigoDane;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	

}
