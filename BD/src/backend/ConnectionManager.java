package backend;
import java.sql.*;

public class ConnectionManager{
	private static Connection con;
	
	public static void connect(String login, String password) {
		String driver = "jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl";
		try {
			con = DriverManager.getConnection(driver,login,password);
		}catch(SQLException e) {
			System.out.println("Could not connect to database. Error:"+e);
			System.exit(1);
		}
		System.out.println("Connected to database");
	}

	public void endConnection() throws Exception{
		con.close();
	}
	public Connection getConnection() {
		return con;
	}
}
