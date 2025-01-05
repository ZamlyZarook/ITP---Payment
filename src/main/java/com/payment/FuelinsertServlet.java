package com.payment;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Fuelinsert")
public class FuelinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fuelamount = Integer.parseInt(request.getParameter("quantity"));
		FuelCalculater.fuelAmount = fuelamount;
		
		try {
			double calcamuont = FuelCalculater.calcAmount(); 
			request.setAttribute("calcamuont", calcamuont);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("payment.jsp");
		dis.forward(request, response);
		
		
		//insert into Database part
		boolean IsTrue;
		
		IsTrue = PaymentDBUtil.insertpayment(fuelamount);
		
		if (IsTrue == true )
		{
			RequestDispatcher show = request.getRequestDispatcher("payment.jsp");
			show.forward(request, response);
		}else {
			RequestDispatcher show1 = request.getRequestDispatcher("payment.jsp");
			show1.forward(request, response);
	}
		
	}	

}
