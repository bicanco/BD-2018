package backend;
import java.sql.*;

/**
 * Classe que gerencia a conexão com o banco de dados
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ConnectionManager{
	private static Connection con = null;
	private static PreparedStatement stmt;
	
	/**
	 * Função que conecta com o banco de dados
	 * @param login login do usuario do banco
	 * @param password senha do usuario do banco
	 */
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
	
	/**
	 * Função que retorna o resultado de uma consulta ao banco
	 * @param sql sql a ser executado
	 * @return a saida do script no banco
	 * @throws SQLException 
	 */
	public static ResultSet query(String sql) throws SQLException{
		ResultSet res = null;
		stmt = ConnectionManager.getConnection().prepareStatement(sql);
		res = stmt.executeQuery();
		return res;
	}
	
	/**
	 * Funcao que fecha uma consulta aberta ao banco
	 */
	public static void closeQuery(){
		try {
			if(!stmt.isClosed())
				stmt.close();
		}catch(SQLException e) {
		}
	}

	/**
	 * Funcao que fecha uma conexão com o banco
	 * @throws Exception
	 */
	public void endConnection() throws Exception{
		con.close();
	}
	
	/**
	 * Funcao que retorna a conexão com o banco
	 * @return
	 */
	public static Connection getConnection() {
		return con;
	}
}
