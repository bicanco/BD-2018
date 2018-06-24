package backend.advancedQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PagamentoFuncionario {
	private String nome;
	private String data;
	private String contratante;
	private String tipoFesta;
	private float valorpago;
	
	public PagamentoFuncionario(String nome, String data, String contratante, String tipoFesta, float valorpago) {
		this.nome = nome;
		this.data = data;
		this.contratante = contratante;
		this.tipoFesta = tipoFesta;
		this.valorpago = valorpago;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getContratante() {
		return contratante;
	}
	public void setContratante(String contratante) {
		this.contratante = contratante;
	}
	public String getTipoFesta() {
		return tipoFesta;
	}
	public void setTipoFesta(String tipoFesta) {
		this.tipoFesta = tipoFesta;
	}
	public float getValorpago() {
		return valorpago;
	}
	public void setValorpago(float valorpago) {
		this.valorpago = valorpago;
	}
	
	public static ObservableList<PagamentoFuncionario> viewTable(String cpfFuncionario, String dataInic, String dataMax){
		ResultSet res;
		List<PagamentoFuncionario> list = new ArrayList<PagamentoFuncionario>();
		String sql = "select F.NOME, F.DATA, F.CONTRATANTE, F.TIPOFESTA, C.VALORPAGO " + 
					 "from FESTA F, CONTRATOCOQUETEL C " + 
					 "where F.ID = C.COQUETEL " + 
					 "and C.FUNCIONARIO = '"+cpfFuncionario+"' "+ 
					 "and F.DATA >= to_date('"+dataInic+"', 'dd/mm/yyyy') " + 
					 "and F.DATA <= to_date('"+dataMax+"', 'dd/mm/yyyy') " + 
					 "union "+ 
					 "select F.NOME, F.DATA, F.CONTRATANTE, F.TIPOFESTA, C.VALORPAGO " + 
					 "from FESTA F, CONTRATOFESTFOOD C " + 
					 "where F.ID = C.FESTFOOD " + 
					 "and C.SEGURANCA = '"+cpfFuncionario+"' " + 
					 "and F.DATA >= to_date('"+dataInic+"', 'dd/mm/yyyy') " + 
					 "and F.DATA <= to_date('"+dataMax+"', 'dd/mm/yyyy')";
		try{
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new PagamentoFuncionario(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getFloat(5)));
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
