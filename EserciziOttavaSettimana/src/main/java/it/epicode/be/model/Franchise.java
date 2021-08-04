package it.epicode.be.model;

public class Franchise implements MenuItem{

	private static final int NAME_LENGTH_PLUS = 35;
	private String name;
	private double price;
	@Override
	public String getName() {
		int a = name.length();
		int diff = NAME_LENGTH_PLUS - a;
		for (int i = 0; i < diff; i++) {
			name += " ";
		}
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public double getPrice() {
		return price;
	}
	@Override
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String stampa() {
		return getName() +"\u20ac"+getPrice();
	}
	
}
