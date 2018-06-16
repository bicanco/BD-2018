package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Coquetel {
	private int festa;
	private float orcamento;
	private String local;
	private String cidade;
	
	public Coquetel(int festa, float orcamento, String local, String cidade) {
		this.festa = festa;
		this.orcamento = orcamento;
		this.local = local;
		this.cidade = cidade;
	}
	
	public int getFesta() {
		return festa;
	}
	
	public void setFesta(int festa) {
		this.festa = festa;
	}
	
	public float getOrcamento() {
		return orcamento;
	}
	
	public void setOrcamento(int orcamento) {
		this.orcamento = orcamento;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public static ObservableList<Coquetel> tableView(){
		ResultSet res;
		List<Coquetel> list = new ArrayList<Coquetel>();
		try {
			res = ConnectionManager.query("select * from COQUETEL");
			while(res.next())			
				list.add(new Coquetel(res.getInt(1), res.getFloat(2), res.getString(3), res.getString(4)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaCoquetel(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		try {
			res = ConnectionManager.query("select E.CNPJ, E.NOMEFANTASIA, F.DATA from EMPRESA E, FESTA F where F.TIPOFESTA = 'COQUETEL' and F.CONTRATANTE = E.CNPJ");
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
