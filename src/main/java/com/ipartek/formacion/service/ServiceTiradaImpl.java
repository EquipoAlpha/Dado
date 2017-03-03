package com.ipartek.formacion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ipartek.formacion.repository.DAOTirada;


@Service("serviceTirada")
public class ServiceTiradaImpl implements ServiceTirada {



	
	@Autowired
	private DAOTirada daoTirada;


	@Override
	public boolean añadirTirada(int id_usuario) {
		// TODO Auto-generated method stub
		return daoTirada.addTirada(id_usuario);
	}
	

	
}
