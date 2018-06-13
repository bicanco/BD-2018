package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Fornecedora {
	private String cnpj;
	
	public Fornecedora(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public static ObservableList<Fornecedora> tableView(){
		ResultSet res;
		List<Fornecedora> list = new ArrayList<Fornecedora>();
		try {
			res = ConnectionManager.query("select * from FORNECEDORA");
			while(res.next())
				list.add(new Fornecedora(res.getString(1)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
