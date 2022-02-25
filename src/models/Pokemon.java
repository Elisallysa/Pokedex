package models;

public class Pokemon {

	// Atributos
	// Número entero que identifica un Pokémon en la Pokédex
	private int id;
	// Nombre del Pokémon
	private String nombre;
	// Tipos de Pokémon (clases)
	private Tipo tipo1;
	private Tipo tipo2;
	// Tipos de Pokémon (el nombre en cadena de caracteres)
	private String tipoUno;
	private String tipoDos;
	// Altura en metros del Pokémon
	private double altura;
	// Peso en kilos del Pokémon
	private double peso;
	// Categoría del Pokémon
	private String categoria;
	// Habilidad especial del Pokémon
	private String habilidad;

	// Constructores
	/**
	 * Constructor de un Pokémon
	 * 
	 * @param id        - número entero que identifica al Pokémon en la Pokédex y BD
	 * @param nombre    - cadena de caracteres con el nombre del Pokémon
	 * @param altura    - número decimal con la altura en metros
	 * @param peso      - número decimal con el peso en kg
	 * @param categoria - cadena de caracteres con la categoría del Pokémon
	 * @param habilidad - cadena de caracteres con la habilidad del Pokémon
	 */
	public Pokemon(int id, String nombre, double altura, double peso, String categoria, String habilidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.habilidad = habilidad;
	}

	/**
	 * Constructor de Pokémon en el que se incluyen el tipo / los tipos del Pokémon
	 * 
	 * @param id        - ""
	 * @param nombre    - ""
	 * @param tipoUno   - Cadena de caracteres del tipo1 del Pokémon
	 * @param tipoDos   - Cadena de caracteres del tipo2 del Pokémon (si lo tuviera)
	 * @param altura    - ""
	 * @param peso      - ""
	 * @param categoria - ""
	 * @param habilidad - ""
	 */
	public Pokemon(int id, String nombre, String tipoUno, String tipoDos, double altura, double peso, String categoria,
			String habilidad) {
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

	// Getters & Setters
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

	// To String
	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", altura="
				+ altura + ", peso=" + peso + ", categoria=" + categoria + ", habilidad=" + habilidad + "]";
	}

}
