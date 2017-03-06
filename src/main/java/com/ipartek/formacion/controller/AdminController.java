package com.ipartek.formacion.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.service.ServiceUsuario;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private ServiceUsuario serviceUsuario;

	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("usuarios", this.serviceUsuario.obtenerTodos());
		model.addAttribute("usuariosBaja", this.serviceUsuario.obtenerTodosBaja());
		return "admin/index";
	}
	
	@RequestMapping(value="/dar-alta" ,method = RequestMethod.GET)
	public String darAlta(Model model) {
		model.addAttribute("usuarios", this.serviceUsuario.obtenerTodosBaja());
		return "admin/darAlta";
	}
	
	@RequestMapping(value="/dar-alta/{idUsuario}" ,method = RequestMethod.GET)
	public String darAlta(Model model,@PathVariable String idUsuario) {
		if(this.serviceUsuario.darAlta(Long.parseLong(idUsuario))){
			ArrayList<Usuario> lista=(ArrayList<Usuario>) this.serviceUsuario.obtenerTodosBaja();
			if(lista.isEmpty()){
				model.addAttribute("usuarios", this.serviceUsuario.obtenerTodos());
				model.addAttribute("usuariosBaja",lista);
				return "admin/index";
			}
			else{
				model.addAttribute("usuarios",lista);
				return "admin/darAlta";
			}
		}
		return "admin/darAlta";
	}
	
	
	
	@RequestMapping(value="/modificar/{idUsuario}" ,method = RequestMethod.GET)
	public String modificar(Model model, @PathVariable String idUsuario) {
		model.addAttribute("usuarios", this.serviceUsuario.obtenerTodos());
		model.addAttribute("usuariosBaja", this.serviceUsuario.obtenerTodosBaja());
		model.addAttribute("usuario",this.serviceUsuario.buscarPorId(Long.parseLong(idUsuario)));
		return "admin/index";
	}
	
	@RequestMapping(value="/modificar/{idUsuario}" ,method = RequestMethod.POST)
	public String modificarPOST(Model model,Usuario u) {
		if(this.serviceUsuario.modificar(u)){
			model.addAttribute("usuario",null );
		}else{
			model.addAttribute("usuario",u);
		}
		model.addAttribute("usuarios", this.serviceUsuario.obtenerTodos());	
		model.addAttribute("usuariosBaja", this.serviceUsuario.obtenerTodosBaja());
		return "admin/index";
	}
	
	
	@RequestMapping(value="/crear" ,method = RequestMethod.GET)
	public String modificar(Model model) {
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("usuarios", this.serviceUsuario.obtenerTodos());
		model.addAttribute("usuariosBaja", this.serviceUsuario.obtenerTodosBaja());

		return "admin/index";
	}
	
	@RequestMapping(value="/crear" ,method = RequestMethod.POST)
	public String crearPOST(Model model,Usuario u) {
		if(this.serviceUsuario.crear(u)){
			model.addAttribute("usuarios", this.serviceUsuario.obtenerTodos());
		}
		model.addAttribute("usuario",null);
		model.addAttribute("usuariosBaja", this.serviceUsuario.obtenerTodosBaja());
		return "admin/index";
	}
	
	@RequestMapping(value="/eliminar/{idUsuario}" ,method = RequestMethod.GET)
	public String eliminar(Model model, @PathVariable String idUsuario) {
		if(this.serviceUsuario.eliminar(Long.parseLong(idUsuario))){
			model.addAttribute("usuarios", this.serviceUsuario.obtenerTodos());
		}
		return "admin/index";
	}

}
