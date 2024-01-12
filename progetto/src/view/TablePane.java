package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TablePane extends JPanel{
	
	private JTable table;
	private TableModel tableModel;
	
	public TablePane(){
		table = new JTable();
		setPreferredSize(new Dimension(900, 400));
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void aggiorna() {
		tableModel.fireTableDataChanged();
		tableModel.fireTableStructureChanged();
	}
	
	public void setModel(TableModel tableModel) {
		this.tableModel = tableModel;
		table.setModel(tableModel);
	}
}
