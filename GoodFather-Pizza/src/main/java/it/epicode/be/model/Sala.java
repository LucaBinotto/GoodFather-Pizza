package it.epicode.be.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
@Component

public class Sala {
	@Getter
	List<Tavolo> tavoli = new ArrayList<>();
	
	public void add(Tavolo tavolo) {
		tavoli.add(tavolo);
	}
	
}
