package com.payment;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/UpdatePayServlet")
public class UpdatePayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("pid"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		String date = request.getParameter("datetime");
		String vehicleNo = request.getParameter("vehicleNo");
		
		boolean isTrue;
		
		isTrue = PaymentDBUtil.updatePayment(id, amount, date, vehicleNo);
		
		if (isTrue == true) {
			
			List<PayDetails2> payDetails = PaymentDBUtil.getPaymentDetails(id);
			request.setAttribute("retreve", payDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("PaymentAdmin.jsp");
			dis.forward(request, response);
		}else {
			List<PayDetails2> payDetails = PaymentDBUtil.getPaymentDetails(id);
			request.setAttribute("retreve", payDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("PaymentAdmin.jsp");
			dis.forward(request, response);
		}
	}

}
