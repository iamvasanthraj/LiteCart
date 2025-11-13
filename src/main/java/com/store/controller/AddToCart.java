package com.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.store.entity.Cart;
import com.store.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class AddToCart extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		
		List<Cart> cart = (List<Cart>)hs.getAttribute("cart");
		
		if(cart == null) {
			cart = new ArrayList();
			hs.setAttribute("cart", cart);
		}
		
		Cart c = new Cart();
		c.setId(Integer.parseInt(request.getParameter("id"))); 
		c.setName(request.getParameter("name"));
		c.setPrice(Integer.parseInt(request.getParameter("price")));
		cart.add(c);
		
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	
		
	}

}
