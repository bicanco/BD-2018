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
	
	public static void insertConvite(Convite convite) {
		String sql = "insert into CONVITE (CONVIDADO, COQUETEL) values("+convite+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteEmpresa(Convite convite) {
		String sql = "delete from CONVITE"+convite.toStringRestritions();
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
		if(convidado.compareTo("") != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " CONVIDADO = '"+this.convidado+"'";
		}
		if(res.compareTo(" where ") == 0)
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.convidado+"',"+this.coquetel;
	}
}
