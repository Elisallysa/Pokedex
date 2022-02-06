package models;

public class Tipo {

	// Atributos
	private int id;
	private String nombreTipo;

	
	

	public Tipo(int id, String nombreTipo) {
		super();
		this.id = id;
		this.nombreTipo = nombreTipo;
	}


	// Getters & Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	@Override
	public String toString() {
		return "Tipo [id=" + id + ", nombreTipo=" + nombreTipo + "]";
	}
	
	
}
