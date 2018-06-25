package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que gerencia a tabela LOCACAO
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class Locacao {
	private int id;
	private int festFood;
	private String nomeLocal;
	private String cidadeLocal;
	
	public Locacao(int id, int festFood, String nomeLocal, String cidadeLocal) {
		this.id = id;
		this.festFood= festFood;
		this.nomeLocal = nomeLocal;
		this.cidadeLocal = cidadeLocal;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFestFood() {
		return festFood;
	}
	
	public void setFestFood(int festFood) {
		this.festFood = festFood;
	}
	
	public String getNomeLocal() {
		return nomeLocal;
	}
	
	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}
	
	public String getCidadeLocal() {
		return cidadeLocal;
	}
	
	public void setCidadeLocal(String cidadeLocal) {
		this.cidadeLocal = cidadeLocal;
	}
	
	public static ObservableList<Locacao> tableView(){
		ResultSet res;
		List<Locacao> list = new ArrayList<Locacao>();
		String sql="select * from LOCACAO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new Locacao(res.getInt(1),res.getInt(2),res.getString(3), res.getString(4)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaLocacao(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select LO.ID,E.CNPJ, E.NOMEFANTASIA, F.DATA, L.NOME, L.CIDADE from EMPRESA E, FESTA F, LOCAL L, LOCACAO LO where F.TIPOFESTA = 'FESTFOOD' and F.CONTRATANTE = E.CNPJ and LO.FESTFOOD = F.ID and LO.NOMELOCAL = L.NOME and LO.CIDADELOCAL = L.CIDADE";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(res.getInt(1)+" / "+res.getString(2)+" / "+res.getString(3)+" / "+res.getDate(4)+" / "+res.getString(5)+" / "+res.getString(6));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public static ObservableList<Number> getListaId(){
		ResultSet res;
		List<Number> list = new ArrayList<Number>();
		String sql = "select ID from LOCACAO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(res.getInt(1));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static void insertLocacao(Locacao locacao) throws Exception {
		ResultSet res;
		String sql ="select DATA from FESTA where ID = "+locacao.festFood;
		String date;
		try {
			res = ConnectionManager.query(sql);
			res.next();
			date = res.getString(1);
			ConnectionManager.closeQuery();
			date = date.split(" ")[0];
			sql="select count(*) from FESTA F, COQUETEL C, LOCACAO L where ((C.LOCAL = '"+locacao.nomeLocal+"' and C.CIDADE = '"+locacao.cidadeLocal+"' and C.FESTA = F.ID) or (L.NOMELOCAL = '"+locacao.nomeLocal+"' and L.CIDADELOCAL = '"+locacao.cidadeLocal+"' and L.FESTFOOD = F.ID)) and F.DATA = to_date('"+date+"','yyyy-mm-dd')";
			res = ConnectionManager.query(sql);
			res.next();
			System.out.println(res.getInt(1));
			if(res.getInt(1) > 0)
				throw new Exception("Esse Local já está ocupado nesse dia");
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		sql = "insert into LOCACAO (ID, FESTFOOD, NOMELOCAL, CIDADELOCAL) values("+locacao+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já foi alocado um Local para esse FestFood.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateLocacao(Locacao locacao) throws Exception {
		ResultSet res;
		String sql ="select F.DATA from FESTA F, LOCACAO L where L.ID = "+locacao.id+" and L.FESTFOOD = F.ID";
		String date;
		try {
			res = ConnectionManager.query(sql);
			res.next();
			date = res.getString(1);
			ConnectionManager.closeQuery();
			date = date.split(" ")[0];
			sql="select count(*) from FESTA F, COQUETEL C, LOCACAO L where ((C.LOCAL = '"+locacao.nomeLocal+"' and C.CIDADE = '"+locacao.cidadeLocal+"' and C.FESTA = F.ID) or (L.NOMELOCAL = '"+locacao.nomeLocal+"' and L.CIDADELOCAL = '"+locacao.cidadeLocal+"' and L.FESTFOOD = F.ID)) and F.DATA = to_date('"+date+"','yyyy-mm-dd')";
			res = ConnectionManager.query(sql);
			res.next();
			System.out.println(res.getInt(1));
			if(res.getInt(1) > 0)
				throw new Exception("Esse Local já está ocupado nesse dia");
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		sql = "update LOCACAO set"
				+ locacao.toStringUpdates()
				+ " where ID = "+locacao.id;
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
	
	public static void deleteLocacao(Locacao locacao) throws Exception {
		String aux = locacao.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from LOCACAO"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
	if(!nomeLocal.equals("") && !cidadeLocal.equals("")) {
			res += " NOMELOCAL = '"+this.nomeLocal+"',"
				+ "CIDADELOCAL = '"+this.cidadeLocal+"'";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(festFood != 0) {
			res += " FESTFOOD = "+this.festFood;
		}
		if(!nomeLocal.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " NOMELOCAL = '"+this.nomeLocal+"'";
		}
		if(!cidadeLocal.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " CIDADELOCAL = '"+this.cidadeLocal+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		String aux = this.id == 0?"null": new Integer(this.id).toString();
		return aux+","+this.festFood+",'"+this.nomeLocal+"','"+this.cidadeLocal+"'";
	}
}
