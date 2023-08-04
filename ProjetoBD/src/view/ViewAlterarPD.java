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

import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewAlterarPD {

	private JFrame frame;
	private JTextField textPdDescricao;
	private JTextField textFPdPreco;
	private JTextField textPdQuantidade;
	private JTextField textID;
	private JTable table;
	private JTable tableProduto;

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
					ViewAlterarPD window = new ViewAlterarPD();
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
	public ViewAlterarPD() {
		initialize();
		DefaultTableModel modelo = (DefaultTableModel) tableProduto.getModel();
		tableProduto.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		
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
		readTable();
	}
	public void readTable() {
		DefaultTableModel modelo = (DefaultTableModel) tableProduto.getModel();
		modelo.setNumRows(0);
		ProdutoDAO pdao = new ProdutoDAO();
		
		for(Produto p: pdao.read()) {
			modelo.addRow(new Object[] {
					p.getId(),
					p.getDecricao(),
					p.getCategoria(),
					p.getQuantidade(),
					p.getPreco()
			});
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 608, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 11, 485, 47);
		panel.setBackground(new Color(135, 206, 250));
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Alterar Produto");
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
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Produto p = new Produto();
					ProdutoDAO dao = new ProdutoDAO();
					p.setId((int) tableProduto.getValueAt(tableProduto.getSelectedRow(), 0));
					p.setDecricao(textPdDescricao.getText());
					p.setCategoria(comboBoxCategoria.getSelectedItem().toString());
					p.setQuantidade(Integer.parseInt(textPdQuantidade.getText()));
					p.setPreco(Double.parseDouble(textFPdPreco.getText()));
					
					dao.update(p);
					textPdDescricao.setText("");
					comboBoxCategoria.setSelectedIndex(0);
					textPdQuantidade.setText("");
					textFPdPreco.setText("");
					textID.setText("");
					readTable();
				} catch (IndexOutOfBoundsException e1) {
					
					JOptionPane.showMessageDialog(null, "Nenhum produto selecionado!");
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar: " + e1);
					
				}
		
			}
		});
		btnAtualizar.setBounds(432, 96, 128, 39);
		frame.getContentPane().add(btnAtualizar);
		
		JLabel lblNewLabel_1_4 = new JLabel("ID:");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(43, 74, 106, 20);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setColumns(10);
		textID.setBounds(155, 67, 261, 25);
		frame.getContentPane().add(textID);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				try {
					int confirm = JOptionPane.showConfirmDialog(btnExcluir, "Deseja mesmo excluir esse produto?");
					if(confirm == JOptionPane.YES_OPTION) {
							Produto p = new Produto();
							ProdutoDAO dao = new ProdutoDAO();
							p.setId((int) tableProduto.getValueAt(tableProduto.getSelectedRow(), 0));
						
							dao.delete(p);
							textPdDescricao.setText("");
							comboBoxCategoria.setSelectedIndex(0);
							textPdQuantidade.setText("");
							textFPdPreco.setText("");
							textID.setText("");
							
							readTable();
						}
				} catch (IndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "Nenhum produto selecionado!");
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar excluir: " + e1);
				}
		
				
			
			}
		});
		btnExcluir.setBounds(432, 165, 128, 39);
		frame.getContentPane().add(btnExcluir);
		
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"         ID", "  DESCRI\u00C7\u00C3O", "  CATEGORIA", " QUANTIDADE", "      PRE\u00C7O"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(4).setPreferredWidth(77);
		table.getColumnModel().getColumn(4).setMinWidth(31);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.textHighlight, null));
		table.setBounds(10, 254, 575, 22);
		frame.getContentPane().add(table);	
		
		tableProduto = new JTable();
		tableProduto.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(tableProduto.getSelectedRow() != -1) {
					textID.setText(tableProduto.getValueAt(tableProduto.getSelectedRow(), 0).toString());
					textPdDescricao.setText(tableProduto.getValueAt(tableProduto.getSelectedRow(), 1).toString());
					comboBoxCategoria.setSelectedItem(tableProduto.getValueAt(tableProduto.getSelectedRow(), 2).toString());
					textFPdPreco.setText(tableProduto.getValueAt(tableProduto.getSelectedRow(), 4).toString());
					textPdQuantidade.setText(tableProduto.getValueAt(tableProduto.getSelectedRow(), 3).toString());
				}
			}
		});
		tableProduto.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableProduto.setName("");
		tableProduto.setBounds(10, 276, 575, 192);
		tableProduto.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "DESCRI\u00C7\u00C3O", "CATEGORIA", "QUANTIDADE", "PRE\u00C7O"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		frame.getContentPane().add(tableProduto);
	}
}
