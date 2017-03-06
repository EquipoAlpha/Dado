package com.ipartek.formacion.domain;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {

	private long id;

	private String nombre;

	private Date fechaAlta;

	private Date fechaModificacion;

	private Date fechaBaja;

	private int numTiradas;
	
	private ArrayList<Tirada> listaTiradas;

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.fechaAlta = new Date();
		this.fechaBaja = null;
		this.fechaModificacion = new Date();
		this.numTiradas=-1;
	}


	public int getNumTiradas() {
		return numTiradas;
	}


	public void setNumTiradas(int numTiradas) {
		this.numTiradas = numTiradas;
	}


	public long getId() {
		return this.id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return this.nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getFechaAlta() {
		return this.fechaAlta;
	}


	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}


	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public Date getFechaBaja() {
		return this.fechaBaja;
	}


	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}


	public ArrayList<Tirada> getListaTiradas() {
		return this.listaTiradas;
	}


	public void setListaTiradas(ArrayList<Tirada> listaTiradas) {
		this.listaTiradas = listaTiradas;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + this.id + ", nombre=" + this.nombre + ", fecha_alta=" + this.fechaAlta + ", fecha_modificacion="
				+ this.fechaModificacion + ", fecha_baja=" + this.fechaBaja + ", listaTiradas=" + this.listaTiradas + "]";
	}

}
