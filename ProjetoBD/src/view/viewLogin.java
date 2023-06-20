package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class viewLogin {

	private JFrame frame;
	private JTextField textLogin;
	private JPasswordField passwordPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException |IllegalAccessException |javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);;
        } 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLogin window = new viewLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFocusTraversalKeysEnabled(false);
		frame.getContentPane().setFocusable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entre com sua conta!");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(107, 40, 194, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setBounds(35, 97, 55, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setBounds(35, 138, 55, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		textLogin = new JTextField();
		textLogin.setBounds(117, 91, 184, 28);
		frame.getContentPane().add(textLogin);
		textLogin.setColumns(10);
		
		passwordPass = new JPasswordField();
		passwordPass.setBounds(117, 132, 184, 28);
		frame.getContentPane().add(passwordPass);
		
		JButton btnLogin = new JButton("ENTRAR");
		btnLogin.setForeground(Color.GREEN);
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnLogin.setBounds(321, 91, 90, 73);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCadastro = new JButton("Cadastre-se");
		btnCadastro.setForeground(Color.BLUE);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewCadastro.main(null);
				frame.dispose();
			}
		});
		btnCadastro.setBorderPainted(false);
		btnCadastro.setBackground(SystemColor.activeCaptionBorder);
		btnCadastro.setBounds(16, 209, 171, 28);
		frame.getContentPane().add(btnCadastro);
		
		JButton btnRecuperarSenha = new JButton("Recuperar Senha");
		btnRecuperarSenha.setForeground(Color.RED);
		btnRecuperarSenha.setBorderPainted(false);
		btnRecuperarSenha.setBackground(SystemColor.activeCaptionBorder);
		btnRecuperarSenha.setBounds(240, 209, 171, 28);
		frame.getContentPane().add(btnRecuperarSenha);
	}
}
