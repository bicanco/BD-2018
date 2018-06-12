package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que gerencia a tabela EMPRESA
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class Empresa {
	private String cnpjEmpresa;
	private String nomeEmpresa;
	private String razaoEmpresa;
	private String enderecoEmpresa;
	
	public Empresa(String cnpj, String nomeFantasia, String razaoSocial, String endereco) {
		this.cnpjEmpresa = cnpj;
		this.nomeEmpresa = nomeFantasia;
		this.razaoEmpresa = razaoSocial;
		this.enderecoEmpresa = endereco;
	}

	public static ObservableList<Empresa> TableView(){
		ResultSet res;
		List<Empresa> list = new ArrayList<>();
		try {
			res = ConnectionManager.query("select * from EMPRESA");
			while(res.next()) 
				list.add(new Empresa(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
			
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableArrayList(list);
		} catch (SQLException e) {
			System.out.println();
            throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		return this.cnpjEmpresa+" "+this.enderecoEmpresa+" "+this.nomeEmpresa+" "+this.razaoEmpresa+"\n";
	}
	
}
