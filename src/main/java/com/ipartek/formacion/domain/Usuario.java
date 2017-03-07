package com.ipartek.formacion.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Curso
 *
 */
public class Usuario {

	private long id;

	private String nombre;

	private Date fechaAlta;

	private Date fechaModificacion;

	private Date fechaBaja;

	private int numTiradas;
	
	private ArrayList<Tirada> listaTiradas;

	/**
	 * 
	 */
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.fechaAlta = new Date();
		this.fechaBaja = null;
		this.fechaModificacion = new Date();
		this.numTiradas=-1;
	}

	/**
	 * 
	 * @return numero tiradas
	 */
	public int getNumTiradas() {
		return this.numTiradas;
	}


	/**
	 * 
	 * @param numTiradas numero tiradas
	 */
	public void setNumTiradas(int numTiradas) {
		this.numTiradas = numTiradas;
	}

	/**
	 * 
	 * @return id usuario
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id id del usuario
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return nombre usuario
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return fecha de alta
	 */
	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	/**
	 * 
	 * @param fechaAlta fecha de alta del usuario
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * 
	 * @return fecha modificacion
	 */
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * 
	 * @param fechaModificacion fecha modificacion del usuario
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * 
	 * @return fecha baja
	 */
	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	/**
	 * 
	 * @param fechaBaja fecha baja del usuario
	 */
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	/**
	 * 
	 * @return lista de tiradas
	 */
	public ArrayList<Tirada> getListaTiradas() {
		return this.listaTiradas;
	}

	/**
	 * 
	 * @param listaTiradas lista de las tiradas del usuaro
	 */
	public void setListaTiradas(ArrayList<Tirada> listaTiradas) {
		this.listaTiradas = listaTiradas;
	}


	@Override()
	public String toString() {
		return "Usuario [id=" + this.id + ", nombre=" + this.nombre + ", fecha_alta=" + this.fechaAlta + ", fecha_modificacion="
				+ this.fechaModificacion + ", fecha_baja=" + this.fechaBaja + ", listaTiradas=" + this.listaTiradas + "]";
	}

}
