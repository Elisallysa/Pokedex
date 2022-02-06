package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	// Estos atributos no va a ser necesario verlos en las clases hijas:
	private final String DB_URL = "jdbc:mysql://localhost/pokedex";
	private final String USER = "Rawdevil";
	private final String PASS = "Put0user22";
	// En cambio estos sí, que se inicializan en el constructor de abajo:
	protected Connection conn;
	protected Statement stmt;
	
	public AbstractDAO() {
		try {
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
			this.stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
