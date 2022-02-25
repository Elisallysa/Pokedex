package models;

public class Pokemon {

	//Atributos
	private int id;
	private String nombre;
	private Tipo tipo1;
	private Tipo tipo2;
	private String tipoUno;
	private String tipoDos;
	private double altura;
	private double peso;
	private String categoria;
	private String habilidad;
	
	//Constructores
	public Pokemon(int id, String nombre, double altura, double peso, String categoria,
			String habilidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.habilidad = habilidad;
	}

	public Pokemon(int id, String nombre, String tipoUno, String tipoDos, double altura, double peso,
			String categoria, String habilidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoUno = tipoUno;
		this.tipoDos = tipoDos;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.habilidad = habilidad;
	}

	// Getters and Setters
	public String getTipoUno() {
		return tipoUno;
	}

	public void setTipoUno(String tipoUno) {
		this.tipoUno = tipoUno;
	}

	public String getTipoDos() {
		return tipoDos;
	}

	public void setTipoDos(String tipoDos) {
		this.tipoDos = tipoDos;
	}

	//Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	//To String
	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", altura="
				+ altura + ", peso=" + peso + ", categoria=" + categoria + ", habilidad=" + habilidad + "]";
	}


}
