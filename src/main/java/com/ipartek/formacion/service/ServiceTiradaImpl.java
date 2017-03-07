package com.ipartek.formacion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ipartek.formacion.repository.DAOTirada;

/**
 * 
 * @author Curso
 *
 */
@Service(value="serviceTirada")
public class ServiceTiradaImpl implements ServiceTirada {



	
	@Autowired()
	private DAOTirada daoTirada;


	@Override()
	public boolean aniadirTirada(int idUsuario) {
		return this.daoTirada.addTirada(idUsuario);
	}
	

	
}
