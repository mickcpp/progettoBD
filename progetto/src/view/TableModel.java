package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{

	private ResultSet rs;
	private String[] nomiColonne;
	
	public TableModel(ResultSet rs, String[] nomiColonne) {
		this.rs = rs;
		this.nomiColonne = nomiColonne;
	}
	
	@Override
	public String getColumnName(int column) {
		return nomiColonne[column];
	}
	
	@Override
	public int getRowCount() {
		if (rs == null) {
	        return 0;
	    }

	    try {
	        rs.last();  					// Sposta il cursore all'ultima riga
	        int numRighe = rs.getRow();  	// Ottiene il numero di righe
	        rs.beforeFirst();  				// Riporta il cursore alla prima riga
	        return numRighe;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0;
	    }
	}

	@Override
	public int getColumnCount() {
		if (rs == null) {
	        return 0;
	    }
		int numCampi = 0;
		try {
			numCampi = rs.getMetaData().getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numCampi;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		try {
			rs.absolute(rowIndex + 1);
			
	        // Estrae i dati dalla colonna specificata
	        Object value = rs.getObject(columnIndex + 1);

	        // Restituisce il valore estratto
	        return value;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
}
