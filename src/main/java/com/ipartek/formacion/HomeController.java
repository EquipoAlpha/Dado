package com.ipartek.formacion;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.service.ServiceTirada;
import com.ipartek.formacion.service.ServiceUsuario;

@Controller
public class HomeController {

	@Autowired
	private ServiceUsuario serviceUsuario;
	@Autowired
	private ServiceTirada serviceTirada;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		ArrayList<Usuario> listaUsuario = (ArrayList<Usuario>) this.serviceUsuario.obtenerRanking();
		model.addAttribute("usuarios", listaUsuario);
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePOST(Locale locale, Model model) {
		ArrayList<Usuario> listaUsuario = (ArrayList<Usuario>) this.serviceUsuario.obtenerRanking();
		
		int numeroAleatorio = this.getNumeroAleatorio(listaUsuario.size());
		Usuario u = this.serviceUsuario.buscarPorId(listaUsuario.get(numeroAleatorio).getId());
		
		this.serviceTirada.aniadirTirada((int) u.getId());
		listaUsuario = (ArrayList<Usuario>) this.serviceUsuario.obtenerRanking();
		model.addAttribute("usuarios", listaUsuario);

		model.addAttribute("afortunado", u.getNombre());

		return "home";
	}

	private int getNumeroAleatorio(int maximoValor) {
		return (int) (Math.random() * maximoValor);
	}
}
