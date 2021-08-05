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
	@Deprecated
	public void setPrice(double price) {
	}

	@Override
	public int getCalories() {
		return 0;
	}

	@Override
	@Deprecated
	public String stampa() {
		return "";
	}

	@Override
	@Deprecated
	public String getName() {
		return "";
	}

	@Override
	@Deprecated
	public void setName(String name) {
	}

	@Override
	@Deprecated
	public void setCalories(int calorie) {

	}

	@Override
	@Deprecated
	public String getNota() {
		return "";
	}

	@Override
	@Deprecated
	public void setNota(String nota) {
	}

}
