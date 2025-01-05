package com.payment;

public class Details {
	
		private String fistName;
		private float remaingFuel;
		private String nic;
		private String email;
		private float fuelLimit;
		private float sellingPrice;
		static double price;
		static float remfuel;

		public Details(String fistName, float remaingFuel, String nic, String email, float fuelLimit, float sellingPrice) {
			
			this.fistName = fistName;
			this.remaingFuel = remaingFuel;
			this.nic = nic;
			this.email = email;
			this.fuelLimit = fuelLimit;
			this.sellingPrice = sellingPrice;
		}

		public String getFistName() {
			return fistName;
		}

		public String getEmail() {
			return email;
		}

		public String getNic() {
			return nic;
		}

		public float getRemaingFuel() {
			remfuel = remaingFuel;
			return remaingFuel;
		}

		public float getFuelLimit() {
			return fuelLimit;
		}

		public double getSellingPrice() {
			return sellingPrice;
		}
}
