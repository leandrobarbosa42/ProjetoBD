package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void update(Produto p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Produto SET descricao = ?, categoria = ?, quantidade = ?, preco = ? WHERE idProduto = ?");
			stmt.setString(1, p.getDecricao());
			stmt.setString(2, p.getCategoria());
			stmt.setInt(3, p.getQuantidade());
			stmt.setDouble(4, p.getPreco());
			stmt.setInt(5, p.getId());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (SQLException e) {
		
			JOptionPane.showMessageDialog(null, "Erro ao Atualizar: "+ e);
		} finally {ConnectionFactory.closeConnection(con, stmt);}
		
	}
	
	public void delete(Produto p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM Produto WHERE idProduto = ?");
		
			stmt.setInt(1, p.getId());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		} catch (SQLException e) {
		
			JOptionPane.showMessageDialog(null, "Erro ao Excluir: "+ e);
		} finally {ConnectionFactory.closeConnection(con, stmt);}
		
	}

	public List<Produto> read(){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Produto> produtos = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Produto");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto produto = new Produto();
				
				produto.setId(rs.getInt("idProduto"));
				produto.setDecricao(rs.getString("descricao"));
				produto.setCategoria(rs.getString("categoria"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
				produtos.add(produto);
				
			}
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return produtos;		
	}
	public List<Produto> readForDesc(String desc){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Produto> produtos = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Produto WHERE descricao LIKE ?");
			stmt.setString(1,"%"+desc+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto produto = new Produto();
				
				produto.setId(rs.getInt("idProduto"));
				produto.setDecricao(rs.getString("descricao"));
				produto.setCategoria(rs.getString("categoria"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
				produtos.add(produto);
				
			}
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return produtos;		
	}
}
