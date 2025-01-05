package com.payment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDBUtil {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static String vehicleId;
	public static int FuelId;
	public static float sellFuelPrice;

	public static List<Details> validate(String plateNum) {

		ArrayList<Details> det = new ArrayList<>();

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select firstName, v.remainingFuel, NIC, email, fuelLimit, sellingPrice, v.plateNumber, v.fuelID from vehicle v, user u, fuel_type f where v.userID = u.userID and v.fuelID = f.fuelID and v.plateNumber = '"+ plateNum +"'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString(1);
				float RemainFuel = rs.getFloat(2);
				String nic = rs.getString(3);
				String email = rs.getString(4);
				float fuellimit = rs.getFloat(5);
				float sellingprice = rs.getFloat(6);

				Details dt = new Details(name, RemainFuel, nic, email, fuellimit, sellingprice);
				det.add(dt);
				FuelCalculater.setFuelprice(sellingprice);
				vehicleId = rs.getString(7);
				FuelId = rs.getInt(8);
				sellFuelPrice = rs.getFloat(6);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return det;
	}

	public static boolean insertpayment(int FuelAmount) {

		boolean isSuccess = false;
		double fAmount = FuelAmount * sellFuelPrice;
		
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "INSERT INTO payment (pid, amount, vehicleID, fuelID ) VALUES ( 0, '"+ fAmount +"' , '"+ vehicleId +"' , '"+ FuelId +"')";
			int rs = stmt.executeUpdate(sql);
			
			float updatedfuel = Details.remfuel - FuelCalculater.fuelAmount;
			String sqlupdate = "UPDATE vehicle SET remainingFuel = '"+ updatedfuel +"' WHERE plateNumber = '"+ vehicleId +"'";
			
			int rs1 = stmt.executeUpdate(sqlupdate);

			if (rs > 0 && rs1 > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	public static List<payDetails> retrieveDetails() {

		ArrayList<payDetails> pay = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sqlqu = "select firstName , vehicleID, p.date, NIC, email, sellingPrice, amount from payment p, user u , fuel_type f , vehicle v where p.fuelID = f.fuelID and v.plateNumber = p.vehicleID and v.userID = u.userID and p.date = (select max(date) from payment)";
			rs = stmt.executeQuery(sqlqu);

			if (rs.next()) {
				String name = rs.getString(1);
				String vehicleNo = rs.getString(2);
				String datetime = rs.getString(3);
				String nic = rs.getString(4);
				String email = rs.getString(5);
				float sellPrice = rs.getFloat(6);
				double amount = rs.getDouble(7);

				payDetails p = new payDetails(name, vehicleNo, datetime, nic, email, sellPrice, amount);
				pay.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pay;
	}

	public static List<PayInterfaceDetails> getAllDetails() {

		List<PayInterfaceDetails> paym = new ArrayList<PayInterfaceDetails>();

		try {

			con = DBConnect.getConnection();

			String sql = "SELECT vehicleID, firstName, lastName, p.date, amount FROM payment P, user u, vehicle v WHERE p.vehicleID = v.plateNumber and u.userID = v.userID";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				PayInterfaceDetails fist = new PayInterfaceDetails();
				fist.setVehicleNo(rs.getString(1));
				fist.setUname(rs.getString(2), rs.getString(3));
				fist.setDate(rs.getString(4));
				fist.setAmount(rs.getDouble(5));
				paym.add(fist);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return paym;
	}

	public static List<PayDetails2> RetevePaymentbyId(int plateNum) {

		ArrayList<PayDetails2> detail = new ArrayList<>();

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "SELECT pid , amount , p.date , vehicleID FROM payment p where pid = '" + plateNum + "'";
			
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int pid = rs.getInt(1);
				double amount = rs.getDouble(2);
				String date = rs.getString(3);
				String vehicleid = rs.getString(4);

				PayDetails2 data = new PayDetails2(pid, amount, date, vehicleid);
				detail.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return detail;
	}

	public static boolean updatePayment(int pid, double amount, String date, String vehicleNo) {
		boolean isSuccess = false;

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE payment set amount= '" + amount + "' , date = '" + date + "' , vehicleid = '"
								+ vehicleNo +"' where pid = '" + pid + "'";
			
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	public static List<PayDetails2> getPaymentDetails(int pidn) {
		ArrayList<PayDetails2> pay = new ArrayList<>();

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			 
			String sql = " SELECT pid , amount , p.date , vehicleID FROM payment p where pid = '" + pidn + "' ";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int pid = rs.getInt(1);
				double amount = rs.getDouble(2);
				String date = rs.getString(3);
				String vehicleid = rs.getString(4);

				PayDetails2 data = new PayDetails2(pid, amount, date, vehicleid);
				pay.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pay;
	}

	public static boolean deletePayment(int pid) {
		boolean isSuccess = false;

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "delete from payment where pid = '"+pid+"'";
			
			int r = stmt.executeUpdate(sql);

			if (r > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

}
