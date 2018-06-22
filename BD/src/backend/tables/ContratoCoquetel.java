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
		String sql="select * from CONTRATOCOQUETEL";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new ContratoCoquetel(res.getInt(1), res.getString(2), res.getInt(3), res.getFloat(4)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static void insertContratoCoquetel(ContratoCoquetel contratoCoquetel) {
		String sql = "insert into CONTRATOCOQUETEL (COQUETEL, FUNCIONARIO, HORASTRABALHADAS, VALORPAGO) values("+contratoCoquetel+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateContratoCoquetel(ContratoCoquetel contratoCoquetel) {
		String sql = "update CONTRATOCOQUETEL set"
				+ contratoCoquetel.toStringUpdates()
				+ " where COQUETEL = "+contratoCoquetel.coquetel
				+ " and FUNCIONARIO = '"+contratoCoquetel.funcionario+"'";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteEmpresa(ContratoCoquetel contratoCoquetel) {
		String sql = "delete from CONTRATOCOQUETEL"+contratoCoquetel.toStringRestritions();
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(horasTrabalhadas != 0) {
			res += " HORASTRABALHADAS = "+this.horasTrabalhadas;
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(coquetel != 0) {
			res += " COQUETEL = "+this.coquetel;
		}
		if(funcionario.compareTo("") != 0) {
			if(res.compareTo(" where ") != 0)
				res += " and ";
			res += " FUNCIONARIO = '"+this.funcionario+"'";
		}
		if(res.compareTo(" where ") == 0)
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return this.coquetel+",'"+this.funcionario+"',"+this.horasTrabalhadas+","+this.valorPago;
	}
}
