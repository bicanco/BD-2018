package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AtribuicaoCategoria {
	private String fornecedora;
	private String categoria;
	private String faixaPreco;
	
	public AtribuicaoCategoria(String fornecedora, String categoria, String faixaPreco) {
		this.fornecedora = fornecedora;
		this.categoria = categoria;
		this.faixaPreco = faixaPreco;
	}
	
	public String getFornecedora() {
		return fornecedora;
	}
	
	public void setFornecedora(String fornecedora) {
		this.fornecedora = fornecedora;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getFaixaPreco() {
		return faixaPreco;
	}
	
	public void setFaixaPreco(String faixaPreco) {
		this.faixaPreco = faixaPreco;
	}
	
	public static ObservableList<AtribuicaoCategoria> tableView(){
		ResultSet res;
		List<AtribuicaoCategoria> list = new ArrayList<AtribuicaoCategoria>();
		String sql ="select * from ATRIBUICAOCATEGORIA";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new AtribuicaoCategoria( res.getString(1), res.getString(2), res.getString(3)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static void insertAtribuicaoCategoria(AtribuicaoCategoria atribuicaoCategoria) throws Exception {
		String sql = "insert into ATRIBUICAOCATEGORIA (FORNECEDORA, CATEGORIA, FAIXAPRECO) values("+atribuicaoCategoria+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-12899") || aux.equals("ORA-02290")){
					mesg = "O campo faixa de preco deve ser preenchido com : 1,2,3,4 ou 5.";
			}else if(aux.equals("ORA-00001")) {
					mesg = "Essa empresa já está associada a essa categoria. Por favor selecione outra empresa e/ou categoria.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateAtribuicaoCategoria(AtribuicaoCategoria atribuicaoCategoria) throws Exception {
		String sql = "update ATRIBUICAOCATEGORIA set"
				+ atribuicaoCategoria.toStringUpdates()
				+ " where FORNECEDORA = '"+atribuicaoCategoria.fornecedora+"'"
				+ "and CATEGORIA = '"+atribuicaoCategoria.categoria+"'";
		System.out.println(sql);
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			System.out.println(e);
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-01747")){
					mesg = "É necessário preencher pelo menos 1 dos campos a alterar.";
			}else if(aux.equals("ORA-02290")) {
					mesg = "O campo faixa de preco deve ser preenchido com : 1,2,3,4 ou 5.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteAtribuicaoCategoria(AtribuicaoCategoria atribuicaoCategoria) throws Exception {
		String aux = atribuicaoCategoria.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from ATRIBUICAOCATEGORIA"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(!faixaPreco.equals("")) {
			res += " FAIXAPRECO = '"+this.faixaPreco+"'";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(!fornecedora.equals("")) {
			res += " FORNECEDORA = '"+this.fornecedora+"'";
		}
		if(!categoria.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " CATEGORIA = '"+this.categoria+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.fornecedora+"','"+this.categoria+"','"+this.faixaPreco+"'";
	}
}
