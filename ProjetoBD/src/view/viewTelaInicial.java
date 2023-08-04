package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewTelaInicial {

	private JFrame frame;

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
					viewTelaInicial window = new viewTelaInicial();
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
	public viewTelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 575, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BEM VINDO/A!!!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(110, 11, 311, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnConsultaPdt = new JButton("CONSULTA");
		btnConsultaPdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsulta.main(null);
				frame.dispose();
			}
		});
		btnConsultaPdt.setFont(new Font("Reem Kufi", Font.BOLD, 12));
		btnConsultaPdt.setBounds(200, 176, 148, 73);
		frame.getContentPane().add(btnConsultaPdt);
		
		JLabel lblNewLabel_1 = new JLabel("MERCADINHO ADA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(164, 76, 208, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(98, 11, 363, 104);
		frame.getContentPane().add(panel);
		
		JButton btnLogin = new JButton("Atualizar / Excluir");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAlterarPD.main(null);
				frame.dispose();
			}
		});
		btnLogin.setBounds(328, 367, 133, 28);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//viewCadastro.main(null);
				frame.dispose();
			}
		});
		btnCadastro.setBounds(99, 367, 133, 28);
		frame.getContentPane().add(btnCadastro);
		
		JLabel lblNewLabel_2 = new JLabel("Casdastrar novos produtos, ou alterar os atuais:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(100, 303, 388, 52);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
