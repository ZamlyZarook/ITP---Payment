<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update Payment</title>
		<link rel="stylesheet" href="Assets/CSS/payment.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="Assets/JS/payment.js"></script>
	</head>
	<body>
		
		<% 
			String pid = request.getParameter("pid");
			String amount = request.getParameter("amount");
			String date = request.getParameter("datetime");
			String vehicleno = request.getParameter("vehicleNo");
		%>
		
		<div class="heading">
			<h1> Welcome to Payment Management</h1>
		</div>
		
		<form action="updating" method="post">
			<table class="styled-table5">
				<tr class="active-row">
					<td> PID </td>
					<td> <input type="number" name="pid" value="<%=pid %>" readonly><br> </td>
				</tr>
				<tr class="active-row">
					<td> Amount </td>
					<td> <input type="number" name="amount" value="<%=amount %>"> </td>
				</tr>
				<tr class="active-row">
					<td>Date and Time</td>
					<td> <input type="datetime" name="datetime" value="<%=date %>"> </td>
				</tr>
				<tr class="active-row">
						<td> Vehicle Number </td>
						<td> <input type="text" name="vehicleNo" value="<%=vehicleno %>" readonly ></td>
					</tr>
			</table>
			
			<div class="updelete">
				<input type="submit" name="submit" value="Update Payment Transection">
			</div> 
		</form>

	</body>
</html>