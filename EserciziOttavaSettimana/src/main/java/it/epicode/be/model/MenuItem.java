package it.epicode.be.model;

public interface MenuItem {
	public static final int NAME_LENGTH = 25;
	
	public double getPrice();
	public String stampa();
	public String getName();
	public void setName(String name);
	public void setPrice(double price);


}
