package it.epicode.be.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.epicode.be.model.Menu;
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
		model.put("reg", reg);
		long codOrd = Long.parseLong(codiceOrdine);
		model.put("co", codOrd);
		return "ordine";
	}
	
	@GetMapping("/hello1")
	public @ResponseBody String helloName1(@RequestParam String name) {
		return "Hello, "+name+" welcome to Hell";
	}
	
	
	
	
	
	
	
	
//	<table>
//	  <tr>
//	    <th>NAME</th>
//	    <th>PRICE</th>
//	    <th>IN STOCK</th>
//	  </tr>
//	  <tr th:each="prod : ${prods}" th:class="${prodStat.odd}? 'odd'">
//	    <td th:text="${prod.name}">Onions</td>
//	    <td th:text="${prod.price}">2.41</td>
//	    <td th:text="${prod.inStock}? #{true} : #{false}">yes</td>
//	  </tr>
//	</table>
//	
	
	
	
}
