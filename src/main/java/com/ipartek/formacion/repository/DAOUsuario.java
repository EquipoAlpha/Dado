package com.ipartek.formacion.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Usuario;

public interface DAOUsuario {

	void setDatasource(DataSource ds);

	/**
	 * Documentar esto
	 * 
	 * @return List<Usuario>
	 */
	List<Usuario> getAll();

	Usuario getById(long id);

	boolean insert(Usuario u);

	boolean update(Usuario u);

	boolean delete(long id);

	List<Usuario> getAllDeleted();

	boolean activate(long idUsuario);

	ArrayList<Usuario> getRanking();

}
