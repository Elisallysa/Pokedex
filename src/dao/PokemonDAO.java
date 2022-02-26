package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Pokemon;

public class PokemonDAO extends AbstractDAO {

	/**
	 * M�TODO QUE NO SE UTILIZA EN LA APLICACI�N. Se mantiene por inter�s acad�mico.
	 * M�todo que selecciona el primer Pok�mon que aparece en la BD. Obtendremos
	 * todos los campos del registro y los almacenaremos en una nueva instancia de
	 * la clase Pokemon.
	 * 
	 * @return - el objeto Pokemon que corresponde al primer Pok�mon de la lista
	 *         pokemon en la BD
	 */
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

	/**
	 * M�todo que almacena en un array todos los objetos Pokemon almacenados en la
	 * BD.
	 * 
	 * @return - ArrayList de los Pok�mon que contiene la BD.
	 */
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

	/**
	 * M�todo que inserta un nuevo registro Pok�mon con todos sus campos
	 * correspondientes en la BD.
	 * 
	 * @param pokemon - nuevo objeto Pok�mon con todos sus campos.
	 */
	public void insert(Pokemon pokemon) {
		final String INSERT = "INSERT INTO pokemon VALUES (" + pokemon.getId() + ", '" + pokemon.getNombre() + "', '"
				+ pokemon.getTipoUno() + "', '" + pokemon.getTipoDos() + "', " + pokemon.getAltura() + ", "
				+ pokemon.getPeso() + ", '" + pokemon.getCategoria() + "', '" + pokemon.getHabilidad() + "')";
		try {
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Elimina un Pok�mon que se encuentre en la BD
	 * 
	 * @param pokemon - Objeto Pok�mon que se desea eliminar.
	 */
	public void delete(Pokemon pokemon) {
		final String DELETE = "DELETE FROM pokemon WHERE id = " + pokemon.getId();
		try {
			stmt.executeUpdate(DELETE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * M�todo que actualiza los datos de un Pok�mon existente en la BD.
	 * 
	 * @param pokemon - Objeto Pok�mon que se desea actualizar.
	 */
	public void update(Pokemon pokemon) {
		final String UPDATE = "UPDATE pokemon SET nombre = '" + pokemon.getNombre() + "', tipo1 = '"
				+ pokemon.getTipoUno() + "', tipo2 = '" + pokemon.getTipoDos() + "', altura = " + pokemon.getAltura()
				+ ", peso = " + pokemon.getPeso() + ", categoria = '" + pokemon.getCategoria() + "', habilidad = '"
				+ pokemon.getHabilidad() + "'" + "WHERE id = " + pokemon.getId();
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
