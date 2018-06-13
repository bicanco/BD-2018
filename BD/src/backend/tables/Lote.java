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
	
	public ObservableList<Lote> tableView(){
		ResultSet res;
		List<Lote> list = new ArrayList<Lote>();
		try {
			res = ConnectionManager.query("select * from LOTE");
			while(res.next())
				list.add(new Lote(res.getInt(1),res.getInt(2),res.getString(3),res.getFloat(4),res.getFloat(5),res.getFloat(6)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
