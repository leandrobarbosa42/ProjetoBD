package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.bean.Produto;
import model.dao.ProdutoDAO;


import java.awt.SystemColor;

import javax.swing.JScrollBar;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;


public class ViewConsulta {

	private JFrame frame;
	private JTable tableProduto;
	private JScrollBar scrollBar;
	private JTable table;
	private JTextField textDesc;

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
					ViewConsulta window = new ViewConsulta();
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
	public ViewConsulta() {
		initialize();
		DefaultTableModel modelo = (DefaultTableModel) tableProduto.getModel();
		tableProduto.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTelaInicial.main(null);
				frame.dispose();
			}
			
		});
		btnVoltar.setBounds(520, 11, 61, 23);
		frame.getContentPane().add(btnVoltar);
		
		textDesc = new JTextField();
		textDesc.setBounds(137, 66, 239, 22);
		frame.getContentPane().add(textDesc);
		textDesc.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PESQUISAR:");
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
		lblNewLabel_1.setBounds(31, 66, 96, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readTableForDesc(textDesc.getText());
				textDesc.setText(null);
			}
		});
		btnBuscar.setBounds(427, 66, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		
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
	public void readTableForDesc(String desc) {
		DefaultTableModel modelo = (DefaultTableModel) tableProduto.getModel();
		modelo.setNumRows(0);
		ProdutoDAO pdao = new ProdutoDAO();
		
		for(Produto p: pdao.readForDesc(desc)) {
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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 621, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTA");
		lblNewLabel.setBounds(208, 11, 168, 19);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(588, 130, 17, 184);
		frame.getContentPane().add(scrollBar);
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{" ID", " DESCRI\u00C7\u00C3O", " CATEGORIA", " QUANTIDADE", " PRE\u00C7O"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(77);
		table.getColumnModel().getColumn(4).setMinWidth(31);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		table.setBounds(10, 100, 575, 22);
		frame.getContentPane().add(table);
		
		tableProduto = new JTable();
		tableProduto.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		tableProduto.setBounds(10, 122, 575, 192);
		tableProduto.setName("");
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
		tableProduto.getColumnModel().getColumn(0).setPreferredWidth(29);
		tableProduto.getColumnModel().getColumn(1).setPreferredWidth(135);
		tableProduto.getColumnModel().getColumn(3).setPreferredWidth(40);
		frame.getContentPane().add(tableProduto);
	}
}
