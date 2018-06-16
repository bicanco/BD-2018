package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContratoCoquetel {
	private int coquetel;
	private String funcionario;
	private int horasTrabalhadas;
	private float valorPago;
	
	public ContratoCoquetel(int coquetel, String funcionario, int horasTrabalhadas, float valorPago) {
		this.coquetel = coquetel;
		this.funcionario = funcionario;
		this.horasTrabalhadas = horasTrabalhadas;
		this.valorPago = valorPago;
	}
	
	public int getCoquetel() {
		return coquetel;
	}
	
	public void setCoquetel(int coquetel) {
		this.coquetel = coquetel;
	}
	
	public String getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
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
	
	public static ObservableList<ContratoCoquetel> tableView(){
		ResultSet res;
		List<ContratoCoquetel> list = new ArrayList<ContratoCoquetel>();
		try {
			res = ConnectionManager.query("select * from CONTRATOCOQUETEL");
			while(res.next())			
				list.add(new ContratoCoquetel(res.getInt(1), res.getString(2), res.getInt(3), res.getFloat(4)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
}
