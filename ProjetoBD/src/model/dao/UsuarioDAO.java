package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import connection.ConnectionFactory;



public class UsuarioDAO {
@SuppressWarnings("deprecation")
public boolean CheckLogin(String login, JPasswordField passwordPass){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Usuario WHERE usuario = ? and senha = ?");
			stmt.setString(1, login);
			stmt.setString(2, passwordPass.getText());
			rs = stmt.executeQuery();
		
			
			if(rs.next()) {
			
			check = true;	
				
			}
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro conexão: "+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return check;		
	}
}
