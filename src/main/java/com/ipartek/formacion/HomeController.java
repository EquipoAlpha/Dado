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

/**
 * 
 * @author Curso
 *
 */
@Controller()
public class HomeController {

	@Autowired()
	private ServiceUsuario serviceUsuario;
	@Autowired()
	private ServiceTirada serviceTirada;

	/**
	 * 
	 * @param locale aa
	 * @param model modelo de la vista
	 * @return vista
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		ArrayList<Usuario> listaUsuario = (ArrayList<Usuario>) this.serviceUsuario.obtenerRanking();
		model.addAttribute("usuarios", listaUsuario);
		return "home";
	}
	/**
	 * 
	 * @param locale aa
	 * @param model modelo de la vista
	 * @return vista
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePOST(Locale locale, Model model) {
		ArrayList<Usuario> listaUsuario=(ArrayList<Usuario>) this.serviceUsuario.obtenerTodos();
		if(listaUsuario.isEmpty())
		{
			model.addAttribute("afortunado", "-1");
		}else{
			
			int numeroAleatorio = this.getNumeroAleatorio(listaUsuario.size());
			Usuario u = this.serviceUsuario.buscarPorId(listaUsuario.get(numeroAleatorio).getId());
			this.serviceTirada.aniadirTirada((int) u.getId());
			listaUsuario = (ArrayList<Usuario>) this.serviceUsuario.obtenerRanking();
			model.addAttribute("afortunado", u.getNombre());
		}
		model.addAttribute("usuarios", listaUsuario);


		return "home";
	}

	/**
	 * 
	 * @param maximoValor valor maximo a recibir
	 * @return numero aleatorio
	 */
	private int getNumeroAleatorio(int maximoValor) {
		return (int) (Math.random() * maximoValor);
	}
}
