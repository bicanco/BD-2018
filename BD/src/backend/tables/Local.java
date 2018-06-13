package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Local {
	private String local;
	private String cidade;
	private String estado;
	private String rua;
	private int numero;
	private int maxFrequentadores;
	private String possuiAbertura;
	private float diariaLocacao;
	
	public Local(String local, String cidade, String estado, String rua, int numero, int maxFrequentadores, String possuiAbertura, float diariaLocacao) {
		this.local = local;
		this.cidade = cidade;
		this.estado = estado;
		this.rua = rua;
		this.numero = numero;
		this.maxFrequentadores = maxFrequentadores;
		this.possuiAbertura = possuiAbertura;
		this.diariaLocacao = diariaLocacao;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setId(String local) {
		this.local = local;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getMaxFrequentadores() {
		return maxFrequentadores;
	}
	
	public void setMaxFrequentadores(int maxFrequentadores) {
		this.maxFrequentadores = maxFrequentadores;
	}
	
	public String getPossuiAbertura() {
		return possuiAbertura;
	}
	
	public void setPossuiAbertura(String possuiAbertura) {
		this.possuiAbertura = possuiAbertura;
	}
	
	public float getDiariaLocacao() {
		return diariaLocacao;
	}
	
	public void setDiariaLocacao(float diariaLocacao) {
		this.diariaLocacao = diariaLocacao;
	}
	
	public ObservableList<Local> tableView(){
		ResultSet res;
		List<Local> list = new ArrayList<Local>();
		try {
			res = ConnectionManager.query("select * from LOCAL");
			while(res.next())
				list.add(new Local(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6),res.getString(7),res.getFloat(8)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
