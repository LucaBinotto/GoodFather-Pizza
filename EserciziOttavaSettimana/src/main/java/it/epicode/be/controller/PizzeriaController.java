package it.epicode.be.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.epicode.be.config.ConfigMenu;
import it.epicode.be.model.Menu;
import it.epicode.be.model.Ordine.Stato;
import it.epicode.be.model.RegistroOrdini;

@Controller
public class PizzeriaController {
	@Autowired
	ApplicationContext context = new AnnotationConfigApplicationContext(ConfigMenu.class);
	Menu menu = (Menu) context.getBean("godfather");
	@Autowired
	private RegistroOrdini reg;

	@GetMapping("/menu")
	public String menu(Map<String,Object> model) {
		model.put("menu", menu);
		return "menuPage";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/formOrdine")
	public String formOrdine() {
		return "formOrdine";
	}
	
	@GetMapping("/ordini")
	public String ordini(Map<String,Object> model) {
		model.put("reg", reg);
		return "listaOrdini";
	}
		
	@GetMapping("/getOrdine")
	public String ordine(Map<String,Object> model,@RequestParam String codiceOrdine) {
		if(codiceOrdine.equals("")) {
			return "errorOrdine";
		}
		if(Long.parseLong(codiceOrdine)<=reg.getOrdini().size()) {
		model.put("reg", reg);
		long codOrd = Long.parseLong(codiceOrdine);
		model.put("co", codOrd);
		return "ordine";
		}else {
			return "errorOrdine";
		}
	}
	
	
	@RequestMapping(value="/updateStato", method=RequestMethod.POST)
	public String updatep(Map<String,Object> model,@RequestParam("stato") String stato,@RequestParam("codiceOrdine") String codiceOrdine) {
		model.put("reg", reg);
		long codOrd = Long.parseLong(codiceOrdine);
		reg.getOrdine(codOrd).setStato(Stato.valueOf(stato));
		return "listaOrdini";
		
	}
	
	
}
