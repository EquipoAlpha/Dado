package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Tirada;
import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.repository.DAOTirada;
import com.ipartek.formacion.repository.DAOUsuario;

@Service(value="serviceUsuario")
public class ServiceUsuarioImpl implements ServiceUsuario {


	@Autowired
	private DAOUsuario daoUsuario;
	
	@Autowired
	private DAOTirada daoTirada;
	

	@Override
	public List<Usuario> obtenerTodos() {

		ArrayList<Usuario> listaUsuarios=(ArrayList<Usuario>)this.daoUsuario.getAll();
		for(Usuario u : listaUsuarios){
			u.setListaTiradas((ArrayList<Tirada>)this.daoTirada.getAllById(u.getId()));
		}
		return listaUsuarios;
	}

	@Override
	public Usuario buscarPorId(long id) {

		return this.daoUsuario.getById(id);
	}

	@Override
	public boolean crear(Usuario u) {

		return this.daoUsuario.insert(u);
	}

	@Override
	public boolean modificar(Usuario u) {
		return this.daoUsuario.update(u);
	}

	@Override
	public boolean eliminar(long id) {

		return this.daoUsuario.delete(id);
	}

	@Override
	public List<Usuario> obtenerTodosBaja() {
		// TODO Auto-generated method stub
		ArrayList<Usuario> listaUsuarios=(ArrayList<Usuario>)this.daoUsuario.getAllDeleted();
		for(Usuario u : listaUsuarios){
			u.setListaTiradas((ArrayList<Tirada>)this.daoTirada.getAllById(u.getId()));
		}
		return listaUsuarios;
	}


	@Override
	public boolean darAlta(long idUsuario) {
		// TODO Auto-generated method stub
		return this.daoUsuario.activate(idUsuario);
	}

	@Override
	public ArrayList<Usuario> obtenerRanking() {
		// TODO Auto-generated method stub
		return this.daoUsuario.getRanking();
	}

}
