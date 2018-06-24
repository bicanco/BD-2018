package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Brinde {
	private int coquetel;
	private String nome;
	private String descricao;
	
	public Brinde(int coquetel, String nome, String descricao) {
		this.coquetel = coquetel;
		this.nome = nome;
		this.descricao = descricao;
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static ObservableList<Brinde> tableView(){
		ResultSet res;
		List<Brinde> list = new ArrayList<Brinde>();
		String sql ="select * from BRINDE";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new Brinde(res.getInt(1), res.getString(2), res.getString(3)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static void insertBrinde(Brinde brinde) throws Exception {
		String sql = "insert into BRINDE (COQUETEL, NOME, DESCRICAO) values("+brinde+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já há um brinde com esse nome associado a esse coquetel. Por favor selecione outro coquetel e/ou nome";
			}else if(aux.equals("ORA-01400")) {
					mesg = "Os campos Nome e Descrição devem ser preenchidos.";
			}else if(aux.equals("ORA-12899")) {
					mesg ="Os limites de caracters dos campos são: Nome-30 Descrição-60";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateBrinde(Brinde brinde) throws Exception {
		String sql = "update BRINDE set"
				+ brinde.toStringUpdates()
				+ " where COQUETEL = "+brinde.coquetel
				+ "and NOME ='"+brinde.nome+"'";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-01747")){
					mesg = "É necessário preencher pelo menos 1 dos campos a alterar.";
			}else if(aux.equals("ORA-12899")) {
				mesg ="Os limites de caracters dos campos são: Descrição-60";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteBrinde(Brinde brinde) throws Exception {
		String aux = brinde.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from BRINDE"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(!descricao.equals("")) {
			res += " DESCRICAO = '"+this.descricao+"'";
		}
		return res;
	}
	
	
	private String toStringRestritions() {
		String res = " where ";
		if(coquetel != 0) {
			res += " COQUETEL = "+this.coquetel;
		}
		if(!nome.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " NOME = '"+this.nome+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return this.coquetel+",'"+this.nome+"','"+this.descricao+"'";
	}
}
