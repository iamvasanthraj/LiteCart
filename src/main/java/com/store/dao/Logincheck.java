package com.store.dao;

import java.sql.*;

public class Logincheck {

	String url = "jdbc:mysql://localhost:3306/store";
	String user = "root";
	String pass = "root";

	public boolean check(String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = con.prepareStatement("select * from users where username=? and password=?");
		st.setString(1, username);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			return true;
		}
		return false;
	}

	public void update(String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = con.prepareStatement("insert into users (username,password) values(?,?)");
		st.setString(1, username);
		st.setString(2, password);
		int rows = st.executeUpdate();

		if (rows > 0) {
			System.out.println("User inserted successfully!");
		}
	}
}
