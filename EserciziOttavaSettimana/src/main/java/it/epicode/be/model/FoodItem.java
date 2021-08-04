package it.epicode.be.model;

public interface FoodItem extends MenuItem {

	public static final int CAL_LENGTH = 10;
	
	public void setCalories(int calorie);
	public int getCalories();
	public default String getCaloriesSt() {
		String cal = ""+getCalories();
		
		int a = cal.length();
		int diff = CAL_LENGTH - a;
		for (int i = 0; i < diff; i++) {
			cal += " ";
		}
		return cal;
	}
}
