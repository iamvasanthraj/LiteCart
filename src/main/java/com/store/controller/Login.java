package com.store.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.store.dao.Logincheck;
import com.store.dao.StoreDao;
import com.store.entity.Customer;
import com.store.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Logincheck dao = new Logincheck();

		try {
			if (dao.check(username, password)) {
				HttpSession hs = request.getSession();
				hs.setAttribute("username",username);
				
				Shop sh = new Shop();
				sh.doGet(request, response);
				
				request.getRequestDispatcher("shop.jsp").forward(request, response);
			} else {
				response.sendRedirect("signup.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
