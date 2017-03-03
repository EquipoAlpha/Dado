package com.ipartek.formacion.domain;

import java.util.Date;

public class Tirada {
	private long id_tirada;
	private Date fecha_tirada;

	public Tirada() {
		super();
		this.id_tirada = -1;
		this.fecha_tirada = new Date();
	}

	public long getId_tirada() {
		return id_tirada;
	}

	public void setId_tirada(long id_tirada) {
		this.id_tirada = id_tirada;
	}

	public Date getFecha_tirada() {
		return fecha_tirada;
	}

	public void setFecha_tirada(Date fecha_tirada) {
		this.fecha_tirada = fecha_tirada;
	}

	@Override
	public String toString() {
		return "Tirada [id_tirada=" + id_tirada + ", fecha_tirada=" + fecha_tirada + "]";
	}

}
