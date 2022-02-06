package models;

public class Tipo {

	// Atributos
	private int id;
	private String nombre;

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
