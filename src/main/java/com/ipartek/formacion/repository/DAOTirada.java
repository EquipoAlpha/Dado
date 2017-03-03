package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Tirada;
import com.ipartek.formacion.domain.Usuario;

public interface DAOTirada {

	void setDatasource(DataSource ds);

	/**
	 * Documentar esto
	 * 
	 * @return
	 */
	List<Tirada> getAllById(long id);

	boolean addTirada(int id_usuario);
	

}
