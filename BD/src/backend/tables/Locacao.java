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
		String sql="select * from LOCACAO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new Locacao(res.getInt(1),res.getInt(2),res.getString(3), res.getString(4)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaLocacao(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select E.CNPJ, E.NOMEFANTASIA, F.DATA, L.NOME, L.CIDADE from EMPRESA E, FESTA F, LOCAL L, LOCACAO LO where F.TIPOFESTA = 'FESTFOOD' and F.CONTRATANTE = E.CNPJ and LO.FESTFOOD = F.ID and LO.NOMELOCAL = L.NOME and LO.CIDADELOCAL = L.CIDADE";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(res.getString(1)+" / "+res.getString(2)+" / "+res.getDate(3)+" \\/ "+res.getString(4)+" / "+res.getString(5));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	@Override
	public String toString() {
		return this.id+","+this.festFood+",'"+this.nomeLocal+"','"+this.cidadeLocal+"'";
	}
}
