package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutosFornecidos {
	private String fornecedora;
	private int coquetel;
	private String nome;
	private int quantidade;
	
	public ProdutosFornecidos(String fornecedora, int coquetel, String nome, int quantidade) {
		this.fornecedora = fornecedora;
		this.coquetel = coquetel;
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
	public String getFornecedora() {
		return fornecedora;
	}
	
	public void setFornecedora(String fornecedora) {
		this.fornecedora = fornecedora;
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
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public static ObservableList<ProdutosFornecidos> tableView(){
		ResultSet res;
		List<ProdutosFornecidos> list = new ArrayList<ProdutosFornecidos>();
		try {
			res = ConnectionManager.query("select * from PRODUTOSFORNECIDOS");
			while(res.next())			
				list.add(new ProdutosFornecidos(res.getString(1), res.getInt(2), res.getString(3), res.getInt(4)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
}
