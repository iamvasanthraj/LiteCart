<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.store.entity.Cart"%>
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
<link rel="stylesheet" href="shop.css">
</head>
<body>
	<h1>Your Cart 🛒</h1>

	<%
	List<Cart> cart = (List<Cart>) session.getAttribute("cart");
	int total = 0;
	%>

	<%
	if (cart == null || cart.isEmpty()) {
	%>

	<p class="empty">Your cart is empty.</p>
	

	<%
	} else {
	%>

	<table>
		<tr>
			<th>ID</th>
			<th>Product</th>
			<th>Price (₹)</th>
		</tr>

		<%
		for (Cart c : cart) {
			total += c.getPrice();
		%>
		<tr>
			<td><%=c.getId()%></td>
			<td><%=c.getName()%></td>
			<td><%=c.getPrice()%></td>
		</tr>
		<%
		}
		%>

		<tr>
			<td colspan="2"><b>Total</b></td>
			<td><b>₹ <%=total%></b></td>
		</tr>
	</table>

	
<div style="display: flex; justify-content: center; gap: 20px; margin-top: 20px;">

    <form action="Place">
        <input type="submit" value="Place Order"
            style="padding: 10px 20px; font-size: 16px; border: none; background: green; color: white; border-radius: 5px; cursor: pointer;">
    </form>

    <form action="Clear">
        <input type="submit" value="Clear Cart"
            style="padding: 10px 20px; font-size: 16px; border: none; background: red; color: white; border-radius: 5px; cursor: pointer;">
    </form>

</div>


	<%
	}
	%>
	<div style="text-align: center; margin-top: 20px;">
    <button onclick="location.href='shop'" 
            style="padding:10px 20px; cursor:pointer; background:#444; color:white; border:none; border-radius:5px;">
        Back
    </button>
</div>


</body>
</html>