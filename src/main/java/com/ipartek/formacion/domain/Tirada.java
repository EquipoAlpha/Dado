package com.ipartek.formacion.domain;

import java.util.Date;

/**
 * 
 * @author Curso
 *
 */
public class Tirada {

	private long idTirada;
	private Date fechaTirada;

	/**
	 * 
	 */
	public Tirada() {
		super();
		this.idTirada = -1;
		this.fechaTirada = new Date();
	}

	/**
	 * 
	 * @param idTirada id de la tirada
	 * @param fechaTirada fecha realizada tirada
	 */
	public Tirada(long idTirada, Date fechaTirada) {
		super();
		this.idTirada = idTirada;
		this.fechaTirada = fechaTirada;
	}
	
	
	/**
	 * 
	 * @return id tirada
	 */
	public long getIdTirada() {
		return this.idTirada;
	}

	/**
	 * 
	 * @param idTirada id de la tidara
	 */
	public void setIdTirada(long idTirada) {
		this.idTirada = idTirada;
	}

	/**
	 * 
	 * @return fechaTirada
	 */
	public Date getFechaTirada() {
		return this.fechaTirada;
	}

	/**
	 * 
	 * @param fechaTirada fecha de la tirada
	 */
	public void setFechaTirada(Date fechaTirada) {
		this.fechaTirada = fechaTirada;
	}

	@Override()
	public String toString() {
		return "Tirada [id_tirada=" + this.idTirada + ", fecha_tirada=" + this.fechaTirada + "]";
	}

}
