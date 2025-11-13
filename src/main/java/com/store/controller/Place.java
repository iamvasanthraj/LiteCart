package com.store.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Place")
public class Place extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("success.jsp"); 
    }
}

