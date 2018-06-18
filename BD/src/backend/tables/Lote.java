package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Lote {
	private int locacao;
	private int numero;
	private String fornecedora;
	private float preco;
	private float largura;
	private float comprimento;
	
	public Lote(int locacao, int numero, String fornecedora, float preco, float largura, float comprimento) {
		this.locacao = locacao;
		this.numero = numero;
		this.fornecedora = fornecedora;
		this.preco = preco;
		this.largura = largura;
		this.comprimento = comprimento;
	}
	
	public int getLocacao() {
		return locacao;
	}
	
	public void setLocacao(int locacao) {
		this.locacao = locacao;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getFornecedora() {
		return fornecedora;
	}
	
	public void setFornecedora(String fornecedora) {
		this.fornecedora = fornecedora;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco){
		this.preco = preco;
	}
	
	public float getLargura() {
		return largura;
	}
	
	public void setLargura(float largura) {
		this.largura = largura;
	}
	
	public float getComprimento() {
		return comprimento;
	}
	
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	
	public static ObservableList<Lote> tableView(){
		ResultSet res;
		List<Lote> list = new ArrayList<Lote>();
		String sql="select * from LOTE";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new Lote(res.getInt(1),res.getInt(2),res.getString(3),res.getFloat(4),res.getFloat(5),res.getFloat(6)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void insertLote(Lote lote) {
		String sql = "insert into LOTE (LOCACAO, NUMERO, FORNECEDORA, PRECO, LARGURA, COMPRIMENTO) values("+lote+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteEmpresa(Lote lote) {
		String sql = "delete from LOTE"+lote.toStringRestritions();
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(fornecedora.compareTo("") != 0) {
			res += " FORNECEDORA = '"+this.fornecedora+"'";
		}
		if(locacao != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " LOCACAO = "+this.locacao;
		}
		if(numero != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " NUMERO = "+this.numero;
		}
		if(res.compareTo(" where ") == 0)
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return this.locacao+","+this.numero+",'"+this.fornecedora+"',"+this.preco+","+this.largura+","+this.comprimento;
	}
}
