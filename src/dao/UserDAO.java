package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.User;

public class UserDAO extends AbstractDAO {

	/**
	 * Método que consulta y muestra el nombre de usuario y contraseña.
	 */
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

	/**
	 * Método que comprueba que hay un registro en la BD donde a un nombre de
	 * usuario le corresponde una contraseña determinada
	 * 
	 * @param usuario - Objeto usuario con un nombre y contraseña
	 * @return - true: si el usuario se encuentra en la BD; false: si no se
	 *         encuentra en la BD
	 */
	public boolean login(User usuario) {
		final String QUERY = "SELECT username, password FROM users " + "where username = '" + usuario.getUsername()
				+ "' and " + "password = '" + usuario.getPassword() + "'";
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Método con el que se introduce un nuevo registro en la BD de users con un
	 * nombre de usuario y una contraseña
	 * 
	 * @param usuario - Objeto user que se quiere introducir en la BD.
	 */
	public void register(User usuario) {
		final String INSERT = "INSERT INTO users (username,password) VALUES ('" + usuario.getUsername() + "','"
				+ usuario.getPassword() + "');";
		try {
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
