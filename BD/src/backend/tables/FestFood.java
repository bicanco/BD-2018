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
		String sql="select F.ID, F.DATA, E.CNPJ, E.NOMEFANTASIA from EMPRESA E, FESTA F where F.TIPOFESTA = 'FESTFOOD' and F.CONTRATANTE = E.CNPJ";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(res.getInt(1)+" / "+res.getDate(2)+" / "+res.getString(3)+" / "+res.getString(4));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public static void insertFestFood(FestFood festFood) throws Exception {
		String sql = "insert into FESTFOOD (FESTA, PRECOINGRESSO) values("+festFood+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já foi definido um Preço de ingresso para esse FestFood.";
			}else if(aux.equals("ORA-01400")) {
					mesg = "O campo Preço do ingresso tem que ser preenchido.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateFestFood(FestFood festFood) throws Exception {
		String sql = "update FESTFOOD set"
				+ festFood.toStringUpdates()
				+ " where FESTA = "+festFood.festa;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-01747")){
					mesg = "É necessário preencher pelo menos 1 dos campos a alterar.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteFestFood(FestFood festFood) throws Exception {
		String aux = festFood.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from FESTFOOD"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(precoIngresso != 0) {
			res += " PRECOINGRESSO = "+this.precoIngresso;
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(festa != 0) {
			res += " FESTA = "+this.festa;
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.festa+"',"+this.precoIngresso;
	}
}
