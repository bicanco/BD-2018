package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que gerencia a tabela LOCAL
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
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
	
	public static void insertLocal(Local local) throws Exception {
		String sql = "insert into LOCAL (NOME, CIDADE, ESTADO, RUA, NUMERO, MAXFREQUENTADORES, POSSUIABERTURA, DIARIALOCACAO) values("+local+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já há um Local com esse Nome nessa Cidade. Por favor digite outro Nome e/ou Cidade.";
			}else if(aux.equals("ORA-01400")) {
					mesg = "Os campos Nome, Rua, Número, Cidade, Estado, Capacidade e Valor da Diária tem que ser preenchidos.";
			}else if(aux.equals("ORA-12899")) {
					mesg = "Os limites de caracteres dos campos são: Nome - 60; Cidade - 40; Estado - 19; Rua - 40.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateLocal(Local local) throws Exception {
		String sql = "update LOCAL set"
				+ local.toStringUpdates()
				+ " where NOME = '"+local.nome+"'"
				+ "and CIDADE ='"+local.cidade+"'";
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
	
	public static void deleteLocal(Local local) throws Exception {
		String aux = local.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from LOCAL"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(!rua.equals("")) {
			res += " RUA = '"+this.rua+"'";
		}
		if(!estado.equals("")) {
			if(!res.equals(""))
				res += ", ";
			res += " ESTADO = '"+this.estado+"'";
		}
		if(numero != 0) {
			if(!res.equals(""))
				res += ", ";
			res += " NUMERO = "+this.numero;
		}
		if(maxFrequentadores != 0) {
			if(!res.equals(""))
				res += ", ";
			res += " MAXFREQUENTADORES = "+this.maxFrequentadores;
		}
		if(diariaLocacao != 0) {
			if(!res.equals(""))
				res += ", ";
			res += " DIARIALOCAO = "+this.diariaLocacao;
		}
		if(!possuiAbertura.equals("")) {
			if(!res.equals(""))
				res += ", ";
			res += " POSSUIABERTURA = '"+this.possuiAbertura+"'";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(!nome.equals("")) {
			res += " NOME = '"+this.nome+"'";
		}
		if(!cidade.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " CIDADE = '"+this.cidade+"'";
		}
		if(!estado.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " ESTADO = '"+this.estado+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.nome+"','"+this.cidade+"','"+this.estado+"','"+this.rua+"',"+this.numero+","+this.maxFrequentadores+",'"+this.possuiAbertura+"',"+this.diariaLocacao;
	}
}
