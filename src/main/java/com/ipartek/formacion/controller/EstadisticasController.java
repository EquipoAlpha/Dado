package com.ipartek.formacion.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/estadisticas")
public class EstadisticasController {


	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {
		return "estadisticas/estadisticas";
	}

}