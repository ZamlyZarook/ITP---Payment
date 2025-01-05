<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "ISO-8859-1">    
		
		<title>Payment Staff Interface</title>
		<link rel="stylesheet" href="Assets/CSS/payment.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="Assets/JS/payment.js"></script>
	</head>
	<body>
		<div class="pay1">
			<form action="sub" method="post">
				<h2>Vehicle plate number</h2> <input type="text" placeholder="Eg : PD - 2134" name="pid">     
				<input type="submit" name="submit" value="Enter">
			</form>
		</div>
		
		<br><br>
		
		<table class="styled-table">
		<c:forEach var="det" items="${userdetails}">
			<tbody>
				<tr class="active-row">
					<td> Name of the Owner</td>
					<td>${det.fistName }</td>
				</tr>
				<tr class="active-row">
					<td>Available Fuel</td>
					<td>${det.remaingFuel } L</td>
				</tr>
				<tr class="active-row">
					<td>NIC</td>
					<td>${det.nic }</td>
				</tr>
				<tr class="active-row">
					<td>Email ID</td>
					<td>${det.email }</td>
				</tr>
				<tr class="active-row">
					<td> Maximum Fuel Limit</td>
					<td>${det.fuelLimit } L</td>
				</tr>
				<tr class="active-row">
					<td>Selling Price</td>
					<td>${det.sellingPrice }</td>
				</tr>
        <!-- and so on... -->
			</tbody>
		</c:forEach>
		</table>
		
		
	 	
	 	<div class="pay2">
			<form action="print" method="post">
				<c:forEach var="d" items="${userdetails}">
				
				<label for="quantity" class="lable1"> Fuel Amount : </label>
				<input type="number" name="quantity" name="quantity" min="1" max= "${d.remaingFuel}" id="username3" >
				<label for="quantity" class="lable1"> Liters </label><br>
				<input type="submit" name="submit" value="Enter">
				</c:forEach>
				
			</form>
			<table>
				<tr>
					<td> <h2>Payment Amount </h2> </td>
					<td> <h2> ${calcamuont } </h2></td>
				</tr>
			</table>
		</div>
				
	 	<div class="pay3">
			<form  action="Reciptpage.jsp"  method ="post">
				<input type="Submit" name="submit" value="Create Recipt"/>
			</form>
		</div>
	</body>
</html>