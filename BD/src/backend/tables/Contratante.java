package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contratante {
	private String cnpj;
	
	public Contratante(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public static ObservableList<Contratante> tableView(){
		ResultSet res;
		List<Contratante> list = new ArrayList<Contratante>();
		try {
			res = ConnectionManager.query("select * from CONTRATANTE");
			while(res.next())
				list.add(new Contratante(res.getString(1)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
