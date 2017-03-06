package com.ipartek.formacion.domain;

import java.util.Date;

public class Tirada {

	private long idTirada;
	private Date fechaTirada;

	public Tirada() {
		super();
		this.idTirada = -1;
		this.fechaTirada = new Date();
	}

	public Tirada(long idTirada, Date fechaTirada) {
		super();
		this.idTirada = idTirada;
		this.fechaTirada = fechaTirada;
	}
	
	

	public long getIdTirada() {
		return this.idTirada;
	}

	public void setIdTirada(long idTirada) {
		this.idTirada = idTirada;
	}

	public Date getFechaTirada() {
		return this.fechaTirada;
	}

	public void setFechaTirada(Date fechaTirada) {
		this.fechaTirada = fechaTirada;
	}

	@Override
	public String toString() {
		return "Tirada [id_tirada=" + this.idTirada + ", fecha_tirada=" + this.fechaTirada + "]";
	}

}
