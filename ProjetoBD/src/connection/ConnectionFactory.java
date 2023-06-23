package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private final String nomeBanco = "MercadinhoADA";
	private final String USER = "userID";
	private final String PASS = "password";
	private final String DRIVER =  "net.sourceforge.jtds.jdbc.Driver";
	private final String URL = "jdbc:jtds:sqlserver://localhost:1433/";
	
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL+nomeBanco, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro de conexão: ", e);
		}
		
	}
	
	public static void closeConnection(Connection con) {
		
		try {
			if(con!=null) {
				con.close();
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		
		closeConnection(con);
		try {
				if(stmt != null) {
					stmt.close();
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		closeConnection(con, stmt);
		
		try {
				if(rs != null) {
					rs.close();
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
}
