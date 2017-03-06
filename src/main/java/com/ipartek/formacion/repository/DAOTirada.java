package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Tirada;

public interface DAOTirada {

	void setDatasource(DataSource ds);


	List<Tirada> getAllById(long id);

	boolean addTirada(int id_usuario);
	

}
