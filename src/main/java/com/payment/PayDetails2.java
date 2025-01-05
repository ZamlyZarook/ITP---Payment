package com.payment;

public class PayDetails2 {
	
	private int pid;
	private double amount;
	private String datetime;
	private String vehicleNo;
	
	
	public PayDetails2(int pid, double amount, String datetime, String vehicleNo) {
		this.pid = pid;
		this.amount = amount;
		this.datetime = datetime;
		this.vehicleNo = vehicleNo;
	}


	public int getPid() {
		return pid;
	}


	public double getAmount() {
		return amount;
	}


	public String getDatetime() {
		return datetime;
	}


	public String getVehicleNo() {
		return vehicleNo;
	}
	

}
