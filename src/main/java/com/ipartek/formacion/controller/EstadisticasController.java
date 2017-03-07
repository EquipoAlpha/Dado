package com.ipartek.formacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.service.ServiceUsuario;

/**
 * 
 * @author Curso
 *
 */
@Controller()
@RequestMapping(value = "/estadisticas")
public class EstadisticasController {

	@Autowired()
	private ServiceUsuario serviceUsuario;

	/**
	 * 
	 * @param model modelo de la vista
	 * @return vista
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("usuarios", this.serviceUsuario.obtenerTodos());
		return "estadisticas/estadisticas";
	}

}
