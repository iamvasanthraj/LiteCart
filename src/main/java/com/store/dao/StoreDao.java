package com.store.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.store.entity.Product;

public class StoreDao {

	String url = "jdbc:mysql://localhost:3306/store";
	String user = "root";
	String pass = "root";

	public List<Product> fetch() throws ClassNotFoundException, SQLException {

		List<Product> list = new ArrayList<>();

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from products");
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setDescription(rs.getString("description"));
			list.add(p);
			
		}
		
		return list;
	}
}
