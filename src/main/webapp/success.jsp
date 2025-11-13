<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

if (session.getAttribute("username") == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>
<link rel="stylesheet" href="sucess.css">
</head>
<body>

	<div class="container">
		<h1>Order Placed Successfully 🎉</h1>
		<p>Thank you for your purchase!</p>

		<form action="Logout" style="text-align: center; margin-top: 20px;">
			<input type="submit" value="Logout"
				style="padding: 10px 20px; font-size: 16px; border: none; background: #ff5252; color: white; border-radius: 5px; cursor: pointer;">
		</form>
		<br> <br> <a href="cart.jsp" class="btn"
			style="background: #28a745;">View Cart</a>
	</div>

</body>
</html>
