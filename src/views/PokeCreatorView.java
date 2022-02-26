package views;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import dao.PokemonDAO;
import dao.TipoDAO;
import models.Pokemon;
import models.Tipo;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PokeCreatorView {

	// Marco
	private JFrame frame;
	// Etiquetas de texto e imágenes
	private JLabel lblImgBackground;
	private JLabel lblMeters;
	private JLabel lblKilos;
	private JLabel lblHabilidad;
	private JLabel lblAlmohadilla;
	// Imagen de fondo
	private Image background;
	// Campos de texto y menús de selección desplegables
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfCategoria;
	private JTextField tfHeight;
	private JTextField tfWeight;
	private JTextField tfHabilidad;
	private JComboBox<String> cbTipo1;
	private JComboBox<String> cbTipo2;
	// Botones
	private JButton btnGuardar;
	private JButton btnCancelar;
	// Importaciones de otras clases necesarias
	private PokemonDAO pokemonDAO;
	private Pokemon pokemon;
	private TipoDAO tipoDAO;
	// ArrayList de Pokémon y Tipo + índice para la Pokédex
	private ArrayList<Pokemon> pokemons;
	private ArrayList<Tipo> tipos;
	private int index;

	/**
	 * Creación de la aplicación. Reservamos memoria a un nuevo PokemonDAO y TipoDAO
	 * y rellenamos los ArrayLists con Pokémon y los tipos de Pokémon
	 */
	public PokeCreatorView() {
		/*
		 * Imprimiremos el primer Pokemon con el índice inicializado a 0 (si en la BD
		 * hay mínimo 1 Pokemon almacenado)
		 */
		this.pokemonDAO = new PokemonDAO();
		this.tipoDAO = new TipoDAO();
		this.pokemons = pokemonDAO.getAll();
		this.tipos = tipoDAO.getAll();
		initialize();
		index = 0;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		this.configureUIComponents();
		this.configureUIListeners();
		frame.setVisible(true);
	}

	private void configureUIComponents() {
		// Marco e imagen de fondo
		frame.getContentPane().setBackground(new Color(204, 0, 0));
		frame.getContentPane().setLayout(null);
		background = new ImageIcon(this.getClass().getResource("/pokedex_entry.jpg")).getImage();
		frame.setBounds(100, 100, 713, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Info Pokemon (etiquetas de texto, campos de texto y menús desplegables)
		tfId = new JTextField();
		tfId.setOpaque(false);
		tfId.setHorizontalAlignment(SwingConstants.LEFT);
		tfId.setForeground(Color.WHITE);
		tfId.setFont(new Font("Consolas", Font.PLAIN, 26));
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBorder(null);
		tfId.setBounds(635, 55, 54, 43);
		frame.getContentPane().add(tfId);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setForeground(new Color(255, 255, 255));
		lblHabilidad.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidad.setFont(new Font("Consolas", Font.BOLD, 10));
		lblHabilidad.setBounds(300, 134, 84, 20);
		frame.getContentPane().add(lblHabilidad);

		tfHabilidad = new JTextField();
		tfHabilidad.setText("Habilidad");
		tfHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		tfHabilidad.setBorder(null);
		tfHabilidad.setOpaque(false);
		tfHabilidad.setBounds(300, 154, 84, 62);
		frame.getContentPane().add(tfHabilidad);
		tfHabilidad.setColumns(10);

		lblKilos = new JLabel("kg");
		lblKilos.setFont(new Font("Consolas", Font.PLAIN, 24));
		lblKilos.setBounds(558, 244, 54, 29);
		frame.getContentPane().add(lblKilos);

		lblMeters = new JLabel("m");
		lblMeters.setFont(new Font("Consolas", Font.PLAIN, 24));
		lblMeters.setBounds(558, 202, 54, 29);
		frame.getContentPane().add(lblMeters);

		tfWeight = new JTextField();
		tfWeight.setText("0.0");
		tfWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		tfWeight.setOpaque(false);
		tfWeight.setFont(new Font("Consolas", Font.PLAIN, 24));
		tfWeight.setColumns(10);
		tfWeight.setBorder(null);
		tfWeight.setBounds(482, 237, 67, 43);
		frame.getContentPane().add(tfWeight);

		tfHeight = new JTextField();
		tfHeight.setText("0.0");
		tfHeight.setHorizontalAlignment(SwingConstants.RIGHT);
		tfHeight.setOpaque(false);
		tfHeight.setFont(new Font("Consolas", Font.PLAIN, 24));
		tfHeight.setBorder(null);
		tfHeight.setBounds(482, 199, 67, 35);
		frame.getContentPane().add(tfHeight);
		tfHeight.setColumns(10);

		tfCategoria = new JTextField();
		tfCategoria.setText("categor\u00EDa");
		tfCategoria.setBorder(null);
		tfCategoria.setOpaque(false);
		tfCategoria.setFont(new Font("Consolas", Font.PLAIN, 24));
		tfCategoria.setBounds(346, 95, 246, 29);
		frame.getContentPane().add(tfCategoria);
		tfCategoria.setColumns(10);

		tfNombre = new JTextField();
		tfNombre.setText("nombre");
		tfNombre.setForeground(new Color(255, 255, 255));
		tfNombre.setBorder(null);
		tfNombre.setHorizontalAlignment(SwingConstants.LEFT);
		tfNombre.setFont(new Font("Consolas", Font.BOLD, 24));
		tfNombre.setOpaque(false);
		tfNombre.setBounds(346, 55, 220, 35);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		cbTipo2 = new JComboBox<String>();
		cbTipo2.setBounds(525, 143, 113, 35);
		frame.getContentPane().add(cbTipo2);

		cbTipo1 = new JComboBox<String>();
		cbTipo1.setBounds(402, 143, 113, 35);
		frame.getContentPane().add(cbTipo1);
		fillTipos();

		// Botones y otros detalles
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Courier New", Font.BOLD, 18));
		btnCancelar.setBounds(403, 347, 209, 35);
		frame.getContentPane().add(btnCancelar);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setVisible(true);
		btnGuardar.setMargin(new Insets(1, 1, 1, 1));
		btnGuardar.setFont(new Font("Courier New", Font.BOLD, 18));
		btnGuardar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGuardar.setBounds(93, 345, 209, 36);
		frame.getContentPane().add(btnGuardar);

		lblAlmohadilla = new JLabel("#");
		lblAlmohadilla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlmohadilla.setForeground(Color.WHITE);
		lblAlmohadilla.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblAlmohadilla.setBounds(576, 55, 54, 43);
		frame.getContentPane().add(lblAlmohadilla);

		lblImgBackground = new JLabel("fondo");
		lblImgBackground.setBackground(Color.RED);
		lblImgBackground.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblImgBackground.setBounds(0, -23, 766, 445);
		frame.getContentPane().add(lblImgBackground);
		lblImgBackground.setIcon(new ImageIcon(background));
		lblImgBackground.setSize(750, 500);

	}

	private void configureUIListeners() {
		/*
		 * El botón Guardar guarda el nuevo Pokémon en la BD
		 */
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createPokemon();
				JOptionPane.showMessageDialog(btnGuardar, "Nuevo Pokémon creado.");
				frame.dispose();
				new PokedexView();
			}
		});

		/*
		 * El botón Cancelar elimina la vista y crea una nueva de la Pokédex.
		 */
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new PokedexView();
			}
		});

	}

	/*
	 * Método que asigna un índice único al nuevo Pokémon, crea una nueva instancia
	 * de la clase Pokemon, la introduce en la lista de Pokémon de la vista y por
	 * último introduce los datos del Pokémon en la BD. Se llama al método al pulsar
	 * el botón Guardar
	 */
	private void createPokemon() {
		// El id del nuevo Pokémon es el del último Pokémon + 1
		int lastIndexArray = pokemons.size() - 1;
		int newPokemonId = (pokemons.get(lastIndexArray).getId() + 1);
		pokemon = new Pokemon(newPokemonId, null, null, null, index, index, null, null);
		setInfoPokemon(pokemon);
		pokemons.add(pokemon);
		pokemonDAO.insert(pokemons.get(pokemons.lastIndexOf(pokemon)));
	}

	/**
	 * Método que recoge la info de los campos de texto y de los menús desplegables
	 * y los asigna a una instancia de la clase Pokémon. Se llama al método en el
	 * método createPokemon().
	 * 
	 * @param pokemon - Instancia de la clase Pokémon que almacenará los datos
	 *                introducidos en los campos de texto y ComboBoxes
	 */
	private void setInfoPokemon(Pokemon pokemon) {
		if (tfNombre.getText().isEmpty() || tfHeight.getText().isEmpty() || tfWeight.getText().isEmpty()
				|| tfCategoria.getText().isEmpty() || tfHabilidad.getText().isEmpty()) {
			JOptionPane.showMessageDialog(btnGuardar, "Revisa los campos.");
		} else {
			try {
				pokemon.setNombre(tfNombre.getText());
				pokemon.setAltura(Double.parseDouble(tfHeight.getText()));
				pokemon.setPeso(Double.parseDouble(tfWeight.getText()));
				pokemon.setCategoria(tfCategoria.getText());
				pokemon.setHabilidad(tfHabilidad.getText());
				// Obtenemos el tipo de Pokemon del ComboBox1 y del 2(si se ha seleccionado
				// alguna opción que no sea 0)
				pokemon.setTipoUno(tipos.get(cbTipo1.getSelectedIndex()).getNombreTipo());
				if (cbTipo2.getSelectedIndex() != 0) {
					pokemon.setTipoDos(tipos.get(cbTipo2.getSelectedIndex() - 1).getNombreTipo());
				} else {
					pokemon.setTipoDos(null);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(btnGuardar, "Algún campo no es correcto");
			}
		}

	}

	/*
	 * Método que introduce la lista de Tipos en los ComboBoxes o menús
	 * desplegables.
	 */
	private void fillTipos() {
		ArrayList<Tipo> tipos = tipoDAO.getAll();
		cbTipo2.addItem("");
		for (Tipo t : tipos) {
			cbTipo1.addItem(t.getNombreTipo());
			cbTipo2.addItem(t.getNombreTipo());
		}

	}
}
