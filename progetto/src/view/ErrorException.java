package view;

import javax.swing.JOptionPane;

public class ErrorException extends RuntimeException{

	public ErrorException(String msg) {
		new JOptionPane().showMessageDialog(null, msg, "Errore", JOptionPane.ERROR_MESSAGE);
	}
	
}
