package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String USER = "usuario";
	private static final String PASS = "senha";
	private static final String DRIVER = "net.sourceforge.jtds.jdbc.Driver";
	private static final String URL = "jdbc:jtds:sqlserver://localhost:1433/MercadinhoADA";
	
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			//throw new RuntimeException("Erro de conexão: ", e);
			e.getStackTrace();
		}
		return null;
		
		
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
