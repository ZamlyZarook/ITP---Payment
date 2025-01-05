package com.payment;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RetreveDetailsSave")
public class RetreveDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btn3") != null){
		    
			try {
				HttpSession session = request.getSession();
				List<PayInterfaceDetails> list = PaymentDBUtil.getAllDetails();
				session.setAttribute("listDetails", list);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			RequestDispatcher distp = request.getRequestDispatcher("PaymentAdmin.jsp");
			distp.forward(request, response);
		       
		 }
	}

}
