package views;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import dao.UserDAO;
import models.User;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView {

	// Marco
	private JFrame frame;
	// Campos de input de texto
	private JTextField txtfUser;
	private JPasswordField pwfPassword;
	// Etiquetas
	private JLabel lblTitle;
	private JLabel lblPassword;
	private JLabel lblUsuario;
	private JLabel lblNewLabel;
	private JLabel lblBattery;
	private JLabel lblTM;
	private JLabel lblNintendo;
	private JLabel lblGameBoy;
	private JLabel lblNewLabel_3;
	// Paneles decorativos
	private JPanel pnlGreenScreen;
	private JPanel pnlGreyScreen;
	// Botones
	private JButton btnLogin;
	private JButton btnSignIn;
	// Usuario DAO
	private UserDAO userDAO;

	/**
	 * Creaci?n de la aplicaci?n. Se inicializa, se hace visible el marco y se
	 * reserva memoria para el usuario DAO.
	 */
	public LoginView() {
		initialize();
		frame.setVisible(true);
		this.userDAO = new UserDAO();

	}

	/**
	 * Se inicializan los contenidos del marco.
	 */
	private void initialize() {
		frame = new JFrame();
		this.configureUIComponents();
		this.configureUIListeners();

	}

	/**
	 * M?todo que configura los componentes de la interfaz gr?fica.
	 */
	public void configureUIComponents() {
		frame.getContentPane().setForeground(SystemColor.controlShadow);
		frame.setAlwaysOnTop(true);
		frame.setForeground(UIManager.getColor("Button.disabledForeground"));
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBackground(new Color(0, 0, 102));
		frame.setBounds(100, 100, 602, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setBounds(144, 198, 117, 36);
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 18));
		frame.getContentPane().add(lblPassword);

		lblTitle = new JLabel("Pokedex");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(121, 85, 360, 46);
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setFont(new Font("Consolas", Font.BOLD, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTitle);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.DARK_GRAY);
		lblUsuario.setBounds(144, 152, 92, 36);
		lblUsuario.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsuario.setFont(new Font("Consolas", Font.PLAIN, 18));
		frame.getContentPane().add(lblUsuario);

		pnlGreenScreen = new JPanel();
		pnlGreenScreen.setBackground(new Color(153, 204, 102));
		pnlGreenScreen.setBounds(109, 67, 381, 263);
		frame.getContentPane().add(pnlGreenScreen);
		pnlGreenScreen.setLayout(null);

		btnSignIn = new JButton("Registrarme");
		btnSignIn.setBounds(196, 195, 149, 36);
		pnlGreenScreen.add(btnSignIn);
		btnSignIn.setForeground(Color.DARK_GRAY);
		btnSignIn.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSignIn.setFont(new Font("Consolas", Font.PLAIN, 18));

		btnLogin = new JButton("Login");
		btnLogin.setBounds(39, 195, 147, 36);
		pnlGreenScreen.add(btnLogin);
		btnLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Consolas", Font.PLAIN, 18));

		txtfUser = new JTextField();
		txtfUser.setBounds(142, 88, 210, 36);
		pnlGreenScreen.add(txtfUser);
		txtfUser.setColumns(10);

		pwfPassword = new JPasswordField();
		pwfPassword.setBounds(142, 134, 210, 36);
		pnlGreenScreen.add(pwfPassword);

		pnlGreyScreen = new JPanel();
		pnlGreyScreen.setBackground(new Color(119, 136, 153));
		pnlGreyScreen.setBounds(27, 47, 534, 306);
		frame.getContentPane().add(pnlGreyScreen);
		pnlGreyScreen.setLayout(null);

		lblNewLabel = new JLabel("DOT MATRIX WITH STEREO SOUND");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Corbel", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(217, 0, 248, 23);
		pnlGreyScreen.add(lblNewLabel);

		lblBattery = new JLabel("BATTERY");
		lblBattery.setForeground(Color.WHITE);
		lblBattery.setBounds(-46, 135, 115, 23);
		pnlGreyScreen.add(lblBattery);
		lblBattery.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBattery.setFont(new Font("Corbel", Font.PLAIN, 12));

		lblNewLabel_3 = new JLabel("\u00B7");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Impact", Font.BOLD, 45));
		lblNewLabel_3.setBounds(24, 112, 23, 23);
		pnlGreyScreen.add(lblNewLabel_3);

		lblNintendo = new JLabel("Nintendo");
		lblNintendo.setForeground(new Color(0, 0, 102));
		lblNintendo.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblNintendo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNintendo.setBounds(27, 363, 169, 34);
		frame.getContentPane().add(lblNintendo);

		lblGameBoy = new JLabel("GAME BOY");
		lblGameBoy.setForeground(new Color(0, 0, 102));
		lblGameBoy.setFont(new Font("Consolas", Font.ITALIC, 24));
		lblGameBoy.setBounds(135, 367, 126, 33);
		frame.getContentPane().add(lblGameBoy);

		lblTM = new JLabel("TM");
		lblTM.setForeground(new Color(0, 0, 102));
		lblTM.setBounds(241, 377, 52, 13);
		frame.getContentPane().add(lblTM);
	}

	// M?todo que configura los Listeners de los botones de la interfaz gr?fica.
	public void configureUIListeners() {

		/**
		 * El bot?n Login (Iniciar sesi?n) permite acceder a la Pok?dex tras ingresar el
		 * nombre de usuario y contrase?a correctos.
		 */
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		/**
		 * El campo de texto de contrase?a permite acceder a la Pok?dex tras pulsar la
		 * tecla ENTER (si el nombre de usuario + contrase?a son correctos).
		 */
		pwfPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});

		/**
		 * El campo de texto del nombre de usuario permite acceder a la Pok?dex tras
		 * pulsar la tecla ENTER (si el nombre de usuario + contrase?a son correctos).
		 */
		txtfUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});

		/**
		 * El bot?n SignIn (Registrarse) permite al usuario crear un nombre de usuario y
		 * contrase?a para acceder a la Pok?dex.
		 */
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterView();
				frame.dispose();
			}
		});
	}

	/**
	 * M?todo que obtiene el texto del campo de texto del nombre de usuario y la
	 * contrase?a y comprueba que se encuentra en la BD o no.
	 */
	public void login() {
		String username = txtfUser.getText();
		String password = new String(pwfPassword.getPassword());
		User usuario = new User(0, username, password);
		boolean loggedIn = userDAO.login(usuario); // Llamamos al m?todo login de la clase userDAO para comprobar que el
													// usuario se encuentra o no en la BD

		/*
		 * Si en UsuarioDAO obtenemos un registro con los datos del usuario, loggedIn es
		 * true y por tanto, desaparece la ventana de registro y se crea una nueva de la
		 * Pok?dex. Si no, lanza un mensaje que informa que el nombre de usuario o
		 * contrase?a son inv?lidos.
		 */

		if (loggedIn) {
			JOptionPane.showMessageDialog(btnLogin, "?Login correcto!");
			frame.dispose();
			new PokedexView();
		} else {
			JOptionPane.showMessageDialog(btnLogin, "Nombre de usuario o contrase?a inv?lidos.");
		}
	}
}
