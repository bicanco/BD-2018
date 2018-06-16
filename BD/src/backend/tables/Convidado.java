package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Convidado {
	private String email;
	private String nome;
	private String telefone;
	
	public Convidado(String email, String nome, String telefone) {
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public static ObservableList<Convidado> tableView(){
		ResultSet res;
		List<Convidado> list = new ArrayList<Convidado>();
		String sql="select * from CONVIDADO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new Convidado(res.getString(1), res.getString(2), res.getString(3)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaConvidado(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select NOME,EMAIL from CONVIDADO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(res.getString(1)+" / "+res.getString(2));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}
