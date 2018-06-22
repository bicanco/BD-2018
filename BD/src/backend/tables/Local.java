package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Local {
	private String nome;
	private String cidade;
	private String estado;
	private String rua;
	private int numero;
	private int maxFrequentadores;
	private String possuiAbertura;
	private float diariaLocacao;
	
	public Local(String nome, String cidade, String estado, String rua, int numero, int maxFrequentadores, String possuiAbertura, float diariaLocacao) {
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.rua = rua;
		this.numero = numero;
		this.maxFrequentadores = maxFrequentadores;
		this.possuiAbertura = possuiAbertura;
		this.diariaLocacao = diariaLocacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getMaxFrequentadores() {
		return maxFrequentadores;
	}
	
	public void setMaxFrequentadores(int maxFrequentadores) {
		this.maxFrequentadores = maxFrequentadores;
	}
	
	public String getPossuiAbertura() {
		return possuiAbertura;
	}
	
	public void setPossuiAbertura(String possuiAbertura) {
		this.possuiAbertura = possuiAbertura;
	}
	
	public float getDiariaLocacao() {
		return diariaLocacao;
	}
	
	public void setDiariaLocacao(float diariaLocacao) {
		this.diariaLocacao = diariaLocacao;
	}
	
	public static ObservableList<Local> tableView(){
		ResultSet res;
		List<Local> list = new ArrayList<Local>();
		String sql="select * from LOCAL";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new Local(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6),res.getString(7),res.getFloat(8)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaNome(){
		ResultSet res;
		List<String> list = new ArrayList<>();
		String sql = "select NOME from LOCAL";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(res.getString(1));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaCidade() {
		ResultSet res;
		List<String> list = new ArrayList<>();
		String sql = "select DISTINCT CIDADE from LOCAL";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(res.getString(1));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaLocal(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select NOME,CIDADE from LOCAL";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(res.getString(1)+" / "+res.getString(2));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public static void insertLocal(Local local) {
		String sql = "insert into LOCAL (NOME, CIDADE, ESTADO, RUA, NUMERO, MAXFREQUENTADORES, POSSUIABERTURA, DIARIALOCACAO) values("+local+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateLocal(Local local) {
		String sql = "update LOCAL set"
				+ local.toStringUpdates()
				+ " where NOME = '"+local.nome+"'"
				+ "and CIDADE ='"+local.cidade+"'";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteEmpresa(Local local) {
		String sql = "delete from LOCAL"+local.toStringRestritions();
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(rua.compareTo("") != 0) {
			res += " RUA = '"+this.rua+"'";
		}
		if(estado.compareTo("") != 0) {
			if(res.compareTo("") != 0)
				res += ", ";
			res += " ESTADO = '"+this.estado+"'";
		}
		if(numero != 0) {
			if(res.compareTo("") != 0)
				res += ", ";
			res += " NUMERO = "+this.numero;
		}
		if(maxFrequentadores != 0) {
			if(res.compareTo("") != 0)
				res += ", ";
			res += " MAXFREQUENTADORES = "+this.maxFrequentadores;
		}
		if(diariaLocacao != 0) {
			if(res.compareTo("") != 0)
				res += ", ";
			res += " DIARIALOCAO = "+this.diariaLocacao;
		}
		if(possuiAbertura.compareTo("") != 0) {
			if(res.compareTo("") != 0)
				res += ", ";
			res += " POSSUIABERTURA = '"+this.possuiAbertura+"'";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(nome.compareTo("") != 0) {
			res += " NOME = '"+this.nome+"'";
		}
		if(cidade.compareTo("") != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " CIDADE = '"+this.cidade+"'";
		}
		if(estado.compareTo("") != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " ESTADO = '"+this.estado+"'";
		}
		if(res.compareTo(" where ") == 0)
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.nome+"','"+this.cidade+"','"+this.estado+"','"+this.rua+"',"+this.numero+","+this.maxFrequentadores+",'"+this.possuiAbertura+"',"+this.diariaLocacao;
	}
}
