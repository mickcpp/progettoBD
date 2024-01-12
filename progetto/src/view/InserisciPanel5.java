package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.result.Field;

public class InserisciPanel5 extends JPanel{

	private JLabel labelGara;
	private JLabel labelVettura;
	
	private JTextField fieldGara;
	private JTextField fieldVettura;
	
	private JButton buttonInserisci;
	
	public InserisciPanel5() {
	
		labelGara = new JLabel("Gara:");
		labelVettura = new JLabel("Vettura:");
		
		fieldGara = new JTextField(15);
		fieldVettura = new JTextField(15);
		
		buttonInserisci = new JButton("Inserisci");
		
		buttonInserisci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fieldGara.getText().isEmpty() || fieldVettura.getText().isEmpty()) {
					new WarningException("Devi inserire tutti i campi!");
				}else {
					int gara = Integer.parseInt(fieldGara.getText());
					int vettura = Integer.parseInt(fieldVettura.getText());
					if(LoginPanel.db.insert5(gara, vettura)) {
						new MessageException("Iscrizione effettuata!");
						fieldGara.setText("");
						fieldVettura.setText("");
					}else {
						new ErrorException("Errore nell'iscrizione!");
					}
				}
			}
		});
		
		fieldVettura.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					buttonInserisci.doClick();
				}
			}
		});
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Iscrizione"));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//RIGA 1: label gara
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.insets.set(0, 0, 4, 15); 
		
		add(labelGara, gbc);
		
		//RIGA 1: field gara
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		gbc.insets.set(0, 0, 4, 50); 
		
		add(fieldGara, gbc);
		
		//RIGA 2: label vettura
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 15); 
		
		add(labelVettura, gbc);
		
		//RIGA 2: field vettura
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 50); 
		
		add(fieldVettura, gbc);
		
		//RIGA 3: button inserisci
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.insets.set(5, 44, 20, 50); 
		gbc.gridwidth = 2;
		
		add(buttonInserisci, gbc);
		
	}
	
}