package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Festa {
	private int id;
	private String contratante;
	private String data;
	private String nome;
	private String horaInicio;
	private String duracao;
	private String tipoFesta;
	
	public Festa(int id, String contratante, String data, String nome, String horaInicio, String duracao, String tipoFesta) {
		this.id = id;
		this.contratante = contratante;
		this.data = data;
		this.nome = nome;
		this.horaInicio = horaInicio;
		this.duracao = duracao;
		this.tipoFesta = tipoFesta;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getHoraInicio() {
		return horaInicio;
	}
	
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	public String getDuracao() {
		return duracao;
	}
	
	public void setDuracao(String duracao) {
		this.duracao= duracao;
	}
	
	public String getTipoFesta() {
		return tipoFesta;
	}
	
	public void setTipoFesta(String tipoFesta) {
		this.tipoFesta = tipoFesta;
	}
	
	public static ObservableList<Festa> tableView(){
		ResultSet res;
		List<Festa> list = new ArrayList<Festa>();
		String sql="select * from FESTA";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new Festa(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
