package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoEmpresa {
	private String empresa;
	private String email;
	private String nome;
	private String telefone;
	
	public ContatoEmpresa(String empresa, String email, String nome, String telefone) {
		this.empresa = empresa;
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
	
	public static ObservableList<ContatoEmpresa> tableView(){
		ResultSet res;
		List<ContatoEmpresa> list = new ArrayList<ContatoEmpresa>();
		String sql="select * from CONTATOEMPRESA";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new ContatoEmpresa(res.getString(1), res.getString(2), res.getString(3), res.getString(4)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaEmail(){
		ResultSet res;
		List<String> list = new ArrayList<>();
		String sql = "select EMAIL,NOME from CONTATOEMPRESA";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(res.getString(1)+" / "+res.getString(2));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static void insertContatoEmpresa(ContatoEmpresa contatoEmpresa) {
		String sql = "insert into CONTATOEMPRESA (EMPRESA, EMAIL, NOME, TELEFONE) values("+contatoEmpresa+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateContatoEmpresa(ContatoEmpresa contatoEmpresa) {
		String sql = "update CONTATOEMPRESA set"
				+ contatoEmpresa.toStringUpdates()
				+ " where EMAIL = '"+contatoEmpresa.email+"'";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteEmpresa(ContatoEmpresa contatoEmpresa) {
		String sql = "delete from CONTATOEMPRESA"+contatoEmpresa.toStringRestritions();
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
		if(empresa.compareTo("") != 0) {
			res += " EMPRESA = '"+this.empresa+"'";
		}
		if(nome.compareTo("") != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
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
		return "'"+this.empresa+"','"+this.email+"','"+this.nome+"','"+this.telefone+"'";
	}
}
