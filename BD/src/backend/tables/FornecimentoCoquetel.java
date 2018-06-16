package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FornecimentoCoquetel {
	private String fornecedora;
	private int coquetel;
	private float preco;
	
	public FornecimentoCoquetel(String fornecedora, int coquetel, float preco) {
		this.fornecedora = fornecedora;
		this.coquetel = coquetel;
		this.preco = preco;
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
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public static ObservableList<FornecimentoCoquetel> tableView(){
		ResultSet res;
		List<FornecimentoCoquetel> list = new ArrayList<FornecimentoCoquetel>();
		try {
			res = ConnectionManager.query("select * from FORNECIMENTOCOQUETEL");
			while(res.next())			
				list.add(new FornecimentoCoquetel(res.getString(1), res.getInt(2), res.getFloat(3)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
}
