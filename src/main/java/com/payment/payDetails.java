package com.payment;

public class payDetails {
	
	private String name;
	private String vehicleNo;
	private String datetime;
	private String nic;
	private String email;
	private float fuel;
	private double amount;
	
	public payDetails(String name, String vehicleNo, String datetime, String nic, String email, float fuel,
			double amount) {
		
		this.name = name;
		this.vehicleNo = vehicleNo;
		this.datetime = datetime;
		this.nic = nic;
		this.email = email;
		this.fuel = fuel;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public String getDatetime() {
		return datetime;
	}

	public String getNic() {
		return nic;
	}

	public String getEmail() {
		return email;
	}

	public double getFuel() {
		
		return (amount/fuel);
	}

	public double getAmount() {
		return amount;
	}

}
