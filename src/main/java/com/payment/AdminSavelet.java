package com.payment;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AdminSavelet")
public class AdminSavelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int plateNumber = Integer.parseInt(request.getParameter("payId")) ;
		
		List<PayDetails2> reteve = PaymentDBUtil.RetevePaymentbyId(plateNumber);
		request.setAttribute( "retreve" , reteve);
		
		RequestDispatcher dis = request.getRequestDispatcher("PaymentAdmin.jsp");
		dis.forward(request, response);
		
	}

}
