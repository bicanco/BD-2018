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
	
	public static void insertConvidado(Convidado convidado) {
		String sql = "insert into CONVIDADO (EMAIL, NOME, TELEFONE) values("+convidado+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateConvidado(Convidado convidado) {
		String sql = "update CONVIDADO set"
				+ convidado.toStringUpdates()
				+ " where EMAIL = '"+convidado.email+"'";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteEmpresa(Convidado convidado) {
		String sql = "delete from CONVIDADO"+convidado.toStringRestritions();
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(telefone.compareTo("") != 0) {
			res += " TELEFONE = '"+this.telefone+"'";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(nome.compareTo("") != 0) {
			res += " NOME = '"+this.nome+"'";
		}
		if(email.compareTo("") != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " EMAIL = '"+this.email+"'";
		}
		if(res.compareTo(" where ") == 0)
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.email+"','"+this.nome+"','"+this.telefone+"'";
	}
}
