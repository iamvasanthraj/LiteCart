package com.store.controller;

import java.io.IOException;
import java.util.List;
import com.store.dao.StoreDao;
import com.store.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/shop")
public class Shop extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StoreDao dao = new StoreDao();

			List<Product> product = dao.fetch();
			request.setAttribute("products", product);
			request.getRequestDispatcher("shop.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}