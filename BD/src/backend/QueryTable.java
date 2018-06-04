package backend;
import java.sql.*;
import java.util.ArrayList;

public class QueryTable{
	String sql;
	private ArrayList<String> query() throws SQLException{
		ArrayList<String> resp = new ArrayList<String>();
		try {
		PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(sql);
		ResultSet aux = stmt.executeQuery();
		while(aux.next()) {
			resp.add(aux.getString(1));
		}
		stmt.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
		return resp;
	}
	public ArrayList<String> queryAttribute(String attribute,String table) throws SQLException {
		sql = "SELECT " + attribute+" FROM "+table;
		return query();
	}
}
