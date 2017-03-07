package com.ipartek.formacion.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Usuario;
/**
 * 
 * @author Curso
 *
 */
public interface DAOUsuario {

	/**
	 * 
	 * @param ds datasource
	 */
	void setDatasource(DataSource ds);

	/**
	 * Documentar esto
	 * 
	 * @return List<Usuario> lista con todos los usuarios
	 */
	List<Usuario> getAll();

	/**
	 * 
	 * @param id id del usuario a obtener
	 * @return usuario
	 */
	Usuario getById(long id);

	/**
	 * 
	 * @param u usuario a insertar
	 * @return si o no insertado
	 */
	boolean insert(Usuario u);

	/**
	 * 
	 * @param u usuario a modificar
	 * @return si o no modificado
	 */
	boolean update(Usuario u);

	/**
	 * 
	 * @param id id del usuario a eliminar
	 * @return si o no eliminado
	 */
	boolean delete(long id);

	/**
	 * 
	 * @return lista de usuarios
	 */
	List<Usuario> getAllDeleted();

	/**
	 * 
	 * @param idUsuario id del usuario a activar
	 * @return si o no activado
	 */
	boolean activate(long idUsuario);

	/**
	 * 
	 * @return lista usuario
	 */
	ArrayList<Usuario> getRanking();

}
