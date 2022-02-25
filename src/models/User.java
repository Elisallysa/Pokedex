package models;

public class User {

	// Atributos
	// N�mero entero identificativo �nico del usuario
	private int iduser;
	// Cadena de caracteres con el nombre de usuario
	private String username;
	// Cadena de caracteres con la contrase�a del usuario
	private String password;

	// Constructor
	/**
	 * Constructor de User
	 * 
	 * @param iduser   - n�mero identificativo �nico
	 * @param username - nombre de usuario
	 * @param password - contrase�a
	 */
	public User(int iduser, String username, String password) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
	}

	// Getters & setters
	public int getId() {
		return iduser;
	}

	public void setId(int id) {
		this.iduser = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// To String
	@Override
	public String toString() {
		return "Usuario [iduser=" + iduser + ", username=" + username + ", password=" + password + "]";
	}

}
