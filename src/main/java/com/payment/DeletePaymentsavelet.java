package com.payment;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeletePaymentsavelet")
public class DeletePaymentsavelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		boolean isTrue;
		
		isTrue = PaymentDBUtil.deletePayment(pid);
		
		if ( isTrue == true)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentAdmin.jsp");
			dispatcher.forward(request, response);
		}else {
			
			List<PayDetails2> payDetail = PaymentDBUtil.getPaymentDetails(pid);
			request.setAttribute("retreve", payDetail);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentAdmin");
			dispatcher.forward(request, response);
		}
	}

}
