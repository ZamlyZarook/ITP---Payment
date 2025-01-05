<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.payment.PayInterfaceDetails"%>
<%@page import="com.payment.PaymentDBUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Payment Administration Page </title>
		<link rel="stylesheet" href="Assets/CSS/payment.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="Assets/JS/payment.js"></script>
	</head>
	<body>
		
		<div class="heading">
			<h1> Welcome to Payment Management</h1>
		</div>
		
		<br><br><br>
		<div class="admin0">
			<div class="admin1">
				<form action="showpay" method="post">
					<h2> View Payment by Id </h2><input type="number" name="payId"><br><br>
					<input type="submit" name="submit" value="View">
				</form>
			</div>
		</div>
		
		<br><br><br>
		
		<table class="styled-table3">
		<c:forEach var="det" items="${retreve}">
		
			<c:set var="pid" value="${det.pid }" />
			<c:set var="amount" value="${det.amount}" />
			<c:set var="datetime" value="${det.datetime}" />
			<c:set var="vehicleNo" value="${det.vehicleNo}" />
			
			<tr class="active-row">
				<td> PID </td>
				<td>${det.pid }</td>
			</tr>
			<tr class="active-row">
				<td> Amount </td>
				<td>${det.amount }</td>
			</tr>
			<tr class="active-row">
				<td>Date and Time</td>
				<td>${det.datetime }</td>
			</tr>
			<tr class="active-row">
				<td> Vehicle Number </td>
				<td>${det.vehicleNo }</td>
			</tr>
		</c:forEach>
		</table>
		
		<div class="admin12">
			<c:url value="updatepayment.jsp" var="payupdate">
				<c:param name="pid" value="${pid}" />
				<c:param name="amount" value="${amount}" />
				<c:param name="datetime" value="${datetime}" />
				<c:param name="vehicleNo" value="${vehicleNo}" />
			</c:url>
			<div class="update">
				<a href="${payupdate}">
					<input type="button" name="Update" value="Update Payment Transection">
				</a>
			</div>
			<br>
			
			<c:url value="deletePayment.jsp" var="paydelete">
				<c:param name="pid" value="${pid}" />
				<c:param name="amount" value="${amount}" />
				<c:param name="datetime" value="${datetime}" />
				<c:param name="vehicleNo" value="${vehicleNo}" />
			</c:url>
			<div class="delete">
				<a href="${paydelete }">
				<input type="button" name="delete" value="Delete Payment Transection">
				</a>
			</div>
		</div>
	</body>
</html>