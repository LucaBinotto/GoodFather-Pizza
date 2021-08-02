package it.epicode.be.model;

public interface Pizza {

	public String getTopping();
	
	public double getPrice();
	
	public void setPrice(double price);
	
	public void setCalories(int calorie);
	
	public int getCalories();
	
	public String stampa();
	
	public String getName();
	
	public void setName(String name);
	
	
}
