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

public class InserisciPanel1 extends JPanel{

	private JLabel labelNome;
	private JLabel labelSede;
	
	private JTextField fieldNome;
	private JTextField fieldSede;
	
	private JButton buttonInserisci;
	
	public InserisciPanel1() {
	
		labelNome = new JLabel("Nome:");
		labelSede = new JLabel("Sede:");
		
		fieldNome = new JTextField(15);
		fieldSede = new JTextField(15);
		
		buttonInserisci = new JButton("Inserisci");
		
		buttonInserisci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fieldNome.getText().isEmpty() || fieldSede.getText().isEmpty()) {
					new WarningException("Devi inserire tutti i campi!");
				}else {
					String nome = fieldNome.getText();
					String sede = fieldSede.getText();
					if(LoginPanel.db.insert1(nome, sede)) {
						new MessageException("Scuderia inserita!");
						fieldNome.setText("");
						fieldSede.setText("");
					}else {
						new ErrorException("Errore nell'inserimento della scuderia!");
					}
				}
			}
		});
		
		fieldSede.addKeyListener(new KeyListener() {
			
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
		setBorder(BorderFactory.createTitledBorder("Vettura"));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//RIGA 1: label nome
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.insets.set(0, 0, 4, 15); 
		
		add(labelNome, gbc);
		
		//RIGA 1: field nome
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		gbc.insets.set(0, 0, 4, 50); 
		
		add(fieldNome, gbc);
		
		//RIGA 2: label sede
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 15); 
		
		add(labelSede, gbc);
		
		//RIGA 2: field sede
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 50); 
		
		add(fieldSede, gbc);
		
		//RIGA 3: button inserisci
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.insets.set(5, 44, 20, 50); 
		gbc.gridwidth = 2;
		
		add(buttonInserisci, gbc);
		
	}
	
}
