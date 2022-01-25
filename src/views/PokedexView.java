package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import dao.PokemonDAO;
import models.Pokemon;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PokedexView {

	private JFrame frame;
	private JLabel lblImgBackground;
	private Image background;
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfCategoria;
	private JTextField tfTipo1;
	private JTextField tfTipo2;
	private JTextField tfHeight;
	private JTextField tfWeight;
	private JTextField tfHabilidad;
	private JLabel lblMeters;
	private JLabel lblKilos;
	private JLabel lblHabilidad;
	private JPanel lblCrossHoriz;
	private JPanel lblCrossVertic;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCrear;
	private JButton btnBack;
	private JButton btnGuardar;
	private JButton btnForward;
	private PokemonDAO pokemonDAO;
	private Pokemon pokemon;
	private JLabel lblAlmohadilla;
	private ArrayList<Pokemon> pokemons;
	private int index;
	

	/**
	 * Create the application.
	 */
	public PokedexView() {
		initialize();
		//Imprimiremos el primer Pokemon con el índice inicializado a 0 (si en la BD hay mínimo 1 Pokemon almacenado):
		this.pokemonDAO = new PokemonDAO();
		this.pokemons = pokemonDAO.getAll();
		index = 0;
		/**
		 * Para probar la impresión del Pokemon, se usó este método de la clase pokemonDAO en un principio:
		 * pokemon = pokemonDAO.first(); 
		 */
		if (this.pokemons.size()>0) {
			printPokemon();
		}
		
		
		//Para que se vea la imagen de fondo tengo que dejarlo aquí, no puedo meterlo en el método configureUIComponents():
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
		tfWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		tfWeight.setOpaque(false);
		tfWeight.setEditable(false);
		tfWeight.setFont(new Font("Consolas", Font.PLAIN, 24));
		tfWeight.setColumns(10);
		tfWeight.setBorder(null);
		tfWeight.setBounds(482, 237, 67, 43);
		frame.getContentPane().add(tfWeight);

		tfHeight = new JTextField();
		tfHeight.setHorizontalAlignment(SwingConstants.RIGHT);
		tfHeight.setOpaque(false);
		tfHeight.setEditable(false);
		tfHeight.setFont(new Font("Consolas", Font.PLAIN, 24));
		tfHeight.setBorder(null);
		tfHeight.setBounds(482, 199, 67, 35);
		frame.getContentPane().add(tfHeight);
		tfHeight.setColumns(10);

		tfTipo2 = new JTextField();
		tfTipo2.setOpaque(false);
		tfTipo2.setHorizontalAlignment(SwingConstants.LEFT);
		tfTipo2.setFont(new Font("Consolas", Font.PLAIN, 18));
		tfTipo2.setEditable(false);
		tfTipo2.setColumns(10);
		tfTipo2.setBorder(null);
		tfTipo2.setBounds(533, 144, 110, 35);
		frame.getContentPane().add(tfTipo2);

		tfTipo1 = new JTextField();
		tfTipo1.setOpaque(false);
		tfTipo1.setHorizontalAlignment(SwingConstants.LEFT);
		tfTipo1.setFont(new Font("Consolas", Font.PLAIN, 18));
		tfTipo1.setEditable(false);
		tfTipo1.setColumns(10);
		tfTipo1.setBorder(null);
		tfTipo1.setBounds(412, 144, 111, 35);
		frame.getContentPane().add(tfTipo1);

		tfCategoria = new JTextField();
		tfCategoria.setBorder(null);
		tfCategoria.setOpaque(false);
		tfCategoria.setEditable(false);
		tfCategoria.setFont(new Font("Consolas", Font.PLAIN, 24));
		tfCategoria.setBounds(346, 95, 246, 29);
		frame.getContentPane().add(tfCategoria);
		tfCategoria.setColumns(10);

		tfNombre = new JTextField();
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
		
		btnBack = new JButton("<");
		btnBack.setMargin(new Insets(1, 1, 1, 1));
		btnBack.setBorderPainted(false);
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnBack.setBounds(0, 0, 39, 36);
		lblCrossHoriz.add(btnBack);
		
		btnForward = new JButton(">");
		btnForward.setOpaque(false);
		btnForward.setContentAreaFilled(false);
		btnForward.setBorderPainted(false);
		btnForward.setMargin(new Insets(1, 1, 1, 1));
		btnForward.setActionCommand(">");
		btnForward.setForeground(Color.WHITE);
		btnForward.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnForward.setBorderPainted(false);
		btnForward.setBounds(64, 0, 39, 36);
		lblCrossHoriz.add(btnForward);

		lblCrossVertic = new JPanel();
		lblCrossVertic.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCrossVertic.setBackground(new Color(0, 0, 0));
		lblCrossVertic.setBounds(558, 312, 36, 103);
		frame.getContentPane().add(lblCrossVertic);

		// Botones y otros detalles
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setMargin(new Insets(1, 1, 1, 1));
		btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnEliminar.setFont(new Font("Courier New", Font.BOLD, 18));
		btnEliminar.setBounds(71, 369, 209, 36);
		frame.getContentPane().add(btnEliminar);

		btnModificar = new JButton("MODO EDICI\u00D3N");
		btnModificar.setMargin(new Insets(1, 1, 1, 1));
		btnModificar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnModificar.setFont(new Font("Courier New", Font.BOLD, 18));
		btnModificar.setBounds(285, 323, 209, 36);
		frame.getContentPane().add(btnModificar);

		btnCrear = new JButton("CREAR");
		btnCrear.setMargin(new Insets(1, 1, 1, 1));
		btnCrear.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCrear.setFont(new Font("Courier New", Font.BOLD, 18));
		btnCrear.setBounds(71, 323, 209, 36);
		frame.getContentPane().add(btnCrear);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setVisible(false);
		btnGuardar.setMargin(new Insets(1, 1, 1, 1));
		btnGuardar.setFont(new Font("Courier New", Font.BOLD, 18));
		btnGuardar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGuardar.setBounds(285, 369, 209, 36);
		frame.getContentPane().add(btnGuardar);
		
		lblAlmohadilla = new JLabel("#");
		lblAlmohadilla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlmohadilla.setForeground(Color.WHITE);
		lblAlmohadilla.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblAlmohadilla.setBounds(576, 55, 54, 43);
		frame.getContentPane().add(lblAlmohadilla);
		

	}
	
	private void configureUIListeners() {
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				if (index == pokemons.size()) {
					index = 0;
				}
				printPokemon();
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index--;
				if (index < 0) {
					index = pokemons.size()-1;
				}
				printPokemon();
			}
		});
	
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmar = JOptionPane.showConfirmDialog(btnEliminar, "¿Estás seguro de que quieres eliminar este Pokémon?", "Confirmar eliminar", 
						JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE);
				if (confirmar == JOptionPane.YES_OPTION) {
					pokemonDAO.delete(pokemons.get(index));
					pokemons.remove(pokemons.get(index));
					if (pokemons.size()>0) {
						printBack();
					} else {
						JOptionPane.showMessageDialog(btnEliminar, "No hay Pokémon en la Pokedex.");
						printEmpty();
					}
				} else {
						JOptionPane.showMessageDialog(btnEliminar, "Ningún Pokémon eliminado.");
				}
			}
		});	
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interruptorEditar();
				btnGuardar.setVisible(true);
				
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							updatePokemon();
							pokemonDAO.update(pokemons.get(index));
							interruptorEditar();
						}catch(Exception errorUpdate) {
							System.out.println("¿Has introducido los datos correctos?");
						}
					}
				});
			}
		});
	
	}
	
	private void printPokemon() {
		pokemon = pokemons.get(index);
		if (!pokemons.isEmpty()) {
			tfId.setText(String.valueOf(pokemon.getId()));
		tfNombre.setText(pokemon.getNombre());
		tfTipo1.setText(pokemon.getTipo1());
		tfTipo2.setText(pokemon.getTipo2());
		tfCategoria.setText(pokemon.getCategoria());
		tfHabilidad.setText(pokemon.getHabilidad());
		tfHeight.setText(String.valueOf(pokemon.getAltura()));
		tfWeight.setText(String.valueOf(pokemon.getPeso()));
		} else {
			printEmpty();
		}
		
	}
	
	private void printBack() {
		pokemon = pokemons.get(index - 1);
		
		tfId.setText(String.valueOf(pokemon.getId()));
		tfNombre.setText(pokemon.getNombre());
		tfTipo1.setText(pokemon.getTipo1());
		tfTipo2.setText(pokemon.getTipo2());
		tfCategoria.setText(pokemon.getCategoria());
		tfHabilidad.setText(pokemon.getHabilidad());
		tfHeight.setText(String.valueOf(pokemon.getAltura()));
		tfWeight.setText(String.valueOf(pokemon.getPeso()));
	}
	
	private void printEmpty() {
		
		tfId.setText("");
		tfNombre.setText("");
		tfTipo1.setText("");
		tfTipo2.setText("");
		tfCategoria.setText("");
		tfHabilidad.setText("");
		tfHeight.setText("");
		tfWeight.setText("");
	}
	
	private void interruptorEditar() {
		tfNombre.setEditable(!tfNombre.isEditable());
		tfTipo1.setEditable(!tfTipo1.isEditable());
		tfTipo2.setEditable(!tfTipo2.isEditable());
		tfCategoria.setEditable(!tfCategoria.isEditable());
		tfHabilidad.setEditable(!tfHabilidad.isEditable());
		tfHeight.setEditable(!tfHeight.isEditable());
		tfWeight.setEditable(!tfWeight.isEditable());
		btnBack.setVisible(!btnBack.isVisible());
		btnForward.setVisible(!btnForward.isVisible());
		btnEliminar.setVisible(!btnEliminar.isVisible());
		btnCrear.setVisible(!btnCrear.isVisible());
	}
	
	private void updatePokemon() {
		Pokemon p = pokemons.get(index);
		p.setNombre(tfNombre.getText());
		p.setTipo1(tfTipo1.getText());
		p.setTipo2(tfTipo2.getText());
		p.setAltura(Double.parseDouble(tfHeight.getText()));
		p.setPeso(Double.parseDouble(tfWeight.getText()));
		p.setCategoria(tfCategoria.getText());
		p.setHabilidad(tfHabilidad.getText());
	}
	
	
}
