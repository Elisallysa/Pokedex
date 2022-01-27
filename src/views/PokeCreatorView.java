package views;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JPanel;
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

	private JFrame frame;
	private JLabel lblImgBackground;
	private Image background;
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfCategoria;
	private JTextField tfHeight;
	private JTextField tfWeight;
	private JTextField tfHabilidad;
	private JLabel lblMeters;
	private JLabel lblKilos;
	private JLabel lblHabilidad;
	private JPanel lblCrossHoriz;
	private JPanel lblCrossVertic;
	private JButton btnGuardar;
	private PokemonDAO pokemonDAO;
	private JLabel lblAlmohadilla;
	private ArrayList<Pokemon> pokemons;
	private ArrayList<Tipo> tipos;
	private TipoDAO tipoDAO;
	private int index;
	private JComboBox<String> cbTipo1;
	private JComboBox<String> cbTipo2;

	/**
	 * Create the application.
	 */
	public PokeCreatorView() {
		initialize();
		// Imprimiremos el primer Pokemon con el índice inicializado a 0 (si en la BD
		// hay mínimo 1 Pokemon almacenado):
		this.pokemonDAO = new PokemonDAO();
		this.pokemons = pokemonDAO.getAll();
		this.tipoDAO = new TipoDAO();
		this.tipos = tipoDAO.getAll();
		index = 0;
		
		// Para que se vea la imagen de fondo tengo que dejarlo aquí, no puedo meterlo
		// en el método configureUIComponents():
		lblImgBackground = new JLabel("fondo");
		lblImgBackground.setBackground(Color.RED);
		lblImgBackground.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblImgBackground.setBounds(0, -23, 766, 445);
		frame.getContentPane().add(lblImgBackground);
		lblImgBackground.setIcon(new ImageIcon(background));
		lblImgBackground.setSize(750, 500);

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
		
		cbTipo2 = new JComboBox<String>();
		cbTipo2.setBounds(525, 143, 113, 35);
		frame.getContentPane().add(cbTipo2);
		
		cbTipo1 = new JComboBox<String>();
		cbTipo1.setBounds(402, 143, 113, 35);
		frame.getContentPane().add(cbTipo1);
		fillTipos();
		
		// Info Pokemon
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
		tfHabilidad.setEditable(false);
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
		tfWeight.setEditable(false);
		tfWeight.setFont(new Font("Consolas", Font.PLAIN, 24));
		tfWeight.setColumns(10);
		tfWeight.setBorder(null);
		tfWeight.setBounds(482, 237, 67, 43);
		frame.getContentPane().add(tfWeight);

		tfHeight = new JTextField();
		tfHeight.setText("0.0");
		tfHeight.setHorizontalAlignment(SwingConstants.RIGHT);
		tfHeight.setOpaque(false);
		tfHeight.setEditable(false);
		tfHeight.setFont(new Font("Consolas", Font.PLAIN, 24));
		tfHeight.setBorder(null);
		tfHeight.setBounds(482, 199, 67, 35);
		frame.getContentPane().add(tfHeight);
		tfHeight.setColumns(10);

		tfCategoria = new JTextField();
		tfCategoria.setText("categor\u00EDa");
		tfCategoria.setBorder(null);
		tfCategoria.setOpaque(false);
		tfCategoria.setEditable(false);
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
		tfNombre.setEditable(false);
		tfNombre.setOpaque(false);
		tfNombre.setBounds(346, 55, 220, 35);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);


		// Cruz y cursores
		lblCrossHoriz = new JPanel();
		lblCrossHoriz.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCrossHoriz.setBackground(new Color(0, 0, 0));
		lblCrossHoriz.setBounds(524, 345, 103, 36);
		frame.getContentPane().add(lblCrossHoriz);
		lblCrossHoriz.setLayout(null);

		lblCrossVertic = new JPanel();
		lblCrossVertic.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCrossVertic.setBackground(new Color(0, 0, 0));
		lblCrossVertic.setBounds(558, 312, 36, 103);
		frame.getContentPane().add(lblCrossVertic);

		// Botones y otros detalles
		btnGuardar = new JButton("GUARDAR");
		
		btnGuardar.setVisible(false);
		btnGuardar.setMargin(new Insets(1, 1, 1, 1));
		btnGuardar.setFont(new Font("Courier New", Font.BOLD, 18));
		btnGuardar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGuardar.setBounds(71, 345, 209, 36);
		frame.getContentPane().add(btnGuardar);

		lblAlmohadilla = new JLabel("#");
		lblAlmohadilla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlmohadilla.setForeground(Color.WHITE);
		lblAlmohadilla.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblAlmohadilla.setBounds(576, 55, 54, 43);
		frame.getContentPane().add(lblAlmohadilla);

	}

	private void configureUIListeners() {
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			createPokemon();
			JOptionPane.showMessageDialog(btnGuardar, "Nuevo Pokémon creado.");
			new PokedexView();
			}
		});

	}

	private void createPokemon() {
		int lastIndexArray = pokemons.size()-1;
		int lastPokemonIndex = (pokemons.get(lastIndexArray).getId()+1);
		Pokemon pokemon = new Pokemon(lastPokemonIndex, null, null, null, index, index, null, null);
		setInfoPokemon(pokemon);
		pokemons.add(pokemon);
		pokemonDAO.insert(pokemons.get(pokemons.lastIndexOf(pokemon)));
	}

	private void setInfoPokemon(Pokemon pokemon) {
		pokemon.setNombre(tfNombre.getText());
		pokemon.setTipo1(tipos.get(cbTipo1.getSelectedIndex()).getNombreTipo());
		
		pokemon.setTipo2(tipos.get(cbTipo2.getSelectedIndex()).getNombreTipo());
		pokemon.setAltura(Double.parseDouble(tfHeight.getText()));
		pokemon.setPeso(Double.parseDouble(tfWeight.getText()));
		pokemon.setCategoria(tfCategoria.getText());
		pokemon.setHabilidad(tfHabilidad.getText());
	}
	private void fillTipos() {
		cbTipo2.addItem("Ninguno");
		for (Tipo t : tipos) {
			cbTipo1.addItem(t.getNombreTipo());
			cbTipo2.addItem(t.getNombreTipo());
		}
		
	}
}
