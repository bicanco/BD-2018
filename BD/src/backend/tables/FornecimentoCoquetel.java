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
		String sql="select * from FORNECIMENTOCOQUETEL";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new FornecimentoCoquetel(res.getString(1), res.getInt(2), res.getFloat(3)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static void insertFornecimentoCoquetel(FornecimentoCoquetel fornecimentoCoquetel) {
		String sql = "insert into FORNECIMENTOCOQUETEL (FORNECEDORA, COQUETEL, PRECO) values("+fornecimentoCoquetel+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateFornecimentoCoquetel(FornecimentoCoquetel fornecimentoCoquetel) {
		String sql = "update FORNECIMENTOCOQUETEL set"
				+ fornecimentoCoquetel.toStringUpdates()
				+ " where COQUETEL = "+fornecimentoCoquetel.coquetel
				+ "and FORNECEDORA ='"+fornecimentoCoquetel.fornecedora+"'";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteEmpresa(FornecimentoCoquetel fornecimentoCoquetel) {
		String sql = "delete from FORNECIMENTOCOQUETEL"+fornecimentoCoquetel.toStringRestritions();
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(preco != 0) {
			res += " PRECO = "+this.preco;
		}
		return res;
	}
	
	
	private String toStringRestritions() {
		String res = " where ";
		if(fornecedora.compareTo("") != 0) {
			res += " FORNECEDORA = '"+this.fornecedora+"'";
		}
		if(coquetel != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " COQUETEL = "+this.coquetel;
		}
		if(res.compareTo(" where ") == 0)
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.fornecedora+"',"+this.coquetel+","+this.preco;
	}
}
