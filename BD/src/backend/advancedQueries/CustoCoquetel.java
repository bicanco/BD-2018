package backend.advancedQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe de busca avancada custo dos coqueteis com mais de um numero de convidados
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class CustoCoquetel {
	private String nome;
	private String contratante;
	private String data;
	private int convidados;
	private float orcamento;
	
	public CustoCoquetel(String nome, String contratante, String data, int convidados, float orcamento) {
		this.nome = nome;
		this.contratante = contratante;
		this.data = data;
		this.convidados = convidados;
		this.orcamento = orcamento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getContratante() {
		return contratante;
	}
	public void setContratante(String contratante) {
		this.contratante = contratante;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getConvidados() {
		return convidados;
	}
	public void setConvidados(int convidados) {
		this.convidados = convidados;
	}
	public float getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}
	
	public static ObservableList<CustoCoquetel> tableView(int minConv){
		ResultSet res;
		List<CustoCoquetel> list = new ArrayList<CustoCoquetel>();
		String sql ="select F.NOME, F.CONTRATANTE, F.DATA, count(CON.CONVIDADO) as NOCONVIDADOS, COQ.ORCAMENTO " + 
					"from COQUETEL COQ " + 
					"inner join CONVITE CON on COQ.FESTA = CON.COQUETEL " + 
					"inner join FESTA F on F.ID = COQ.FESTA " + 
					"group by F.ID, F.NOME, F.CONTRATANTE, F.DATA, COQ.ORCAMENTO " + 
					"having count(CON.CONVIDADO) >= "+minConv;
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new CustoCoquetel(res.getString(1), res.getString(2), res.getString(3), res.getInt(4), res.getFloat(5)));
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
