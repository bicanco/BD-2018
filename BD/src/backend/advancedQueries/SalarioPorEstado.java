package backend.advancedQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SalarioPorEstado {
	private String funcao;
	private int quantidade;
	private float mediaSalarial;
	
	public SalarioPorEstado(String funcao, int quantidade, float mediaSalarial) {
		this.funcao = funcao;
		this.quantidade = quantidade;
		this.mediaSalarial = mediaSalarial;
	}
	
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getMediaSalarial() {
		return mediaSalarial;
	}
	public void setMediaSalarial(float mediaSalarial) {
		this.mediaSalarial = mediaSalarial;
	}
	
	public static ObservableList<SalarioPorEstado> tableView(String estado){
		ResultSet res;
		List<SalarioPorEstado> list = new ArrayList<SalarioPorEstado>();
		String sql = "select FUNCAO, count(*) as QUANTIDADE, avg(VALORPORHORA) as MEDIASALARIAL " + 
					 "from FUNCIONARIO " + 
					 "where ESTADO = '"+estado+"' " + 
					 "group by FUNCAO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new SalarioPorEstado(res.getString(1), res.getInt(2), res.getFloat(3)));
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
