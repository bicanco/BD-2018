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
	
	public static void insertEmpresa(Empresa empresa) throws Exception {
		String sql = "insert into EMPRESA (CNPJ, NOMEFANTASIA, RAZAOSOCIAL, ENDERECO) values("+empresa+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já há uma Empresa com esse CNPJ.Por favor digite outro valor para CNPJ.";
			}else if(aux.equals("ORA-01400")) {
					mesg = "Os campos Nome Fantasia, Razão Social e Endereco tem que ser preenchidos.";
			}else if(aux.equals("ORA-12899")) {
					mesg = "Os limites de caracteres dos campos são: CNPJ - 14; Nome Fantasia - 60; Razão Social - 120; Endereço - 120.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateEmpresa(Empresa empresa) throws Exception {
		String sql = "update EMPRESA set"
				+ empresa.toStringUpdates()
				+ " where CNPJ = '"+empresa.cnpj+"'";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-01747")){
					mesg = "É necessário preencher pelo menos 1 dos campos a alterar.";
			}else if(aux.equals("ORA-12899")) {
					mesg = "Os limites de caracters dos campos são:Nome Fantasia-60 Endereço-120";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteEmpresa(Empresa empresa) throws Exception {
		String aux = empresa.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from EMPRESA"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(!nome.equals("")) {
			res += " NOMEFANTASIA = '"+this.nome+"'";
		}
		if(!endereco.equals("")) {
			if(!res.equals(""))
				res += ", ";
			res += " ENDERECO = '"+this.endereco+"'";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(!cnpj.equals("")) {
			res += " CNPJ = '"+this.cnpj+"'";
		}
		if(!nome.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " NOMEFANTASIA = '"+this.nome+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.cnpj+"','"+this.nome+"','"+this.razao+"','"+this.endereco+"'";
	}
}
