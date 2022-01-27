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

	public Pokemon(int id2, String nombre2, String tipoUno, String tipoDos, double altura2, double peso2,
			String categoria2, String habilidad2) {
		super();
		this.id = id2;
		this.nombre = nombre2;
		this.setTipoUno(tipoUno);
		this.setTipoDos(tipoDos);
		this.altura = altura2;
		this.peso = peso2;
		this.categoria = categoria2;
		this.habilidad = habilidad2;
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
	
	
	public void setTipo1(Tipo tipo1) {
		this.tipo1 = tipo1;
	}

	public void setTipo2(Tipo tipo2) {
		this.tipo2 = tipo2;
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
