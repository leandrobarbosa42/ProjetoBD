package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model.dao.UsuarioDAO;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO dao = new UsuarioDAO();
			if(dao.CheckLogin(textLogin.getText(), passwordPass)) {
				viewTelaInicial.main(null);
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao logar!");
			}
				
			}
		});
		btnLogin.setForeground(SystemColor.desktop);
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnLogin.setBounds(321, 91, 90, 73);
		frame.getContentPane().add(btnLogin);
	}
}
