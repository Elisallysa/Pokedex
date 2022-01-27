package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Tipo;

public class TipoDAO extends AbstractDAO {

	public ArrayList<Tipo> getAll() {
		final String QUERY = "SELECT * "
				+ "FROM tipos";
		var tipos = new ArrayList<Tipo>();
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var id = rs.getInt("idtipos");
				var nombre = rs.getString("nombretipo");
				Tipo t = new Tipo(id, nombre);
				tipos.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipos;
	}
	
	/**
	 * Busca el Profesor por su ID y si no lo encuentra devuelve NULL.
	 * @param idProfe
	 * @return
	 */
	public Tipo get(int idTipo) {
		final String QUERY = "SELECT * "
				+ "FROM tipos where idtipos = " + idTipo;
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var id = rs.getInt("idtipos");
				var nombre = rs.getString("nombretipo");
				Tipo t = new Tipo(id, nombre);
				return t;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
