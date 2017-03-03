package com.ipartek.formacion.domain;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {

	private long id;

	private String nombre;

	private Date fecha_alta;

	private Date fecha_modificacion;

	private Date fecha_baja;

	private ArrayList<Tirada> listaTiradas;

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.fecha_alta = new Date();
		this.fecha_baja = null;
		this.fecha_modificacion = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public ArrayList<Tirada> getListaTiradas() {
		return listaTiradas;
	}

	public void setListaTiradas(ArrayList<Tirada> listaTiradas) {
		this.listaTiradas = listaTiradas;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fecha_alta=" + fecha_alta + ", fecha_modificacion="
				+ fecha_modificacion + ", fecha_baja=" + fecha_baja + ", listaTiradas=" + listaTiradas + "]";
	}

}
