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
	
	public static void insertContratoFestFood(ContratoFestFood contratoFestFood) throws Exception {
		ResultSet res;
		String sql ="select DATA from FESTA where ID = "+contratoFestFood.festFood;
		String date;
		try {
			res = ConnectionManager.query(sql);
			res.next();
			date = res.getString(1);
			ConnectionManager.closeQuery();
			date = date.split(" ")[0];
			sql="select count(*) from FESTA F, CONTRATOCOQUETEL CC, CONTRATOFESTFOOD CF where ((CC.FUNCIONARIO = '"+contratoFestFood.seguranca+"' and F.ID = CC.COQUETEL) or(CF.SEGURANCA = '"+contratoFestFood.seguranca+"' and F.ID = CF.FESTFOOD)) and F.DATA = to_date('"+date+"','yyyy-mm-dd')";
			res = ConnectionManager.query(sql);
			res.next();
			if(res.getInt(1) > 0)
				throw new Exception("Esse Funcionario já trabalha nesse dia");
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		sql = "insert into CONTRATOFESTFOOD (FESTFOOD, SEGURANCA, HORASTRABALHADAS, VALORPAGO) values("+contratoFestFood+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Esse Segurança já está associado a esse FestFood. Por favor selecione outro Segurança e/ou FestFood.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateContratoFestFood(ContratoFestFood contratoFestFood) throws Exception {
		String sql = "update CONTRATOFESTFOOD set"
				+ contratoFestFood.toStringUpdates()
				+ " where FESTFOOD = "+contratoFestFood.festFood
				+ " and SEGURANCA = '"+contratoFestFood.seguranca+"'";
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
	
	public static void deleteContratoFestFood(ContratoFestFood contratoFestFood) throws Exception {
		String aux = contratoFestFood.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from CONTRATOFESTFOOD"+aux;
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
		if(festFood != 0) {
			res += " FESTFOOD = "+this.festFood;
		}
		if(!seguranca.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " SEGURANCA = '"+this.seguranca+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		String aux = this.valorPago == 0?"null":new Float(this.valorPago).toString();
		return this.festFood+",'"+this.seguranca+"',"+this.horasTrabalhadas+","+aux;
	}
}
