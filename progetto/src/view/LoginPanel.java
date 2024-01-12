package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
	
	private JLabel labelUrl, labelUser, labelPassword;
	private JTextField fieldUrl, fieldUser;
	private JPasswordField fieldPassword;
	private JButton loginButton;
	public static Database db;
	private Frame frame;
//	private String dbUrl = "jdbc:mysql://localhost:3306/campionato";
	
	public LoginPanel() {
		
		setLayout(new GridBagLayout());
		
		labelUrl = new JLabel("URL database:");
		fieldUrl = new JTextField(15);
		
		labelUser = new JLabel("Username:");
		fieldUser = new JTextField(15);
		
		labelPassword = new JLabel("Password:");
		fieldPassword = new JPasswordField(15);
		
		loginButton = new JButton("CONNETTI");
		
		fieldUrl.setText("jdbc:mysql://localhost/campionato");
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!fieldUrl.getText().isEmpty() && !fieldUser.getText().isEmpty() && !fieldPassword.getText().isEmpty()) {
					String url = fieldUrl.getText();
					String username = fieldUser.getText();
					String password = fieldPassword.getText();
					
					db = new Database(url, username, password);
					
					if(db.isConnected()) {
						frame.switchToInterrogaPanel();
						frame.setTitle("Campionato");
						frame.setMinimumSize(new Dimension(700, 300));
					}else {
						throw new ErrorException("I dati inseriti non sono corretti!");
					}
				}else {
					throw new WarningException("Devi inserire tutti i campi!");
				}
			}
		});
		
		fieldPassword.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginButton.doClick();
				}
			}
		});
		
		GridBagConstraints gbc = new GridBagConstraints();
			    
		//RIGA 1: label URL
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets.set(-20, 0, 5, 15); 
		
		add(labelUrl, gbc);
		
		//RIGA 1: field URL
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets.set(-20, 0, 5, 0);
		
		add(fieldUrl, gbc);
		
		//RIGA 2: label user
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets.set(0, 0, 5, 15);
		
		add(labelUser, gbc);
		
		//RIGA 2: field user
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets.set(0, 0, 5, 0);
		
		add(fieldUser, gbc);
		
		//RIGA 3: label password
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets.set(0, 0, 5, 15);
		
		add(labelPassword, gbc);
		
		//RIGA 3: field password
		gbc.gridx = 1;
		gbc.gridy = 2;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets.set(0, 0, 5, 0);
		
		add(fieldPassword, gbc);
		
		//RIGA 4: login button
		gbc.gridx = 0;
		gbc.gridy = 3;
	
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets.set(15, 0, 5, 0);
		
		add(loginButton, gbc);
		
	}
	
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
}
