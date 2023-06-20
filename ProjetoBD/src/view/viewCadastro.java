package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewCadastro {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textNascimento;
	private JTextField textUsuario;
	private JTextField textEmail;
	private JPasswordField passwordSenha;
	private JTextField textTelefone1;
	private JTextField textTelefone2;
	private JTextField textRua;
	private JTextField textCpf;
	private JTextField textNumero;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;

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
					viewCadastro window = new viewCadastro();
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
	public viewCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 434, 44);
		frame.getContentPane().add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setBounds(99, 58, 297, 25);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNome.setBounds(21, 58, 82, 20);
		frame.getContentPane().add(lblNome);
		
		textNascimento = new JTextField();
		textNascimento.setColumns(10);
		textNascimento.setBounds(99, 94, 297, 25);
		frame.getContentPane().add(textNascimento);
		
		JLabel lblDataAniversário = new JLabel("Nascimento:");
		lblDataAniversário.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDataAniversário.setBounds(21, 97, 82, 20);
		frame.getContentPane().add(lblDataAniversário);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUsurio.setBounds(21, 352, 82, 20);
		frame.getContentPane().add(lblUsurio);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(99, 352, 297, 25);
		frame.getContentPane().add(textUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSenha.setBounds(21, 383, 82, 20);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmail.setBounds(21, 321, 82, 20);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(99, 321, 297, 25);
		frame.getContentPane().add(textEmail);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(99, 383, 297, 25);
		frame.getContentPane().add(passwordSenha);
		
		JButton btnNewButton = new JButton("CADASTRAR!");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBounds(117, 420, 197, 76);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTelefone.setBounds(21, 160, 82, 20);
		frame.getContentPane().add(lblTelefone);
		
		textTelefone1 = new JTextField();
		textTelefone1.setColumns(10);
		textTelefone1.setBounds(99, 160, 297, 25);
		frame.getContentPane().add(textTelefone1);
		
		JLabel lblTelefone_2 = new JLabel("Telefone 2:");
		lblTelefone_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTelefone_2.setBounds(21, 192, 82, 20);
		frame.getContentPane().add(lblTelefone_2);
		
		textTelefone2 = new JTextField();
		textTelefone2.setColumns(10);
		textTelefone2.setBounds(99, 192, 297, 25);
		frame.getContentPane().add(textTelefone2);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRua.setBounds(21, 229, 82, 20);
		frame.getContentPane().add(lblRua);
		
		textRua = new JTextField();
		textRua.setColumns(10);
		textRua.setBounds(99, 229, 297, 25);
		frame.getContentPane().add(textRua);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCpf.setBounds(21, 131, 82, 20);
		frame.getContentPane().add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(99, 128, 297, 25);
		frame.getContentPane().add(textCpf);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNumero.setBounds(21, 261, 82, 20);
		frame.getContentPane().add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(99, 261, 74, 25);
		frame.getContentPane().add(textNumero);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBairro.setBounds(185, 261, 56, 20);
		frame.getContentPane().add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(226, 261, 170, 25);
		frame.getContentPane().add(textBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCidade.setBounds(21, 293, 56, 20);
		frame.getContentPane().add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(99, 293, 170, 25);
		frame.getContentPane().add(textCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEstado.setBounds(271, 293, 56, 20);
		frame.getContentPane().add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setColumns(10);
		textEstado.setBounds(314, 293, 82, 25);
		frame.getContentPane().add(textEstado);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTelaInicial.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(352, 471, 82, 25);
		frame.getContentPane().add(btnNewButton_1);
	}
}
