package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.User;

public class UserDAO extends AbstractDAO {

	public void consulta() {
		final String QUERY = "SELECT username, password FROM users";
		try {
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
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
