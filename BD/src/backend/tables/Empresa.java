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
		try {
			res = ConnectionManager.query("select * from EMPRESA");
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
		
		try {
			res = ConnectionManager.query("select CNPJ, NOMEFANTASIA from EMPRESA");
			while(res.next())			
				list.add(res.getString(1)+" / "+res.getString(2));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
}
