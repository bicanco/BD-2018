package backend.advancedQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LotesLocacao {
	private int numero;
	private float preco;
	private float largura;
	private float comprimento;
	private String nomeFantasia;
	private String fornecedora;
	
	public LotesLocacao(int numero, float preco, float largura, float comprimento, String nomeFantasia, String fornecedora) {
		this.setNumero(numero);
		this.setPreco(preco);
		this.setLargura(largura);
		this.setComprimento(comprimento);
		this.setNomeFantasia(nomeFantasia);
		this.setFornecedora(fornecedora);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getFornecedora() {
		return fornecedora;
	}

	public void setFornecedora(String fornecedora) {
		this.fornecedora = fornecedora;
	}
	
	public static ObservableList<LotesLocacao> tableView(int locacao){
		ResultSet res;
		List<LotesLocacao> list = new ArrayList<LotesLocacao>();
		String sql = "select LT.NUMERO, LT.PRECO, LT.LARGURA, LT.COMPRIMENTO, EM.NOMEFANTASIA, LT.FORNECEDORA " + 
					 "from LOTE LT " + 
					 "left join EMPRESA EM on LT.FORNECEDORA = EM.CNPJ " + 
					 "where LOCACAO = "+locacao;
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new LotesLocacao(res.getInt(1), res.getFloat(2), res.getFloat(3), res.getFloat(4), res.getString(5), res.getString(6)));
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
