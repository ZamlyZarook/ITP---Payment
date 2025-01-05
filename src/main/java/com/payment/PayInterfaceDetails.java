package com.payment;

public class PayInterfaceDetails {
	
	private String VehicleNo;
	private String Uname;
	private String date;
	private double amount;
	private String status;
	
	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}
	public void setUname(String fist, String last ) {
		String name = fist + last;
		Uname = name ;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getVehicleNo() {
		return VehicleNo;
	}
	public String getUname() {
		return Uname;
	}
	public String getDate() {
		return date;
	}
	public double getAmount() {
		return amount;
	}
	public String getStatus() {
		return status;
	}
	

}
