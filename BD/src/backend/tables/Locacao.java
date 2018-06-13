package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Locacao {
	private int id;
	private int festFood;
	private String nomeLocal;
	private String cidadeLocal;
	
	public Locacao(int id, int festFood, String nomeLocal, String cidadeLocal) {
		this.id = id;
		this.festFood= festFood;
		this.nomeLocal = nomeLocal;
		this.cidadeLocal = cidadeLocal;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFestFood() {
		return festFood;
	}
	
	public void setFestFood(int festFood) {
		this.festFood = festFood;
	}
	
	public String getNomeLocal() {
		return nomeLocal;
	}
	
	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}
	
	public String getCidadeLocal() {
		return cidadeLocal;
	}
	
	public void setCidadeLocal(String cidadeLocal) {
		this.cidadeLocal = cidadeLocal;
	}
	
	public static ObservableList<Locacao> tableView(){
		ResultSet res;
		List<Locacao> list = new ArrayList<Locacao>();
		try {
			res = ConnectionManager.query("select * from LOCACAO");
			while(res.next())
				list.add(new Locacao(res.getInt(1),res.getInt(2),res.getString(3), res.getString(4)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
