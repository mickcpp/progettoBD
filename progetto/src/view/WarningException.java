package view;

import javax.swing.JOptionPane;

public class WarningException extends RuntimeException{
	
	public WarningException(String msg) {
		new JOptionPane().showMessageDialog(null, msg, "Errore", JOptionPane.WARNING_MESSAGE);
	}
	
}
