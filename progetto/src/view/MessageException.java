package view;

import javax.swing.JOptionPane;

public class MessageException {

	public MessageException(String msg) {
		new JOptionPane().showMessageDialog(null, msg, "", JOptionPane.INFORMATION_MESSAGE);
	}
}
