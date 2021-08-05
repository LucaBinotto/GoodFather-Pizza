package it.epicode.be.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePizza implements Pizza {
	private double price = 4.30;
	private String name = "Base pomodoro:\t";
	protected int calories = 1012;
	protected String nota = "";

	@Override
	public String getTopping() {
		return "tomato";
	}

	@Override
	public String stampa() {
		return getName() + getCalories() + "\t" + getPrice() + "\t" + "(" + getTopping() + ")";
	}

	public void setNota(String nota) {
		this.nota="\tNota: "+nota;
	}
}
