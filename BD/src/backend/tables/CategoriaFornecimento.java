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
	
	public static ObservableList<String> getListaCategoria(){
		ResultSet res;
		List<String> list = new ArrayList<>();
		String sql = "select NOMEREF from CATEGORIAFORNECIMENTO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(res.getString(1));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static void insertCategoriaFornecimento(CategoriaFornecimento categoriaFornecimento) throws Exception {
		String sql = "insert into CATEGORIAFORNECIMENTO (NOMEREF, DESCRICAO) values("+categoriaFornecimento+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já há uma Categoria de Fornecimento com esse nome.Por favor digite outro nome.";
			}else if(aux.equals("ORA-01400")) {
					mesg = "Os campos Nome e Descrição tem que ser preenchidos.";
			}else if(aux.equals("ORA-12899")) {
					mesg = "Os limites de caracters dos campos são: Nome-20 Descrição-140";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateCategoriaFornecimento(CategoriaFornecimento categoriaFornecimento) throws Exception {
		String sql = "update CATEGORIAFORNECIMENTO set"
				+ categoriaFornecimento.toStringUpdates()
				+ " where NOMEREF = '"+categoriaFornecimento.nomeRef+"'";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-01747")){
					mesg = "É necessário preencher pelo menos 1 dos campos a alterar.";
			}else if(aux.equals("ORA-12899")) {
					mesg = "Os limites de caracters dos campos são: Descrição-140";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteCategoriaFornecimento(CategoriaFornecimento categoriaFornecimento) throws Exception {
		String aux = categoriaFornecimento.toStringRestritions();
		if(aux.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from CATEGORIAFORNECIMENTO"+aux;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(descricao.compareTo("") != 0) {
			res += " DESCRICAO = '"+this.descricao+"'";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(nomeRef.compareTo("") != 0) {
			res += " NOMEREF = '"+this.nomeRef+"'";
		}
		if(res.compareTo(" where ") == 0)
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		return "'"+this.nomeRef+"','"+this.descricao+"'";
	}
}
