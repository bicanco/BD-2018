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
		String sql="select * from CONTRATANTE";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new Contratante(res.getString(1)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaContratante(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select C.CNPJ,E.NOMEFANTASIA from CONTRATANTE C, EMPRESA E where C.CNPJ = E.CNPJ";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(res.getString(1)+" / "+res.getString(2));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public static void insertContratante(Contratante contratante) {
		String sql = "insert into CONTRATANTE (CNPJ) values("+contratante+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	
	@Override
	public String toString() {
		return "'"+this.cnpj+"'";
	}
}
