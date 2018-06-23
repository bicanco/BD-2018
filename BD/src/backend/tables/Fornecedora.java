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
		String sql="select * from FORNECEDORA";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new Fornecedora(res.getString(1)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaFornecedora(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select F.CNPJ,E.NOMEFANTASIA from FORNECEDORA F, EMPRESA E where E.CNPJ = F.CNPJ";
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
	
	public static void insertFornecedora(Fornecedora fornecedora) {
		String sql = "insert into FORNECEDORA (CNPJ) values("+fornecedora+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteFornecedora(Fornecedora fornecedora) throws Exception {
		String aux = fornecedora.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from FORNECEDORA"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(!cnpj.equals("")) {
			res += " CNPJ = '"+this.cnpj+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.cnpj+"'";
	}
}
