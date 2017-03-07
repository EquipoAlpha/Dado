package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Tirada;

/**
 * 
 * @author Curso
 *
 */
public interface DAOTirada {

	/**
	 * 
	 * @param ds datasource
	 */
	void setDatasource(DataSource ds);

	/**
	 * 
	 * @param id id del usuario
	 * @return lista de tiradas
	 */
	List<Tirada> getAllById(long id);

	/**
	 * 
	 * @param id_usuario agregar tirada al usuario
	 * @return si o no agregada
	 */
	boolean addTirada(int id_usuario);
	

}
