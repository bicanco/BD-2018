package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que gerencia a tabela COQUETEL
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class Coquetel {
	private int festa;
	private float orcamento;
	private String local;
	private String cidade;
	
	public Coquetel(int festa, float orcamento, String local, String cidade) {
		this.festa = festa;
		this.orcamento = orcamento;
		this.local = local;
		this.cidade = cidade;
	}
	
	public int getFesta() {
		return festa;
	}
	
	public void setFesta(int festa) {
		this.festa = festa;
	}
	
	public float getOrcamento() {
		return orcamento;
	}
	
	public void setOrcamento(int orcamento) {
		this.orcamento = orcamento;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public static ObservableList<Coquetel> tableView(){
		ResultSet res;
		List<Coquetel> list = new ArrayList<Coquetel>();
		String sql="select * from COQUETEL";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new Coquetel(res.getInt(1), res.getFloat(2), res.getString(3), res.getString(4)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaCoquetel(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select F.ID,F.DATA,E.NOMEFANTASIA,E.CNPJ from EMPRESA E, FESTA F, COQUETEL C where F.TIPOFESTA = 'COQUETEL' and F.CONTRATANTE = E.CNPJ and C.FESTA = F.ID";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(res.getInt(1)+" / "+res.getDate(2)+" / "+res.getString(3)+" / "+res.getString(4));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public static ObservableList<String> getListaFestasCoquetel(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select F.ID,F.DATA,E.NOMEFANTASIA,E.CNPJ from EMPRESA E, FESTA F where F.TIPOFESTA = 'COQUETEL' and F.CONTRATANTE = E.CNPJ";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(res.getInt(1)+" / "+res.getDate(2)+" / "+res.getString(3)+" / "+res.getString(4));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public static void insertCoquetel(Coquetel coquetel) throws Exception {
		ResultSet res;
		String sql ="select DATA from FESTA where ID = "+coquetel.festa;
		String date;
		try {
			res = ConnectionManager.query(sql);
			res.next();
			date = res.getString(1);
			ConnectionManager.closeQuery();
			date = date.split(" ")[0];
			sql="select count(*) from FESTA F, COQUETEL C, LOCACAO L where ((C.LOCAL = '"+coquetel.local+"' and C.CIDADE = '"+coquetel.cidade+"' and C.FESTA = F.ID) or (L.NOMELOCAL = '"+coquetel.local+"' and L.CIDADELOCAL = '"+coquetel.cidade+"' and L.FESTFOOD = F.ID)) and F.DATA = to_date('"+date+"','yyyy-mm-dd')";
			res = ConnectionManager.query(sql);
			res.next();
			System.out.println(res.getInt(1));
			if(res.getInt(1) > 0)
				throw new Exception("Esse Local já está ocupado nesse dia");
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		sql = "insert into COQUETEL (FESTA, ORCAMENTO, LOCAL, CIDADE) values("+coquetel+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já foi alocado um Local para esse Coquetel.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
		sql = "call COQUETEL_CALCULAORCAMENTO("+coquetel.festa+")";
		System.out.println(sql);
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static void updateCoquetel(Coquetel coquetel) throws Exception {
		ResultSet res;
		String sql ="select DATA from FESTA where ID = "+coquetel.festa;
		String date;
		try {
			res = ConnectionManager.query(sql);
			res.next();
			date = res.getString(1);
			ConnectionManager.closeQuery();
			date = date.split(" ")[0];
			sql="select count(*) from FESTA F, COQUETEL C, LOCACAO L where ((C.LOCAL = '"+coquetel.local+"' and C.CIDADE = '"+coquetel.cidade+"' and C.FESTA = F.ID) or (L.NOMELOCAL = '"+coquetel.local+"' and L.CIDADELOCAL = '"+coquetel.cidade+"' and L.FESTFOOD = F.ID)) and F.DATA = to_date('"+date+"','yyyy-mm-dd')";
			res = ConnectionManager.query(sql);
			res.next();
			System.out.println(res.getInt(1));
			if(res.getInt(1) > 0)
				throw new Exception("Esse Local já está ocupado nesse dia");
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		sql = "update COQUETEL set"
				+ coquetel.toStringUpdates()
				+ " where FESTA = "+coquetel.festa;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		sql = "call COQUETEL_CALCULAORCAMENTO("+coquetel.festa+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static void deleteCoquetel(Coquetel coquetel) throws Exception {
		String aux = coquetel.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from COQUETEL"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(!local.equals("")) {
			res += " LOCAL = '"+this.local+"', CIDADE = '"+this.cidade+"'";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(festa != 0) {
			res += " FESTA = "+this.festa;
		}
		if(!local.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " LOCAL = '"+this.local+"'";
		}
		if(!cidade.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " CIDADE = '"+this.cidade+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return this.festa+","+this.orcamento+",'"+this.local+"','"+this.cidade+"'";
	}
}
