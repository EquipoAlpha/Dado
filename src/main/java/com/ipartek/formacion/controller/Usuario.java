package com.ipartek.formacion.controller;

public class Usuario {

	private long id;
	private String nombre;
	
	public Usuario(){
		setId(-1);
		setNombre("");
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
}
