package backend.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Funcionario {
	private String cpf;
	private String rg;
	private String estado;
	private String nome;
	private String cidade;
	private String rua;
	private int numero;
	private String email;
	private String telResidencial;
	private String telCelular;
	private float valorPorHora;
	private String funcao;
	
	public Funcionario(String cpf, String rg, String estado, String nome, String cidade, String rua, int numero, String email, String telResidencial, String telCelular, float valorPorHora, String funcao) {
		this.cpf = cpf;
		this.rg = rg;
		this.estado = estado;
		this.nome = nome;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
		this.email = email;
		this.telResidencial = telResidencial;
		this.telCelular = telCelular;
		this.valorPorHora = valorPorHora;
		this.funcao = funcao;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelResidencial() {
		return telResidencial;
	}
	
	public void setTelResidencial(String telResidencial) {
		this.telResidencial = telResidencial;
	}
	
	public String getTelCelular() {
		return telCelular;
	}
	
	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}
	
	public float getValorPorHora() {
		return valorPorHora;
	}
	
	public void setValorPorHora(float valorPorHora) {
		this.valorPorHora = valorPorHora;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public static ObservableList<Funcionario> tableView(){
		ResultSet res;
		List<Funcionario> list = new ArrayList<Funcionario>();
		String sql="select * from FUNCIONARIO";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new Funcionario(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getString(9),res.getString(10),res.getFloat(11),res.getString(12)));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ObservableList<String> getListaFuncionario(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select F.NOME,F.CPF,F.FUNCAO from FUNCIONARIO F";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(res.getString(1)+" / "+res.getString(2)+" / "+res.getString(3));
			res.close();
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public static ObservableList<String> getListaSeguranca(){
		ResultSet res;
		List<String> list = new ArrayList<String>();
		String sql="select F.NOME,F.CPF from FUNCIONARIO F";
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
	
	@Override
	public String toString() {
		return "'"+this.cpf+"','"+this.rg+"','"+this.estado+"','"+this.nome+"','"+this.cidade+"','"+this.rua+"',"+this.numero+",'"+this.email+"','"+this.telResidencial+"','"+this.telCelular+"',"+this.valorPorHora+",'"+this.funcao+"'";
	}
}
