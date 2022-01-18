package models;

public class User {

	// Atributos
	private int iduser;
	private String username;
	private String password;

	// Constructor
	public User(int iduser, String username, String password) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
	}

	// Getters y setters
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
