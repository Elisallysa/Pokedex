package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Pokemon;

public class PokemonDAO {

	final String DB_URL = "jdbc:mysql://localhost/pokedex";
	final String USER = "Rawdevil";
	final String PASS = "Put0user22";
	

	public void consulta(Pokemon pokemon) {
		final String QUERY = "SELECT * FROM pokemon";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				// Display values
				System.out.print("Nombre: " + rs.getString("nombre"));
				System.out.println(", Tipo 1: " + rs.getString("tipo1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
