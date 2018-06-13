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
	
	public ObservableList<FestFood> tableView(){
		ResultSet res;
		List<FestFood> list = new ArrayList<FestFood>();
		try {
			res = ConnectionManager.query("select * from FESTFOOD");
			while(res.next())
				list.add(new FestFood(res.getInt(1),res.getFloat(2)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
