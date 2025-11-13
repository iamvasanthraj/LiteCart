package com.store.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Clear")
public class Clear extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession hs = request.getSession();
		hs.removeAttribute("cart");
		
		response.sendRedirect("shop");
	}
}
