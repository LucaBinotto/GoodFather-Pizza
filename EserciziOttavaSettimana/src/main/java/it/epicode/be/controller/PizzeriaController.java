package it.epicode.be.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.epicode.be.config.ConfigMenu;
import it.epicode.be.model.Menu;
import it.epicode.be.model.Ordine;
import it.epicode.be.model.Ordine.Stato;
import it.epicode.be.model.RegistroOrdini;
import it.epicode.be.model.Sala;

@Controller
public class PizzeriaController {
	@Autowired
	ApplicationContext context = new AnnotationConfigApplicationContext(ConfigMenu.class);
	Menu menu = (Menu) context.getBean("godfather");
	@Autowired
	private RegistroOrdini reg;
	@Autowired
	private Sala sala;
	

	private String ritornaListaOrdini(Map<String,Object> model) {
		model.put("reg", reg);
		return "listaOrdini";
	}
	
	
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
	public String formOrdine(Map<String,Object> model) {
		model.put("sala", sala);
		return "formOrdine";
	}
	
	@GetMapping("/ordini")
	public String ordini(Map<String,Object> model) {
		return ritornaListaOrdini(model);
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
	public String updatep(Map<String,Object> model,@RequestParam("stato") String stato,@RequestParam("codiceOrdine") String codiceOrdine,@ModelAttribute("ordine") Ordine ordine) {
		
		System.out.println(ordine.getNumeroOrdine());
		System.out.println(ordine.getCodiceTavolo());
		System.out.println(ordine.getCoperti());
		
		
		long codOrd = Long.parseLong(codiceOrdine);
		reg.getOrdine(codOrd).setStato(Stato.valueOf(stato));
		return ritornaListaOrdini(model);
	}
	
	@RequestMapping(value="/aggiungiOrdine", method=RequestMethod.POST)
	public String aggiungiordine(Map<String,Object> model,@RequestParam("stato") String stato,@RequestParam("data") String data,@RequestParam("ora") String ora,@RequestParam("tavolo") String tavolo) {
		
		Ordine nuovo = (Ordine) context.getBean("ordine");
		nuovo.setStato(Stato.valueOf(stato));
		int year = Integer.parseInt(data.substring(0,4));
		int month= Integer.parseInt(data.substring(5,7));
		int day = Integer.parseInt(data.substring(8,10));
		nuovo.setData(LocalDate.of(year, month, day));
		int ore = Integer.parseInt(ora.substring(0,2));
		int minuti= Integer.parseInt(ora.substring(3,5));
		nuovo.setOra(LocalTime.of(ore, minuti));
		nuovo.setTavolo(sala.getTavoli().stream().filter(o->o.getCodiceTavolo().equals(tavolo)).findFirst().orElseThrow());
		reg.add(nuovo);
		model.put("reg", reg);
		return "listaOrdini";
		
	}
	
	
}
