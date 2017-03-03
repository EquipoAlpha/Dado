package com.ipartek.formacion.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Usuario;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {


	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {
		return "admin/index";
	}
	
	
	@RequestMapping(value="/modificar/{idUsuario}" ,method = RequestMethod.GET)
	public String modificar(Model model, @PathVariable String idUsuario) {
		Usuario u=new Usuario();
		u.setId(Long.parseLong(idUsuario));
		model.addAttribute("usuario",u);
		return "admin/index";
	}
	
	@RequestMapping(value="/crear" ,method = RequestMethod.GET)
	public String modificar(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "admin/index";
	}

}
