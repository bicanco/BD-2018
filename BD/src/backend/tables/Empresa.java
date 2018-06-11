package backend.tables;

import java.sql.ResultSet;
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
	public String enderecoEmpresa;
	public String cnpjEmpresa;
	public String nomeEmpresa;
	public String razaoEmpresa;
	
	public Empresa(String cnpj, String nomeFantasia, String razaoSocial, String endereco) {
		this.cnpjEmpresa = cnpj;
		this.nomeEmpresa = nomeFantasia;
		this.razaoEmpresa = razaoSocial;
		this.enderecoEmpresa = endereco;
	}

	public static ObservableList<Empresa> TableView() throws Exception{
		ResultSet res = ConnectionManager.query("select * from EMPRESA");
		List<Empresa> list = new ArrayList<Empresa>();
		while(res.next())
			list.add(new Empresa(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
		ConnectionManager.closeQuery();
			
		return FXCollections.observableList(list);
	}
}
