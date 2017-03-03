package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Usuario;

public interface ServiceUsuario {

	List<Usuario> obtenerTodos(); /*
									 * No obtener las de fecha de baja distinto
									 * de null
									 */

	Usuario buscarPorId(long id);

	boolean crear(Usuario u); /* poner fecha_alta, fecha_modificacion */

	boolean modificar(Usuario u); /* modificar fecha_modificacion */

	boolean eliminar(
			long id); /* Este metodo pone fecha de baja de null a actual */

}
