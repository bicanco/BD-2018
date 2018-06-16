package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FestFood {
	private int festa;
	private float precoIngresso;
	
	public FestFood(int festa, float precoIngresso) {
		this.festa = festa;
		this.precoIngresso = precoIngresso;
	}
	
	public int getFesta() {
		return festa;
	}
	
	public void setFesta(int festa) {
		this.festa = festa;
	}
	
	public float getPrecoIngresso() {
		return precoIngresso;
	}
	
	public void setPrecoIngresso(float precoIngresso) {
		this.precoIngresso = precoIngresso;
	}
	
	public static ObservableList<FestFood> tableView(){
		ResultSet res;
		List<FestFood> list = new ArrayList<FestFood>();
		String sql="select * from FESTFOOD";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new FestFood(res.getInt(1),res.getFloat(2)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaFestFood(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select E.CNPJ, E.NOMEFANTASIA, F.DATA from EMPRESA E, FESTA F where F.TIPOFESTA = 'FESTFOOD' and F.CONTRATANTE = E.CNPJ";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(res.getString(1)+" / "+res.getString(2)+" / "+res.getDate(3));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}
