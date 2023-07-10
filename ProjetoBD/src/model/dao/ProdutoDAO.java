package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Produto;

public class ProdutoDAO {
	
	public void create(Produto p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Produto (descricao, categoria, quantidade, preco) VALUES (?,?,?,?)");
			stmt.setString(1, p.getDecricao());
			stmt.setString(2, p.getCategoria());
			stmt.setInt(3, p.getQuantidade());
			stmt.setDouble(4, p.getPreco());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} catch (SQLException e) {
		
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		} finally {ConnectionFactory.closeConnection(con, stmt);}
		
	}

}
