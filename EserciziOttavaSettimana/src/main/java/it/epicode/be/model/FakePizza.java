package it.epicode.be.model;

public class FakePizza implements Pizza {

	@Override
	public String getTopping() {
		return "fake";
	}

	@Override
	public double getPrice() {
		return 0;
	}

	@Override
	public void setPrice(double price) {	
	}

	@Override
	public int getCalories() {
		return 0;
	}

	@Override
	public String stampa() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void setName(String name) {		
	}

}
