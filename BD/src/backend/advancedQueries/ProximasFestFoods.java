package backend.advancedQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProximasFestFoods {
	private String nome;
	private String data;
	private String contratante;
	private int totalLotes;
	private int lotesVendidos;
	private int ingressosVendidos;

	public ProximasFestFoods(String nome, String data, String contratante, int totalLotes, int lotesVendidos, int ingressosVendidos) {
		this.nome = nome;
		this.data = data;
		this.contratante = contratante;
		this.totalLotes = totalLotes;
		this.lotesVendidos = lotesVendidos;
		this.ingressosVendidos = ingressosVendidos;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getContratante() {
		return contratante;
	}
	public void setContratante(String contratante) {
		this.contratante = contratante;
	}
	public int getTotalLotes() {
		return totalLotes;
	}
	public void setTotalLotes(int totalLotes) {
		this.totalLotes = totalLotes;
	}
	public int getLotesVendidos() {
		return lotesVendidos;
	}
	public void setLotesVendidos(int lotesVendidos) {
		this.lotesVendidos = lotesVendidos;
	}
	public int getIngressosVendidos() {
		return ingressosVendidos;
	}
	public void setIngressosVendidos(int ingressosVendidos) {
		this.ingressosVendidos = ingressosVendidos;
	}
	
	public static ObservableList<ProximasFestFoods> tableView(){
		ResultSet res;
		List<ProximasFestFoods> list = new ArrayList<ProximasFestFoods>();
		String sql = "with " + 
					 "QING as " + 
				     "(select FESTFOOD, count(*) as INGRESSOSVENDIDOS " + 
				     "from INGRESSO " + 
				     "group by FESTFOOD), " + 
				     "QLOTE as " + 
				     "(select LOCA.FESTFOOD, count(LOTE.NUMERO) as TOTALLOTES, count(LOTE.FORNECEDORA) as LOTESVENDIDOS " + 
				     "from LOCACAO LOCA, LOTE " + 
				     "where LOCA.ID = LOTE.LOCACAO " + 
				     "group by LOCA.FESTFOOD) " + 
				     "select F.NOME, F.DATA, F.CONTRATANTE, QLOTE.TOTALLOTES, QLOTE.LOTESVENDIDOS, QING.INGRESSOSVENDIDOS " + 
				     "from FESTA F, FESTFOOD FF, QING, QLOTE " + 
				     "where F.ID = FF.FESTA " + 
				     "and FF.FESTA = QING.FESTFOOD " + 
				     "and QING.FESTFOOD = QLOTE.FESTFOOD";
		try {
			res = ConnectionManager.query(sql);
			while(res.next())
				list.add(new ProximasFestFoods(res.getString(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5), res.getInt(6)));
			ConnectionManager.closeQuery();
			
			return FXCollections.observableList(list);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
