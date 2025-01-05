package com.payment;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/PaymentSavelet")
public class PaymentSavelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String plateNumber = request.getParameter("pid");
		
		List<Details> userDetails =  PaymentDBUtil.validate(plateNumber);
		request.setAttribute("userdetails", userDetails);
		
		RequestDispatcher dis = request.getRequestDispatcher("payment.jsp");
		dis.forward(request, response);
		
		//doGet(request, response);
		
		
	}

}
