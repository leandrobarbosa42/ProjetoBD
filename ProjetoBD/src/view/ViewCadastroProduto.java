package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

public class ViewCadastroProduto {

	private JFrame frame;
	private JTextField textPdDescricao;
	private JTextField textFPdPreco;
	private JTextField textPdQuantidade;

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
					ViewCadastroProduto window = new ViewCadastroProduto();
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
	public ViewCadastroProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 11, 485, 75);
		panel.setBackground(new Color(135, 206, 250));
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Cadastrar Produto");
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(175, 238, 238));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		JLabel lblNewLabel_1 = new JLabel("Descrição:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(53, 116, 106, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textPdDescricao = new JTextField();
		textPdDescricao.setBounds(155, 116, 261, 20);
		frame.getContentPane().add(textPdDescricao);
		textPdDescricao.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Categoria:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(53, 148, 106, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Preço:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(53, 179, 106, 20);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textFPdPreco = new JTextField();
		textFPdPreco.setColumns(10);
		textFPdPreco.setBounds(155, 179, 261, 20);
		frame.getContentPane().add(textFPdPreco);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quantidade:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(53, 210, 106, 20);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textPdQuantidade = new JTextField();
		textPdQuantidade.setColumns(10);
		textPdQuantidade.setBounds(155, 210, 261, 20);
		frame.getContentPane().add(textPdQuantidade);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(155, 147, 261, 22);
		frame.getContentPane().add(comboBoxCategoria);
	}
}
