package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que gerencia a tabela EMPRESA
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class Empresa {
	private String cnpj;
	private String nome;
	private String razao;
	private String endereco;
	private String tipo;
	
	public Empresa(String cnpj, String nomeFantasia, String razaoSocial, String endereco, String tipo) {
		this.cnpj = cnpj;
		this.nome = nomeFantasia;
		this.razao = razaoSocial;
		this.endereco = endereco;
		this.tipo = tipo;
	}

	// Deixar os set e gets - sao necessarios devido CellValueFactory
	// Usar o mesmo nome da variavel que esta no PropertyValueFactory e deixar a primeira letra maiuscula nos sets e gets
	
	public String getCnpj(){
		return cnpj;
	}
	public void setCnpj(String cnpj){
		this.cnpj = cnpj;
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getRazao(){
		return razao;
	}
	public void setRazao(String razao){
		this.razao = cnpj;
	}
	public String getEndereco(){
		return endereco;
	}
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	public String getTipo(){
		return tipo;
	}
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public static ObservableList<Empresa> tableView(){
		ResultSet res;
		List<Empresa> list = new ArrayList<Empresa>();
		String sql="select * from EMPRESA";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new Empresa(res.getString(1), res.getString(2), res.getString(3), res.getString(4), null));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaEmpresa(){
		ResultSet res;
		List<String> list = new ArrayList<>();
		String sql = "select CNPJ, NOMEFANTASIA from EMPRESA";
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
	
	public static void insertEmpresa(Empresa empresa) {
		String sql = "insert into EMPRESA (CNPJ, NOMEFANTASIA, RAZAOSOCIAL, ENDERECO) values("+empresa+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
			/*
			switch(empresa.tipo) {
				case "fornecedora":
					Forncedora fornecedora = new Fornecedora(empresa.getCnpj());
					Fornecedora.insertFornecedo(fornecedora);
				break;
			}
			*/
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateEmpresa(Empresa empresa) {
		String sql = "update EMPRESA set"
				+ empresa.toStringUpdates()
				+ " where CNPJ = '"+empresa.cnpj+"'";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteEmpresa(Empresa empresa) {
		String sql = "delete from EMPRESA"+empresa.toStringRestritions();
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(nome.compareTo("") != 0) {
			res += " NOMEFANTASIA = '"+this.nome+"'";
		}
		if(endereco.compareTo("") != 0) {
			if(res.compareTo("") != 0)
				res += ", ";
			res += " ENDERECO = '"+this.endereco+"'";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(cnpj.compareTo("") != 0) {
			res += " CNPJ = '"+this.cnpj+"'";
		}
		if(nome.compareTo("") != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " NOMEFANTASIA = '"+this.nome+"'";
		}
		if(res.compareTo(" where ") == 0)
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.cnpj+"','"+this.nome+"','"+this.razao+"','"+this.endereco+"'";
	}
}
