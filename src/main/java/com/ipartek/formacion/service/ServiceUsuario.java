package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.domain.Usuario;

/**
 * 
 * @author Curso
 *
 */
public interface ServiceUsuario {

	/**
	 * 
	 * @return lista usuario
	 */
	List<Usuario> obtenerTodos(); /*
									 * No obtener las de fecha de baja distinto
									 * de null
									 */

	/**
	 * 
	 * @param id id del usuario que se quiere buscar
	 * @return usuario
	 */
	Usuario buscarPorId(long id);

	/**
	 * 
	 * @param u usuario a crear
	 * @return si o no creado
	 */
	boolean crear(Usuario u); /* poner fecha_alta, fecha_modificacion */

	/**
	 * 
	 * @param u usuario a modificar
	 * @return si o no modificado
	 */
	boolean modificar(Usuario u); /* modificar fecha_modificacion */

	/**
	 * 
	 * @param id usuario a eliminar
	 * @return si o no eliminado
	 */
	boolean eliminar(
			long id); /* Este metodo pone fecha de baja de null a actual */

	/**
	 * 
	 * @return lista usuario
	 */
	List<Usuario> obtenerTodosBaja();

	/**
	 * 
	 * @param l id de usuario a dar de alta
	 * @return si o no baja
	 */
	boolean darAlta(long l);

	/**
	 * 
	 * @return lista usuario
	 */
	ArrayList<Usuario> obtenerRanking();

}
