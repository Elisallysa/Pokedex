package views;

import java.awt.EventQueue;

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

public class LoginView {

	private JFrame frame;
	private JTextField txtfUser;
	private JPasswordField pwfPassword;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblUsuario_1;
	private JButton btnLogin;
	private JButton btnSignIn;

	
	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		this.configureUIComponents();
		this.configureUIListeners();
		
	}
	
	public void configureUIComponents() {
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(0, 0, 102));
		frame.setBounds(100, 100, 436, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblLogin = new JLabel("Pokedex");
		lblLogin.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 26));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(36, 27, 338, 46);
		frame.getContentPane().add(lblLogin);
		
		txtfUser = new JTextField();
		txtfUser.setBounds(176, 94, 210, 36);
		frame.getContentPane().add(txtfUser);
		txtfUser.setColumns(10);
		
		pwfPassword = new JPasswordField();
		pwfPassword.setBounds(176, 140, 210, 36);
		frame.getContentPane().add(pwfPassword);
		
		lblUsuario = new JLabel("Contrase\u00F1a");
		lblUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 22));
		lblUsuario.setBounds(48, 140, 115, 36);
		frame.getContentPane().add(lblUsuario);
		
		lblUsuario_1 = new JLabel("Usuario");
		lblUsuario_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 22));
		lblUsuario_1.setBounds(48, 94, 115, 36);
		frame.getContentPane().add(lblUsuario_1);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		btnLogin.setBounds(74, 205, 123, 36);
		frame.getContentPane().add(btnLogin);
		
		btnSignIn = new JButton("Sign in");
		btnSignIn.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		btnSignIn.setBounds(225, 205, 123, 36);
		frame.getContentPane().add(btnSignIn);
	}
	
	public void configureUIListeners() {
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("¡Login correcto!");
			}
		});
		
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
