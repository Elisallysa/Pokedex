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
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import dao.UserDAO;

import java.awt.Panel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Label;

public class LoginView {

	private JFrame frame;
	private JTextField txtfUser;
	private JPasswordField pwfPassword;
	private JLabel lblTitle;
	private JLabel lblPassword;
	private JLabel lblUsuario;
	private JButton btnLogin;
	private JButton btnSignIn;
	private JLabel lblNintendo;
	private JLabel lblGameBoy;
	private JLabel lblNewLabel_3;
	private JPanel pnlGreenScreen;
	private JPanel pnlGreyScreen;
	private JLabel lblNewLabel;
	private JLabel lblBattery;
	private JLabel lblTM;
	private	UserDAO userDAO;

	
	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		frame.setVisible(true);
		this.userDAO = new UserDAO();
		
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
		lblPassword.setBounds(121, 198, 140, 36);
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 22));
		frame.getContentPane().add(lblPassword);
		
		lblTitle = new JLabel("Pokedex");
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setBounds(121, 85, 360, 46);
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setFont(new Font("Consolas", Font.BOLD, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTitle);
		
		txtfUser = new JTextField();
		txtfUser.setBounds(271, 153, 210, 36);
		frame.getContentPane().add(txtfUser);
		txtfUser.setColumns(10);
		
		pwfPassword = new JPasswordField();
		pwfPassword.setBounds(271, 199, 210, 36);
		frame.getContentPane().add(pwfPassword);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.DARK_GRAY);
		lblUsuario.setBounds(121, 152, 115, 36);
		lblUsuario.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsuario.setFont(new Font("Consolas", Font.PLAIN, 22));
		frame.getContentPane().add(lblUsuario);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(159, 263, 123, 36);
		btnLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Consolas", Font.PLAIN, 20));
		frame.getContentPane().add(btnLogin);
		
		btnSignIn = new JButton("Sign in");
		btnSignIn.setForeground(Color.DARK_GRAY);
		btnSignIn.setBounds(310, 263, 123, 36);
		btnSignIn.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSignIn.setFont(new Font("Consolas", Font.PLAIN, 20));
		frame.getContentPane().add(btnSignIn);
		
		pnlGreenScreen = new JPanel();
		pnlGreenScreen.setBackground(new Color(153, 204, 102));
		pnlGreenScreen.setBounds(109, 67, 381, 263);
		frame.getContentPane().add(pnlGreenScreen);
		
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
	
	public void configureUIListeners() {
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtfUser.getText();
				String password = new String (pwfPassword.getPassword());
				
				boolean loggedIn = userDAO.login(username, password);
				
				if (loggedIn) {
					JOptionPane.showMessageDialog(btnLogin, "¡Login correcto!");
				} else {
					JOptionPane.showMessageDialog(btnLogin, "Nombre de usuario o contraseña inválidos.");
				}
			}
		});
		
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
