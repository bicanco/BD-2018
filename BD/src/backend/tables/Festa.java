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
	
	public static ObservableList<Number> getListaFesta(){
		ResultSet res;
		List<Number> list = new ArrayList<Number>();
		String sql = "select ID from FESTA";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())			
				list.add(res.getInt(1));
				
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
	
	public static void insertFesta(Festa festa) throws Exception {
		String sql = "insert into FESTA (ID, CONTRATANTE, DATA, NOME, HORAINICIO, DURACAO, TIPOFESTA) values("+festa+")";
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-00001")){
					mesg = "Já há uma Festa associada a essa Empresa nessa Data. Por favor selecione outra Empresa e/ou Data.";
			}else if(aux.equals("ORA-01400")) {
					mesg = "Os campos Data, Nome, Horário de Início e Duração tem que ser preenchidos.";
			}else if(aux.equals("ORA-12899")) {
					mesg = "Os limites de caracteres dos campos são: Nome - 60.";
			} else if(aux.equals("ORA-01843") || aux.equals("ORA-01839") || aux.equals("ORA-01847")){
					mesg = "Insira um dia/mês válido.";
			} else if(aux.equals("ORA-01850") || aux.equals("ORA-01851")){
				mesg = "Insira um horário válido.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void updateFesta(Festa festa) throws Exception {
		String sql = "update FESTA set"
				+ festa.toStringUpdates()
				+ " where ID = "+festa.id;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e){
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-01747")){
					mesg = "É necessário preencher pelo menos 1 dos campos a alterar.";
			}else if(aux.equals("ORA-12899")) {
					mesg = "Os limites de caracters dos campos são: Nome - 60.";
			} else if(aux.equals("ORA-01843") || aux.equals("ORA-01839") || aux.equals("ORA-01847")){
					mesg = "Insira um dia/mês válido.";
			} else if(aux.equals("ORA-01850") || aux.equals("ORA-01851")){
					mesg = "Insira um horário válido.";
			}
			throw new Exception(mesg);
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void deleteFesta(Festa festa) throws Exception {
		String param = festa.toStringRestritions();
		if(param.equals(" ")) {
			throw new Exception("É necessário preencher pelo menos 1 dos campos identificadores do registro a remover.");
		}
		String sql = "delete from FESTA"+param;
		try {
			ConnectionManager.query(sql);
			ConnectionManager.closeQuery();
		}catch(SQLException e) {
			String mesg="";
			String aux = e.getMessage().split("[:(). ]")[0];
			if(aux.equals("ORA-01843") || aux.equals("ORA-01839") || aux.equals("ORA-01847")){
					mesg = "Insira um dia/mês válido.";
			} else if(aux.equals("ORA-01850") || aux.equals("ORA-01851")){
					mesg = "Insira um horário válido.";
			}
			throw new Exception(mesg);
		}
	}
	
	private String toStringUpdates() {
		String res = "";
		if(!data.equals("")) {
			res += " DATA = to_date('"+this.data+"','dd/mm/yyyy')";
		}
		if(!nome.equals("")) {
			if(!res.equals(""))
				res += ", ";
			res += " NOME = '"+this.nome+"'";
		}
		if(!horaInicio.equals("")) {
			if(!res.equals(""))
				res += ", ";
			res += " HORAINICIO = to_date('"+this.horaInicio+"','hh:mi')";
		}
		if(!duracao.equals("")) {
			if(!res.equals(""))
				res += ", ";
			res += " DURACAO = to_date('"+this.duracao+"','hh:mi')";
		}
		return res;
	}
	
	private String toStringRestritions() {
		String res = " where ";
		if(!contratante.equals("")) {
			res += " CONTRATANTE = '"+this.contratante+"'";
		}
		if(!data.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " DATA = to_date("+this.data+",'dd/mm/yyyy')";
		}
		if(!nome.equals("")) {
			if(!res.equals(" where "))
				res += " and ";
			res += " NOME = '"+this.nome+"'";
		}
		if(res.equals(" where "))
			res = " ";
		return res;
	}
	
	@Override
	public String toString() {
		String aux = this.id == 0?"null": new Integer(this.id).toString();
		return aux+",'"+this.contratante+"',to_date('"+this.data+"','dd/mm/yyyy'),'"+this.nome+"',to_date('"+this.horaInicio+"','hh24:mi'),to_date('"+this.duracao+"','hh24:mi'),'"+this.tipoFesta+"'";
	}
}
