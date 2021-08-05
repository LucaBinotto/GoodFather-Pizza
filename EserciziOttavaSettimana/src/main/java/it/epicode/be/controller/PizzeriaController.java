package it.epicode.be.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.epicode.be.model.Menu;
import it.epicode.be.model.Ordine.Stato;
import it.epicode.be.model.RegistroOrdini;

@Controller
public class PizzeriaController {
@Autowired
Menu menu;
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
	
	@GetMapping("/ordini")
	public String ordini(Map<String,Object> model) {
		model.put("reg", reg);
		return "listaOrdini";
	}
		
	@GetMapping("/getOrdine")
	public String ordine(Map<String,Object> model,@RequestParam String codiceOrdine) {
		if(Long.parseLong(codiceOrdine)<=reg.getOrdini().size()) {
		model.put("reg", reg);
		long codOrd = Long.parseLong(codiceOrdine);
		model.put("co", codOrd);
		return "ordine";
		}else {
			return "errorOrdine";
		}
	}
	
	
	@GetMapping("/updateStato")
	public String update(Map<String,Object> model,@RequestParam String stato,@RequestParam String codiceOrdine) {
		model.put("reg", reg);
		long codOrd = Long.parseLong(codiceOrdine);
		reg.getOrdine(codOrd).setStato(Stato.valueOf(stato));
		return "listaOrdini";
		
	}
	
		
}
