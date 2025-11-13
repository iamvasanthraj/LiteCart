package com.store.controller;

import java.io.IOException;

import com.store.dao.Logincheck;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Signup")
public class Signup extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Logincheck dao = new Logincheck();
		try {
			if (dao.check(username, password)) {
				response.getWriter().println("UserName Already exist");
			} else {
				dao.update(username, password);
				HttpSession hs = request.getSession();
				hs.setAttribute("username",username);
				Shop sh = new Shop();
				sh.doGet(request, response);
				response.sendRedirect("shop.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
