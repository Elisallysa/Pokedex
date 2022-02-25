package models;

public class Tipo {

	// Atributos
	// Número entero identificativo único del tipo de Pokémon
	private int id;
	// Cadena de caracteres con el nombre del tipo de Pokémon
	private String nombre;

	// Constructor
	/**
	 * Constructor de la clase Tipo
	 * 
	 * @param id     - número entero identificativo
	 * @param nombre - nombre del tipo
	 */
	public Tipo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreTipo() {
		return nombre;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombre = nombreTipo;
	}

	@Override
	public String toString() {
		return "Tipo [id=" + id + ", nombre=" + nombre + "]";
	}

}
