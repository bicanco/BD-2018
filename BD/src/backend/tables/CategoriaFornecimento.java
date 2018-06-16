package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategoriaFornecimento {
	private String nomeRef;
	private String descricao;
	
	public CategoriaFornecimento(String nomeRef, String descricao) {
		this.nomeRef = nomeRef;
		this.descricao = descricao;
	}
	
	public String getNomeRef() {
		return nomeRef;
	}
	
	public void setNomeRef(String nomeRef) {
		this.nomeRef = nomeRef;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static ObservableList<CategoriaFornecimento> tableView(){
		ResultSet res;
		List<CategoriaFornecimento> list = new ArrayList<CategoriaFornecimento>();
		String sql="select * from CATEGORIAFORNECIMENTO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(new CategoriaFornecimento(res.getString(1), res.getString(2)));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static void insertCategoriaFornecimento(CategoriaFornecimento categoriaFornecimento) {
		String sql = "insert into CATEGORIAFORNECIMENTO (NOMEREF, DESCRICAO) values("+categoriaFornecimento+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	@Override
	public String toString() {
		return "'"+this.nomeRef+"','"+this.descricao+"'";
	}
}
