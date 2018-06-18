package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ingresso {
	private int festFood;
	private int numero;
	private String cpfComprador;
	
	public Ingresso(int festFood, int numero, String cpfComprador) {
		this.festFood = festFood;
		this.numero = numero;
		this.cpfComprador = cpfComprador;
	}
	
	public int getFestFood() {
		return festFood;
	}
	
	public void setFestFood(int festFood) {
		this.festFood = festFood;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getCpfComprador() {
		return cpfComprador;
	}
	
	public void setCpfComprador(String cpfComprador) {
		this.cpfComprador = cpfComprador;
	}
	
	public static ObservableList<Ingresso> tableView(){
		ResultSet res;
		List<Ingresso> list = new ArrayList<Ingresso>();
		String sql="select * from INGRESSO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new Ingresso(res.getInt(1), res.getInt(2), res.getString(3)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void insertIngresso(Ingresso ingresso) {
		String sql = "insert into INGRESSO (FESTFOOD, NUMERO, CPFCOMPRADOR) values("+ingresso+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteEmpresa(Ingresso ingresso) {
		String sql = "delete from INGRESSO"+ingresso.toStringRestritions();
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(festFood != 0) {
			res += " FESTFOOD = "+this.festFood;
		}
		if(numero == 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " NUMERO = "+this.numero;
		}
		if(cpfComprador.compareTo("") != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " CPFCOMPRADOR = '"+this.cpfComprador+"'";
		}
		if(res.compareTo(" where ") == 0)
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return this.festFood+","+this.numero+",'"+this.cpfComprador+"'";
	}
}
