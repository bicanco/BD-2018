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
}
