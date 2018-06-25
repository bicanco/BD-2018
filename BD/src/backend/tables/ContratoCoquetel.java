package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que gerencia a tabela CONTRATOCOQUETEL
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
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
	
	public static void insertContratoCoquetel(ContratoCoquetel contratoCoquetel) throws Exception {
		ResultSet res;
		String sql ="select DATA from FESTA where ID = "+contratoCoquetel.coquetel;
		String date;
		try {
			res = ConnectionManager.query(sql);
			res.next();
			date = res.getString(1);
			ConnectionManager.closeQuery();
			date = date.split(" ")[0];
			sql="select count(*) from FESTA F, CONTRATOCOQUETEL CC, CONTRATOFESTFOOD CF where ((CC.FUNCIONARIO = '"+contratoCoquetel.funcionario+"' and F.ID = CC.COQUETEL) or(CF.SEGURANCA = '"+contratoCoquetel.funcionario+"' and F.ID = CF.FESTFOOD)) and F.DATA = to_date('"+date+"','yyyy-mm-dd')";
			res = ConnectionManager.query(sql);
			res.next();
			if(res.getInt(1) > 0)
				throw new Exception("Esse Funcionario já trabalha nesse dia");
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		sql = "insert into CONTRATOCOQUETEL (COQUETEL, FUNCIONARIO, HORASTRABALHADAS, VALORPAGO) values("+contratoCoquetel+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Esse Funcionário já está associado a esse Coquetel. Por favor selecione outro Funcionário e/ou Coquetel.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
		sql = "call COQUETEL_CALCULAORCAMENTO("+contratoCoquetel.coquetel+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static void updateContratoCoquetel(ContratoCoquetel contratoCoquetel) throws Exception {
		String sql = "update CONTRATOCOQUETEL set"
				+ contratoCoquetel.toStringUpdates()
				+ " where COQUETEL = "+contratoCoquetel.coquetel
				+ " and FUNCIONARIO = '"+contratoCoquetel.funcionario+"'";
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
		sql = "call COQUETEL_CALCULAORCAMENTO("+contratoCoquetel.coquetel+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static void deleteContratoCoquetel(ContratoCoquetel contratoCoquetel) throws Exception {
		String aux = contratoCoquetel.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher os dois campos identificadores do registro a remover.");
		}
		String sql = "delete from CONTRATOCOQUETEL"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		sql = "call COQUETEL_CALCULAORCAMENTO("+contratoCoquetel.coquetel+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
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
		}else {
			res = " ";
		}
		if(!funcionario.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " FUNCIONARIO = '"+this.funcionario+"'";
		}else {
			res = " ";
		}
		return res;
	}
	
	@Override
	public String toString() {
		String aux = this.valorPago == 0?"null":new Float(this.valorPago).toString();
		return this.coquetel+",'"+this.funcionario+"',"+this.horasTrabalhadas+","+aux;
	}
}
