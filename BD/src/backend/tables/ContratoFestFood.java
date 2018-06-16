package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContratoFestFood {
	private int festFood;
	private String seguranca;
	private int horasTrabalhadas;
	private float valorPago;
	
	public ContratoFestFood(int festFood, String seguranca, int horasTrabalhadas, float valorPago) {
		this.festFood = festFood;
		this.seguranca = seguranca;
		this.horasTrabalhadas = horasTrabalhadas;
		this.valorPago = valorPago;
	}
	
	public int getFestFood() {
		return festFood;
	}
	
	public void setFestFood(int festFood) {
		this.festFood = festFood;
	}
	
	public String getSeguranca() {
		return seguranca;
	}
	
	public void setSeguranca(String seguranca) {
		this.seguranca = seguranca;
	}
	
	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	public float getValorPago() {
		return valorPago;
	}
	
	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}
	
	public static ObservableList<ContratoFestFood> tableView(){
		ResultSet res;
		List<ContratoFestFood> list = new ArrayList<ContratoFestFood>();
		String sql="select * from CONTRATOFESTFOOD";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new ContratoFestFood(res.getInt(1), res.getString(2), res.getInt(3), res.getFloat(4)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
}
