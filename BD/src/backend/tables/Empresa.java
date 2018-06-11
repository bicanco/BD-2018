package backend.tables;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import backend.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Empresa {
	private ObservableList<Object> observableList;
	
	public Empresa() {
		try {
			updateTableView();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void updateTableView() throws Exception{
		ResultSet res = ConnectionManager.query("select * from EMPRESA");
		List<Object> list = new ArrayList<Object>();
		while(res.next()) {
			list.add(res.getString(1));
			list.add(res.getString(2));
			list.add(res.getString(3));
			list.add(res.getString(4));
		}
		ConnectionManager.closeQuery();
		
		this.observableList = FXCollections.observableList(list);
	}
	
	public ObservableList<Object> viewTable(){
		return observableList;
	}
}
