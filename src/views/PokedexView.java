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

public class PokedexView {

	// Atributos
	// Marco, imagen de fondo y decoraciones
	private JFrame frame;
	private Image background;
	private JPanel lblCrossHoriz;
	private JPanel lblCrossVertic;
	// Etiquetas y campos de texto y men?s desplegables (ComboBox)
	private JLabel lblImgBackground;
	private JLabel lblImagen;
	private JLabel lblMeters;
	private JLabel lblKilos;
	private JLabel lblHabilidad;
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfCategoria;
	private JTextField tfTipo1;
	private JTextField tfTipo2;
	private JTextField tfHeight;
	private JTextField tfWeight;
	private JTextField tfHabilidad;
	private JComboBox<String> cbTipo2;
	private JComboBox<String> cbTipo1;
	// Botones
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCrear;
	private JButton btnBack;
	private JButton btnGuardar;
	private JButton btnForward;
	// Importaciones necesarias, listas e ?ndice para navegar en la Pok?dex
	private PokemonDAO pokemonDAO;
	private TipoDAO tipoDAO;
	private Pokemon pokemon;
	private JLabel lblAlmohadilla;
	private ArrayList<Pokemon> pokemons;
	private ArrayList<Tipo> tipos;
	private int index;

	/**
	 * Creaci?n de la aplicaci?n. Se reserva memoria al TipoDAO y PokemonDAO y se
	 * llama al m?todo getAll() para obtener todos los registros de los tipos y
	 * Pok?mon de la BD.
	 */
	public PokedexView() {
		this.tipoDAO = new TipoDAO();
		this.tipos = tipoDAO.getAll();
		initialize();
		// Imprimiremos el primer Pokemon con el ?ndice inicializado a 0 (si en la BD
		// hay m?nimo 1 Pokemon almacenado):
		this.pokemonDAO = new PokemonDAO();
		this.pokemons = pokemonDAO.getAll();

		/*
		 * Para probar la impresi?n del Pokemon, se us? en clase el m?todo pokemonDAO
		 * --> pokemon = pokemonDAO.first(). Ahora imprimimos el primer Pok?mon porque
		 * tenemos un ?ndice inicializado en 0, que se usar? en al m?todo printPokemon()
		 */
		index = 0;
		if (this.pokemons.size() > 0) {
			printPokemon();
		}
	}

	/**
	 * Se inicializan los contenidos de la vista.
	 */
	private void initialize() {
		frame = new JFrame();
		this.configureUIComponents();
		this.configureUIListeners();
		frame.setVisible(true);
	}

	/*
	 * M?todo que configura los componentes de la interfaz gr?fica de la vista.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void configureUIComponents() {
		// Marco, imagen de fondo e im?genes de Pokemon
		frame.getContentPane().setBackground(new Color(204, 0, 0));
		frame.getContentPane().setLayout(null);
		background = new ImageIcon(this.getClass().getResource("/pokedex_entry.jpg")).getImage();
		frame.setBounds(100, 100, 713, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(0, 38, 297, 264);
		frame.getContentPane().add(lblImagen);

		// Info Pokemon (men?s deplegables y campos y etiquetas de texto)
		cbTipo2 = new JComboBox();
		cbTipo2.setBounds(533, 146, 103, 29);
		frame.getContentPane().add(cbTipo2);
		cbTipo2.setVisible(false);

		cbTipo1 = new JComboBox();
		cbTipo1.setBounds(409, 146, 103, 29);
		frame.getContentPane().add(cbTipo1);
		cbTipo1.setVisible(false);
		fillTipos();

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

		btnBack = new JButton("<");
		btnBack.setMargin(new Insets(1, 1, 1, 1));
		btnBack.setBorderPainted(false);
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnBack.setBounds(0, 0, 39, 36);

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

		lblCrossVertic = new JPanel();
		lblCrossVertic.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCrossVertic.setBackground(new Color(0, 0, 0));
		lblCrossVertic.setBounds(558, 312, 36, 103);
		frame.getContentPane().add(lblCrossVertic);

		lblAlmohadilla = new JLabel("#");
		lblAlmohadilla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlmohadilla.setForeground(Color.WHITE);
		lblAlmohadilla.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblAlmohadilla.setBounds(576, 55, 54, 43);
		frame.getContentPane().add(lblAlmohadilla);

		lblCrossHoriz = new JPanel();
		lblCrossHoriz.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCrossHoriz.setBackground(new Color(0, 0, 0));
		lblCrossHoriz.setBounds(524, 345, 103, 36);
		frame.getContentPane().add(lblCrossHoriz);
		lblCrossHoriz.setLayout(null);
		lblCrossHoriz.add(btnForward);
		lblCrossHoriz.add(btnBack);

		lblImgBackground = new JLabel("fondo");
		lblImgBackground.setBackground(Color.RED);
		lblImgBackground.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblImgBackground.setBounds(0, -23, 766, 445);
		frame.getContentPane().add(lblImgBackground);
		lblImgBackground.setIcon(new ImageIcon(background));
		lblImgBackground.setSize(750, 500);

	}

	/*
	 * M?todo que configura los Listeners de los botones de la interfaz gr?fica de
	 * la vista
	 */
	private void configureUIListeners() {
		/*
		 * El bot?n Forward navega en la Pok?dex hacia adelante e imprime el Pok?mon
		 * correspondiente. Cuando llega al final de la lista de Pok?mon, vuelve al
		 * ?ndice 0 para tener una navegaci?n circular.
		 */
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				if (index == pokemons.size()) {
					index = 0;
				}
				printPokemon();
			}
		});

		/*
		 * El bot?n Back navega en la Pok?dex hacia atr?s e imprime el Pok?mon
		 * correspondiente. Cuando llega al ?ndice 0, el siguiente ser? el ?ltimo ?ndice
		 * de la lista de Pok?mon para tener una navegaci?n circular.
		 */
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index--;
				if (index < 0) {
					index = pokemons.size() - 1;
				}
				printPokemon();
			}
		});

		/*
		 * El bot?n Eliminar elimina el Pok?mon de la BD previo mensaje de confirmaci?n.
		 */
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmar = JOptionPane.showConfirmDialog(btnEliminar,
						"?Est?s seguro de que quieres eliminar este Pok?mon?", "Confirmar eliminar",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (confirmar == JOptionPane.YES_OPTION) {
					pokemonDAO.delete(pokemons.get(index));
					pokemons.remove(pokemons.get(index));

					if (pokemons.size() > 0 && index != 0) {
						// printBack(); // En lugar de usar un m?todo para imprimir el anterior, restamos 1 al ?ndice e imprimimos el Pok?mon.	
						index = index-1;
						printPokemon();
					} else if (pokemons.size() > 0 && index == 0) {
						index = pokemons.size()-1;
					} else {
						JOptionPane.showMessageDialog(btnEliminar, "No hay Pok?mon en la Pokedex.");
						printEmpty(); // Si no quedan Pok?mon en la BD imprime un mensaje que lo comunica y se dejan
										// los campos en blanco.
					}
				} else {
					JOptionPane.showMessageDialog(btnEliminar, "Ning?n Pok?mon eliminado.");
				}
			}
		});

		/*
		 * El bot?n Modificar activa el "Modo Edici?n" con el que los campos de texto se
		 * vuelven editables y permiten modificar la informaci?n del Pok?mon que se est?
		 * imprimiendo
		 */
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interruptorEditar();
				cbTipo1.setSelectedItem(pokemons.get(index).getTipoUno()); // Por defecto aparecen las opciones ya seleccionadas
				if (pokemons.get(index).getTipoDos() != null) {
					cbTipo2.setSelectedItem(pokemons.get(index).getTipoDos());
				}
				btnGuardar.setVisible(true); // El bot?n Guardar se hace visible para guardar los cambios.
			}
		});

		/*
		 * El bot?n Guardar guarda los datos cambiados en la base de datos.
		 */
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updatePokemon();
					pokemonDAO.update(pokemons.get(index));
					interruptorEditar();
					printPokemon();
				} catch (Exception errorUpdate) {
					System.out.println("?Has introducido los datos correctos?");
				}
			}
		});
		
		/*
		 * El bot?n Crear elimina la vista de la Pok?dex y abre una nueva vista de
		 * PokeCreatorView().
		 */
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new PokeCreatorView();
			}
		});

	}

	/*
	 * M?todo que imprime el Pok?mon de la lista de Pokemon que obtenemos de la BD
	 * que corresponde al ?ndice de la navegaci?n.
	 */
	private void printPokemon() {
		pokemon = pokemons.get(index);
		if (!pokemons.isEmpty()) {
			// Imprime la informaci?n del Pok?mon en cada TextField si la lista de Pok?mon
			// no est? vac?a
			tfId.setText(String.valueOf(pokemon.getId()));
			tfNombre.setText(pokemon.getNombre());
			tfTipo1.setText(pokemon.getTipoUno());
			tfTipo2.setText(pokemon.getTipoDos());
			tfCategoria.setText(pokemon.getCategoria());
			tfHabilidad.setText(pokemon.getHabilidad());
			tfHeight.setText(String.valueOf(pokemon.getAltura()));
			tfWeight.setText(String.valueOf(pokemon.getPeso()));
			// Se obtiene la imagen del Pok?mon de la biblioteca de im?genes (de los 9
			// primeros Pok?mon)
			if (pokemon.getId() < 10)
				lblImagen.setIcon(new ImageIcon(this.getClass().getResource("/" + pokemon.getId() + ".png")));
			else
				lblImagen.setIcon(null);
		} else {
			printEmpty();
		}

	}

	/*
	 * M?todo que imprime el Pok?mon que se encuentra en la posici?n anterior al del
	 * ?ndice actual.
	 * Conservamos el m?todo por inter?s acad?mico.
	 * 
	  	private void printBack() {
		pokemon = pokemons.get(index - 1);
		// Obtenemos la info del Pok?mon para imprimirla en los campos de texto
		tfId.setText(String.valueOf(pokemon.getId()));
		tfNombre.setText(pokemon.getNombre());
		tfTipo1.setText(pokemon.getTipoUno());
		tfTipo2.setText(pokemon.getTipoDos());
		tfCategoria.setText(pokemon.getCategoria());
		tfHabilidad.setText(pokemon.getHabilidad());
		tfHeight.setText(String.valueOf(pokemon.getAltura()));
		tfWeight.setText(String.valueOf(pokemon.getPeso()));
	} 
	 */
	

	/*
	 * Imprime los campos de texto vac?os.
	 */
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

	/*
	 * El interruptor Editar configura los campos de texto como editables/no
	 * editables y hace visibles / no visibles los men?s desplegables, los botones
	 * de navegaci?n y y los botenes de Eliminar y Crear Pok?mon.
	 */
	private void interruptorEditar() {
		tfNombre.setEditable(!tfNombre.isEditable());
		tfTipo1.setEditable(!tfTipo1.isEditable());
		tfTipo2.setEditable(!tfTipo2.isEditable());
		tfCategoria.setEditable(!tfCategoria.isEditable());
		tfHabilidad.setEditable(!tfHabilidad.isEditable());
		tfHeight.setEditable(!tfHeight.isEditable());
		tfWeight.setEditable(!tfWeight.isEditable());
		cbTipo1.setVisible(!cbTipo1.isVisible());
		cbTipo2.setVisible(!cbTipo2.isVisible());
		btnBack.setVisible(!btnBack.isVisible());
		btnForward.setVisible(!btnForward.isVisible());
		btnEliminar.setVisible(!btnEliminar.isVisible());
		btnCrear.setVisible(!btnCrear.isVisible());
	}

	/*
	 * M?todo que actualiza los datos del Pok?mon que se est? visualizando en la
	 * lista de Pok?mon. Se selecciona el Pok?mon por el ?ndice y se vuelven a
	 * obtener los datos de los campos de texto y men?s desplegables.
	 */
	private void updatePokemon() {
		pokemon = pokemons.get(index);
		setInfoPokemon(pokemon);
	}

	/**
	 * M?todo que guarda la informaci?n introducida en los campos de texto en el
	 * Pok?mon introducido por par?metro.
	 * 
	 * @param pokemon - Pokemon al que se desea establecer la informaci?n
	 */
	private void setInfoPokemon(Pokemon pokemon) {
		// Obtenemos el contenido de los TextField para establecerlo en el Pok?mon
		pokemon.setNombre(tfNombre.getText());
		pokemon.setAltura(Double.parseDouble(tfHeight.getText()));
		pokemon.setPeso(Double.parseDouble(tfWeight.getText()));
		pokemon.setCategoria(tfCategoria.getText());
		pokemon.setHabilidad(tfHabilidad.getText());

		// Se obtiene el tipo de Pokemon del ComboBox1 y del 2(si se ha seleccionado
		// alguna opci?n que no sea 0)
		String tipoUno = tipos.get(cbTipo1.getSelectedIndex()).getNombreTipo();
		pokemon.setTipoUno(tipoUno);
		if (cbTipo2.getSelectedIndex() != 0) {
			String tipoDos = tipos.get(cbTipo2.getSelectedIndex()-1).getNombreTipo();
			pokemon.setTipoDos(tipoDos);
		} else if (cbTipo2.getSelectedIndex() == 0) {
			pokemon.setTipoDos(null);
		}

	}

	/*
	 * M?todo que rellena los men?s desplegables con los tipos de Pok?mon
	 * almacenados en la BD.
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
