package com.ipartek.formacion.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.repository.DAOUsuario;

@Service("serviceUsuario")
public class ServiceUsuarioImpl implements ServiceUsuario {

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DAOUsuario daoUsuario;

	@Override
	public List<Usuario> ObtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crear(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
