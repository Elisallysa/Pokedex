package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;
import views.PokedexView;

public class PokemonDAO extends AbstractDAO {

	private PokedexView pokedex;
	
	public Pokemon first() {
		final String QUERY = "SELECT * FROM pokemon LIMIT 1";
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String tipo1 = rs.getString("tipo1");
				String tipo2 = rs.getString("tipo2");
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				String categoria = rs.getString("categoria");
				String habilidad = rs.getString("habilidad");
				Pokemon p = new Pokemon(id, nombre, tipo1, tipo2, altura, peso, categoria, habilidad);
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public ArrayList<Pokemon> getAll() {
		final String QUERY = "SELECT * FROM pokemon";
		var pokemons = new ArrayList<Pokemon>();
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var id = rs.getInt("id");
				var nombre = rs.getString("nombre");
				var tipo1 = rs.getString("tipo1");
				var tipo2 = rs.getString("tipo2");
				var altura = rs.getDouble("altura");
				var peso = rs.getDouble("peso");
				var categoria = rs.getString("categoria");
				var habilidad = rs.getString("habilidad");
				Pokemon p = new Pokemon(id, nombre, tipo1, tipo2, altura, peso, categoria, habilidad);
				pokemons.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemons;
	}
}
