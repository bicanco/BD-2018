package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que gerencia a tabela CONVIDADO
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class Convidado {
	private String email;
	private String nome;
	private String telefone;
	
	public Convidado(String email, String nome, String telefone) {
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public static ObservableList<Convidado> tableView(){
		ResultSet res;
		List<Convidado> list = new ArrayList<Convidado>();
		String sql="select * from CONVIDADO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new Convidado(res.getString(1), res.getString(2), res.getString(3)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaConvidado(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select EMAIL,NOME from CONVIDADO";
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
	
	public static void insertConvidado(Convidado convidado) throws Exception {
		String sql = "insert into CONVIDADO (EMAIL, NOME, TELEFONE) values("+convidado+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já há um Convidado com esse Email. Por favor digite outro Email.";
			}else if(aux.equals("ORA-01400")) {
					mesg = "Os campos Email e Nome tem que ser preenchidos.";
			}else if(aux.equals("ORA-12899")) {
					mesg = "Os limites de caracteres dos campos são: Nome - 60; Email - 60; Telefone - 11.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateConvidado(Convidado convidado) throws Exception {
		String sql = "update CONVIDADO set"
				+ convidado.toStringUpdates()
				+ " where EMAIL = '"+convidado.email+"'";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-01747")){
					mesg = "É necessário preencher pelo menos 1 dos campos a alterar.";
			}else if(aux.equals("ORA-12899")) {
					mesg = "Os limites de caracters dos campos são: Telefone - 11.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteConvidado(Convidado convidado) throws Exception {
		String aux = convidado.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from CONVIDADO"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(!telefone.equals("")) {
			res += " TELEFONE = '"+this.telefone+"'";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(!nome.equals("")) {
			res += " NOME = '"+this.nome+"'";
		}
		if(!email.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " EMAIL = '"+this.email+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.email+"','"+this.nome+"','"+this.telefone+"'";
	}
}
