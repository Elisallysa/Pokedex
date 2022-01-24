package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import dao.UserDAO;
import models.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterView {

	private JFrame frame;
	private JTextField txtfUsername;
	private JPasswordField pwfPassword;
	private JLabel lblTitle;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JButton btnRegisterUser;
	private JLabel lblNintendo;
	private JLabel lblGameBoy;
	private JLabel lblNewLabel_3;
	private JPanel pnlGreenScreen;
	private JPanel pnlGreyScreen;
	private JLabel lblNewLabel;
	private JLabel lblBattery;
	private JLabel lblTM;
	private UserDAO userDAO;
	private JPasswordField pwfConfirmPassword;
	private JLabel lblConfirmPassword;

	/**
	 * Create the application.
	 */
	public RegisterView() {
		initialize();
		this.userDAO = new UserDAO();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
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

		pnlGreenScreen = new JPanel();
		pnlGreenScreen.setBackground(new Color(153, 204, 102));
		pnlGreenScreen.setBounds(109, 67, 381, 263);
		frame.getContentPane().add(pnlGreenScreen);
		pnlGreenScreen.setLayout(null);

		lblUsername = new JLabel("Nombre de usuario");
		lblUsername.setBounds(10, 63, 177, 29);
		pnlGreenScreen.add(lblUsername);
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsername.setFont(new Font("Consolas", Font.PLAIN, 16));

		txtfUsername = new JTextField();
		txtfUsername.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtfUsername.setBounds(204, 63, 167, 36);
		pnlGreenScreen.add(txtfUsername);
		txtfUsername.setColumns(10);

		pwfPassword = new JPasswordField();
		pwfPassword.setFont(new Font("Consolas", Font.PLAIN, 16));
		pwfPassword.setBounds(204, 109, 167, 36);
		pnlGreenScreen.add(pwfPassword);

		pwfConfirmPassword = new JPasswordField();
		pwfConfirmPassword.setFont(new Font("Consolas", Font.PLAIN, 16));
		pwfConfirmPassword.setBounds(204, 155, 167, 36);
		pnlGreenScreen.add(pwfConfirmPassword);

		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(10, 109, 177, 29);
		pnlGreenScreen.add(lblPassword);
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 16));

		lblConfirmPassword = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblConfirmPassword.setForeground(Color.DARK_GRAY);
		lblConfirmPassword.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(10, 155, 230, 29);
		pnlGreenScreen.add(lblConfirmPassword);

		btnRegisterUser = new JButton("Registrarme");
		btnRegisterUser.setBounds(107, 217, 167, 36);
		pnlGreenScreen.add(btnRegisterUser);
		btnRegisterUser.setForeground(Color.DARK_GRAY);
		btnRegisterUser.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRegisterUser.setFont(new Font("Consolas", Font.PLAIN, 18));

		lblTitle = new JLabel("Reg\u00EDstrate");
		lblTitle.setBounds(10, 17, 360, 36);
		pnlGreenScreen.add(lblTitle);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setFont(new Font("Consolas", Font.BOLD, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

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
		btnRegisterUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtfUsername.getText();
				String password = new String(pwfPassword.getPassword());
				String confirmedPassword = new String(pwfConfirmPassword.getPassword());

				if (!username.isEmpty() && !password.isEmpty() && !confirmedPassword.isEmpty()) {
					if (password.equals(confirmedPassword)) {
						User u = new User(0, username, password);
						userDAO.register(u);
						JOptionPane.showMessageDialog(btnRegisterUser, "¡Gracias por unirte!");
						new LoginView();
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(btnRegisterUser, "Las contraseñas no coinciden.");
					}
				} else {
					JOptionPane.showMessageDialog(btnRegisterUser, "Completa todos los campos.");
				}
			}

		});
	}
}