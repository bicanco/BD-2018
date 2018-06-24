package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Convite {
	private String convidado;
	private int coquetel;
	
	public Convite(String convidado, int coquetel) {
		this.convidado = convidado;
		this.coquetel = coquetel;
	}
	
	public String getConvidado() {
		return convidado;
	}
	
	public void setConvidado(String convidado) {
		this.convidado = convidado;
	}
	
	public int getCoquetel() {
		return coquetel;
	}
	
	public void setCoquetel(int coquetel) {
		this.coquetel = coquetel;
	}
	
	public static ObservableList<Convite> tableView(){
		ResultSet res;
		List<Convite> list = new ArrayList<Convite>();
		String sql="select * from CONVITE";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new Convite(res.getString(1), res.getInt(2)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static void insertConvite(Convite convite) throws Exception {
		String sql = "insert into CONVITE (CONVIDADO, COQUETEL) values("+convite+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já há um Convite para essa Convidado nesse Coquetel. Por favor selecione outro Convidado e/ou Coquetel.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteConvite(Convite convite) throws Exception {
		String aux = convite.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from CONVITE"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(coquetel != 0) {
			res += " COQUETEL = "+this.coquetel;
		}
		if(!convidado.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " CONVIDADO = '"+this.convidado+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.convidado+"',"+this.coquetel;
	}
}
