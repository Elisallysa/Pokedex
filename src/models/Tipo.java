package models;

public class Tipo {

	// Atributos
	// N�mero entero identificativo �nico del tipo de Pok�mon
	private int id;
	// Cadena de caracteres con el nombre del tipo de Pok�mon
	private String nombre;

	// Constructor
	/**
	 * Constructor de la clase Tipo
	 * 
	 * @param id     - n�mero entero identificativo
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
