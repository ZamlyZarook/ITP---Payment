package com.payment;

public class FuelCalculater {
	
	 static int fuelAmount;
	 static float Fuelprice;

	public static void SetFuel(int fuel) {
		
		fuelAmount = fuel;
	}

	public static void setFuelprice(float fuelprice) {
		Fuelprice = fuelprice;
	}
	
	public static double calcAmount() {
		return  (fuelAmount * Fuelprice);
	}
 
}
