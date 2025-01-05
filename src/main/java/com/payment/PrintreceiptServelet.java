package com.payment;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Printreceipt")
public class PrintreceiptServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btn1") != null){
		    
			try {
				List<payDetails> paymentDet =  PaymentDBUtil.retrieveDetails();
				request.setAttribute("paymentDet", paymentDet);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			RequestDispatcher distp = request.getRequestDispatcher("Reciptpage.jsp");
			distp.forward(request, response);
		       
		 }
		
	}

}
