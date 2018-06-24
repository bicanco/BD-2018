package backend.advancedQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FaixaPrecoFrequente {
	private String nomeFantasia;
	private String cnpj;
	private String faixaPreco;
	
	public FaixaPrecoFrequente(String nomeFantasia, String cnpj, String faixaPreco) {
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.faixaPreco = faixaPreco;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getFaixaPreco() {
		return faixaPreco;
	}
	public void setFaixaPreco(String faixaPreco) {
		this.faixaPreco = faixaPreco;
	}
	
	public static ObservableList<FaixaPrecoFrequente> tableView(String categoria){
		ResultSet res;
		List<FaixaPrecoFrequente> list = new ArrayList<FaixaPrecoFrequente>();
		String sql = "select E.NOMEFANTASIA, F.CNPJ, ATR.FAIXAPRECO " + 
					 "from FORNECEDORA F, ATRIBUICAOCATEGORIA ATR, EMPRESA E " + 
					 "where E.CNPJ = F.CNPJ " + 
					 "and F.CNPJ = ATR.FORNECEDORA " + 
					 "and ATR.CATEGORIA = '"+categoria+"' " + 
					 "and ATR.FAIXAPRECO = " + 
				     "(select STATS_MODE(FAIXAPRECO) from ATRIBUICAOCATEGORIA where CATEGORIA = '"+categoria+"')";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new FaixaPrecoFrequente(res.getString(1), res.getString(2), res.getString(3)));
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
