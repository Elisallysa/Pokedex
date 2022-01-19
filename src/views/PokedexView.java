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
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class PokedexView {

	private JFrame frame;
	JLabel lblImgBackground;
	Image background;
	private JTextField tfNombre;
	private JTextField txtCategoria;
	private JTextField txtTipo1;
	private JTextField txtTipo2;
	private JTextField textHeight;
	private JTextField textWeight;
	private JLabel lblMeters;
	private JLabel lblKilos;
	private JTextField txtMar;
	private JLabel lblHabilidad;
	private JPanel lblCrossHoriz;
	private JPanel lblCrossVertic;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnNewButton;

	/**
	 * Create the application.
	 */
	public PokedexView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		this.configureUIComponents();
		frame.setVisible(true);
	}

	private void configureUIComponents() {

		frame.getContentPane().setBackground(new Color(204, 0, 0));
		frame.getContentPane().setLayout(null);

		lblImgBackground = new JLabel("Pikachu");
		lblImgBackground.setFont(new Font("Consolas", Font.PLAIN, 16));
		background = new ImageIcon(this.getClass().getResource("/pokedex_entry.jpg")).getImage();

		lblCrossHoriz = new JPanel();
		lblCrossHoriz.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCrossHoriz.setBackground(new Color(0, 0, 0));
		lblCrossHoriz.setBounds(524, 345, 103, 36);
		frame.getContentPane().add(lblCrossHoriz);

		lblCrossVertic = new JPanel();
		lblCrossVertic.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCrossVertic.setBackground(new Color(0, 0, 0));
		lblCrossVertic.setBounds(558, 312, 36, 103);
		frame.getContentPane().add(lblCrossVertic);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnEliminar.setFont(new Font("Courier New", Font.BOLD, 20));
		btnEliminar.setBounds(353, 331, 137, 62);
		frame.getContentPane().add(btnEliminar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnModificar.setFont(new Font("Courier New", Font.BOLD, 18));
		btnModificar.setBounds(213, 331, 137, 62);
		frame.getContentPane().add(btnModificar);

		btnNewButton = new JButton("CREAR");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setFont(new Font("Courier New", Font.BOLD, 22));
		btnNewButton.setBounds(73, 331, 137, 62);
		frame.getContentPane().add(btnNewButton);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setForeground(new Color(255, 255, 255));
		lblHabilidad.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidad.setFont(new Font("Consolas", Font.BOLD, 10));
		lblHabilidad.setBounds(300, 134, 84, 20);
		frame.getContentPane().add(lblHabilidad);

		txtMar = new JTextField();
		txtMar.setHorizontalAlignment(SwingConstants.CENTER);
		txtMar.setBorder(null);
		txtMar.setOpaque(false);
		txtMar.setText("Mar LLamas");
		txtMar.setBounds(300, 154, 84, 62);
		frame.getContentPane().add(txtMar);
		txtMar.setColumns(10);

		lblKilos = new JLabel("kg");
		lblKilos.setFont(new Font("Consolas", Font.PLAIN, 24));
		lblKilos.setBounds(538, 244, 54, 29);
		frame.getContentPane().add(lblKilos);

		lblMeters = new JLabel("m");
		lblMeters.setFont(new Font("Consolas", Font.PLAIN, 24));
		lblMeters.setBounds(538, 202, 54, 29);
		frame.getContentPane().add(lblMeters);

		textWeight = new JTextField();
		textWeight.setText("28");
		textWeight.setOpaque(false);
		textWeight.setFont(new Font("Consolas", Font.PLAIN, 24));
		textWeight.setColumns(10);
		textWeight.setBorder(null);
		textWeight.setBounds(482, 237, 67, 43);
		frame.getContentPane().add(textWeight);

		textHeight = new JTextField();
		textHeight.setOpaque(false);
		textHeight.setFont(new Font("Consolas", Font.PLAIN, 24));
		textHeight.setBorder(null);
		textHeight.setText("1.1 ");
		textHeight.setBounds(482, 199, 67, 35);
		frame.getContentPane().add(textHeight);
		textHeight.setColumns(10);

		txtTipo2 = new JTextField();
		txtTipo2.setText("El\u00E9ctrico");
		txtTipo2.setOpaque(false);
		txtTipo2.setHorizontalAlignment(SwingConstants.LEFT);
		txtTipo2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txtTipo2.setEditable(false);
		txtTipo2.setColumns(10);
		txtTipo2.setBorder(null);
		txtTipo2.setBounds(533, 144, 110, 35);
		frame.getContentPane().add(txtTipo2);

		txtTipo1 = new JTextField();
		txtTipo1.setText("Planta");
		txtTipo1.setOpaque(false);
		txtTipo1.setHorizontalAlignment(SwingConstants.LEFT);
		txtTipo1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txtTipo1.setEditable(false);
		txtTipo1.setColumns(10);
		txtTipo1.setBorder(null);
		txtTipo1.setBounds(412, 144, 111, 35);
		frame.getContentPane().add(txtTipo1);

		txtCategoria = new JTextField();
		txtCategoria.setBorder(null);
		txtCategoria.setOpaque(false);
		txtCategoria.setFont(new Font("Consolas", Font.PLAIN, 24));
		txtCategoria.setText("Pok\u00E9mon Semilla");
		txtCategoria.setBounds(346, 89, 246, 35);
		frame.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);

		tfNombre = new JTextField();
		tfNombre.setForeground(new Color(255, 255, 255));
		tfNombre.setBorder(null);
		tfNombre.setHorizontalAlignment(SwingConstants.LEFT);
		tfNombre.setText("Pikachu");
		tfNombre.setFont(new Font("Consolas", Font.BOLD, 24));
		tfNombre.setEditable(false);
		tfNombre.setOpaque(false);
		tfNombre.setBounds(346, 55, 220, 35);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		lblImgBackground.setIcon(new ImageIcon(background));
		lblImgBackground.setSize(750, 500);

		lblImgBackground.setBounds(0, 0, 699, 450);
		frame.getContentPane().add(lblImgBackground);
		frame.setBounds(100, 100, 713, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
