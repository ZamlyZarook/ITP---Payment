<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Receipt download </title>
		<link rel="stylesheet" href="Assets/CSS/payment.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="Assets/JS/payment.js"></script>
	</head>
	<body>
		
		
		<br><br><br>
		
		<div class="pay5">
			<h1>Payment Receipt</h1>
			<form  action="views"  method ="post">
			<input type="Submit" name="btn1" value="Create Receipt"/>
			</form>
		</div>
		<br><br><br>
		
		<table class="styled-table2">
		<c:forEach var="detail" items="${paymentDet}">
			<tr class="active-row">
				<td> Name </td>
				<td>${detail.name }</td>
			</tr>
			<tr class="active-row">
				<td> Vehicle Number </td>
				<td>${detail.vehicleNo }</td>
			</tr>
			<tr class="active-row">
				<td> Date and Time</td>
				<td>${detail.datetime }</td>
			</tr>
			<tr class="active-row">
				<td> NIC </td>
				<td>${detail.nic }</td>
			</tr>
			<tr class="active-row">
				<td> Email </td>
				<td>${detail.email }</td>
			</tr>
			<tr class="active-row">
				<td> Fuel </td>
				<td>${detail.fuel } Liters</td>
			</tr>
			<tr class="active-row">
				<td> Payment Amount </td>
				<td>${detail.amount }</td>
			</tr>
		</c:forEach>
		</table>
		<br><br><br>
		<div class="pay4">
			<form  action="#"  method ="post">
			<input type="Submit" name="btn1" value="Download Receipt"/>
			</form>
		</div>
	
	</body>
</html>