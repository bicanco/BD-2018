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
	
	public static void insertLote(Lote lote) throws Exception {
		String sql = "insert into LOTE (LOCACAO, NUMERO, FORNECEDORA, PRECO, LARGURA, COMPRIMENTO) values("+lote+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já há um Lote com esse Número nessa Locação.Por favor selecione outra Locação e/ou Número.";
			}else if(aux.equals("ORA-01400")) {
					mesg = "Os campos Preço e Número tem que ser preenchidos.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateLote(Lote lote) throws Exception {
		String sql = "update LOTE set"
				+ lote.toStringUpdates()
				+ " where LOCACAO = "+lote.locacao
				+ "and NUMERO = "+lote.numero;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-01747")){
					mesg = "É necessário preencher pelo menos 1 dos campos a alterar.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteLote(Lote lote) throws Exception {
		String aux = lote.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from LOTE"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(!fornecedora.equals("")) {
			res += " FORNECEDORA = '"+this.fornecedora+"'";
		}
		if(preco != 0) {
			if(!res.equals(""))
				res += ", ";
			res += " PRECO = "+preco;
		}
		if(largura != 0) {
			if(!res.equals(""))
				res += ", ";
			res += " LARGURA = "+this.largura;
		}
		if(comprimento != 0) {
			if(!res.equals(""))
				res += ", ";
			res += " COMPRIMENTO = "+this.comprimento;
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(!fornecedora.equals("")) {
			res += " FORNECEDORA = '"+this.fornecedora+"'";
		}
		if(locacao != 0) {
			if(!res.equals(" where "))
				res += " and ";
			res += " LOCACAO = "+this.locacao;
		}
		if(numero != 0) {
			if(!res.equals(" where "))
				res += " and ";
			res += " NUMERO = "+this.numero;
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return this.locacao+","+this.numero+",'"+this.fornecedora+"',"+this.preco+","+this.largura+","+this.comprimento;
	}
}
