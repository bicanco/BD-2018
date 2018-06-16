package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Brinde {
	private int coquetel;
	private String nome;
	private String descricao;
	
	public Brinde(int coquetel, String nome, String descricao) {
		this.coquetel = coquetel;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public int getCoquetel() {
		return coquetel;
	}
	
	public void setCoquetel(int coquetel) {
		this.coquetel = coquetel;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static ObservableList<Brinde> tableView(){
		ResultSet res;
		List<Brinde> list = new ArrayList<Brinde>();
		String sql ="select * from BRINDE";
		try {
			res = ConnectionManager.query("select * from BRINDE");
			while(res.next())			
				list.add(new Brinde(res.getInt(1), res.getString(2), res.getString(3)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		return this.coquetel+",'"+this.nome+"','"+this.descricao+"'";
	}
}
