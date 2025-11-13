<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.store.entity.Product"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

if (session.getAttribute("username") == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<%
List<Product> products = (List<Product>) request.getAttribute("products");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Store</title>
<link rel="stylesheet" href="shop.css">
</head>
<body>
	<h1>Quick Store</h1>

	<div class="welcome">
		Welcome, <b> ${username} </b>!

	</div>


	<%
	if (products != null && !products.isEmpty()) {
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>Product</th>
			<th>Price (₹)</th>
			<th>Description</th>
			<th></th>
		</tr>
		<%
		for (Product p : products) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getDescription()%></td>
			<td>
				<form action="cart" method="post">
					<input type="hidden" name="id" value="<%=p.getId()%>"> <input
						type="hidden" name="name" value="<%=p.getName()%>"> <input
						type="hidden" name="price" value="<%=p.getPrice()%>">
					<button type="submit">Add </button>
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>



	<%
	} else {
	%>
	<p style="text-align: center;">No products found.</p>
	<%
	}
	%>


	<div
		style="display: flex; justify-content: center; align-items: center; gap: 20px; margin-top: 20px;">

		<form action="Logout">
			<input type="submit" value="Logout"
				style="padding: 10px 20px; font-size: 16px; border: none; background: #ff5252; color: white; border-radius: 5px; cursor: pointer;">
		</form>

		<a href="cart.jsp" style="text-decoration: none;">
			<button
				style="padding: 10px 20px; cursor: pointer; background: #008cff; color: white; border: none; border-radius: 5px;">
				Cart 🛒</button>
		</a>

	</div>






</body>
</html>
