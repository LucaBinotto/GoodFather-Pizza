package it.epicode.be.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
@Getter
@Component
public class RegistroOrdini {
	
	@Getter
	List<Ordine> ordini = new ArrayList<>();
	
	public void add(Ordine ord) {
		ordini.add(ord);
	}
	
	public Ordine getOrdine(Long numeroOrdine) {
		return ordini.stream().filter(o->o.getNumeroOrdine()==numeroOrdine).findFirst().orElseThrow();
	}
}
