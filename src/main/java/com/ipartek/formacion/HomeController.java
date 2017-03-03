package com.ipartek.formacion;


import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.service.ServiceTirada;
import com.ipartek.formacion.service.ServiceUsuario;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	@Autowired
	private ServiceTirada serviceTirada;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("usuarios",serviceUsuario.obtenerTodos());
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePOST(Locale locale, Model model) {
		ArrayList<Usuario> listaUsuario=(ArrayList<Usuario>) serviceUsuario.obtenerTodos();
		int numeroAleatorio = getNumeroAleatorio((listaUsuario.size() - 1));
		Usuario u=serviceUsuario.buscarPorId(listaUsuario.get(numeroAleatorio).getId());
		serviceTirada.añadirTirada((int) u.getId());
		listaUsuario=(ArrayList<Usuario>) serviceUsuario.obtenerTodos();
		model.addAttribute("usuarios",listaUsuario);

		model.addAttribute("afortunado",listaUsuario.get(numeroAleatorio).getNombre());

		return "home";
	}
	
	private int getNumeroAleatorio(int maximoValor) {
		return (int) (Math.random() * maximoValor);
}
}
