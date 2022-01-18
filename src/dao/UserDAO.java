package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.User;

public class UserDAO {

	final String DB_URL = "jdbc:mysql://localhost/pokedex";
	final String USER = "Rawdevil";
	final String PASS = "Put0user22";
	

	public void consulta() {
		final String QUERY = "SELECT username, password FROM users";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				// Display values
				System.out.print("Username: " + rs.getString("username"));
				System.out.println(", Password: " + rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public boolean login(User usuario) {
		final String QUERY = "SELECT username, password FROM users "+
							 "where username = '"+ usuario.getUsername() +"' and "+
							 "password = '"+ usuario.getPassword() +"'";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void register(User usuario) {
		final String INSERT = "INSERT INTO users (username,password) VALUES ('"+usuario.getUsername()+"','"+usuario.getPassword()+"');";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
