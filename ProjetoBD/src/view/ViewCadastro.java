package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;


import javax.swing.SwingConstants;

import model.bean.Produto;
import model.dao.ProdutoDAO;


import java.awt.BorderLayout;
import javax.swing.JTextField;

import javax.swing.JOptionPane;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ViewCadastro {

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
					ViewCadastro window = new ViewCadastro();
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
	public ViewCadastro() {
		initialize();
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/ProjetoBD/src/IMG/1280152.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTelaInicial.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(538, 11, 47, 47);
		frame.getContentPane().add(btnNewButton);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 608, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 11, 485, 47);
		panel.setBackground(new Color(135, 206, 250));
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Novo Produto");
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(175, 238, 238));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		JLabel lblNewLabel_1 = new JLabel("Descrição:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(43, 105, 106, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textPdDescricao = new JTextField();
		textPdDescricao.setBounds(155, 103, 261, 25);
		frame.getContentPane().add(textPdDescricao);
		textPdDescricao.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Categoria:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(43, 143, 106, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Preço:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(43, 174, 106, 20);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textFPdPreco = new JTextField();
		textFPdPreco.setColumns(10);
		textFPdPreco.setBounds(155, 172, 261, 25);
		frame.getContentPane().add(textFPdPreco);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quantidade:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(43, 210, 106, 20);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textPdQuantidade = new JTextField();
		textPdQuantidade.setColumns(10);
		textPdQuantidade.setBounds(155, 208, 261, 25);
		frame.getContentPane().add(textPdQuantidade);
		
		JComboBox<Object> comboBoxCategoria = new JComboBox<Object>();
		comboBoxCategoria.setMaximumRowCount(12);
		comboBoxCategoria.setModel(new DefaultComboBoxModel<Object>(new String[] {"Outros", "Alimento enlatado", "Alimento padaria", "Alimento liquidos", "Alimento geral", "Doces", "Temperos", "Hortaliças", "Frutas", "Carnes", "Frios", "Bebidas", "Bebidas Alcoólicas"}));
		comboBoxCategoria.setBounds(155, 136, 261, 27);
		frame.getContentPane().add(comboBoxCategoria);
		
		JButton btnAtualizar = new JButton("CADASTRAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Produto p = new Produto();
					ProdutoDAO dao = new ProdutoDAO();
					
					p.setDecricao(textPdDescricao.getText());
					p.setCategoria(comboBoxCategoria.getSelectedItem().toString());
					p.setQuantidade(Integer.parseInt(textPdQuantidade.getText()));
					p.setPreco(Double.parseDouble(textFPdPreco.getText()));
					
					dao.create(p);
					textPdDescricao.setText("");
					comboBoxCategoria.setSelectedIndex(0);
					textPdQuantidade.setText("");
					textFPdPreco.setText("");
				
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar: " + e1);
					
				}
		
			}
		});
		btnAtualizar.setBounds(164, 255, 241, 39);
		frame.getContentPane().add(btnAtualizar);
		
		JLabel lblNewLabel_1_4 = new JLabel("ID:");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(43, 74, 106, 20);
		frame.getContentPane().add(lblNewLabel_1_4);
	}
}
