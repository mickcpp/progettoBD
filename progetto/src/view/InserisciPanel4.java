package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InserisciPanel4 extends JPanel{

	private JLabel labelVettura;
	private JLabel labelScuderia;
	private JLabel labelNome;
	private JLabel labelCognome;
	private JLabel labelDataNascita;
	private JLabel labelNazionalita;
	private JLabel labelDataPrimaLicenza;
	private JLabel labelNumeroLicenze;
	private JLabel labelQuota;

	private JTextField fieldVettura;
	private JTextField fieldScuderia;
	private JTextField fieldNome;
	private JTextField fieldCognome;
	private JTextField fieldDataNascita;
	private JTextField fieldNazionalita;
	private JTextField fieldDataPrimaLicenza;
	private JTextField fieldNumeroLicenze;
	private JRadioButton buttonPrimaLicenza;
	private JRadioButton buttonNumeroLicenze;
	private ButtonGroup buttonGroup;
	private JTextField fieldQuota;
	
	private JButton buttonInserisci;
	
	public InserisciPanel4() {
	
		labelVettura = new JLabel("Vettura:");
		labelScuderia = new JLabel("Scuderia:");
		labelNome = new JLabel("Nome:");
		labelCognome = new JLabel("Cognome:");
		labelDataNascita = new JLabel("Data nascita:");
		labelNazionalita = new JLabel("Nazionalità:");
		labelDataPrimaLicenza = new JLabel("Data prima licenza:");
		labelQuota = new JLabel("Quota:");
		
		fieldVettura = new JTextField(15);
		fieldScuderia = new JTextField(15);
		fieldNome = new JTextField(15);
		fieldCognome = new JTextField(15);
		fieldDataNascita = new JTextField(15);
		fieldNazionalita = new JTextField(15);
		fieldDataPrimaLicenza = new JTextField(15);
		fieldQuota = new JTextField(15);
		
		fieldDataNascita.setText("AAAA/MM/GG");
		fieldDataNascita.setForeground(Color.gray);
		
		fieldDataNascita.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (fieldDataNascita.getText().isEmpty()) {
					fieldDataNascita.setText("AAAA/MM/GG");
					fieldDataNascita.setForeground(Color.GRAY);
                }
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldDataNascita.getText().equals("AAAA/MM/GG")) {
					fieldDataNascita.setText("");
					fieldDataNascita.setForeground(Color.BLACK);
				}
			}
		});
		
		fieldDataPrimaLicenza.setText("AAAA/MM/GG");
		fieldDataPrimaLicenza.setForeground(Color.gray);
		
		fieldDataPrimaLicenza.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (fieldDataPrimaLicenza.getText().isEmpty()) {
					fieldDataPrimaLicenza.setText("AAAA/MM/GG");
					fieldDataPrimaLicenza.setForeground(Color.GRAY);
                }
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldDataPrimaLicenza.getText().equals("AAAA/MM/GG")) {
					fieldDataPrimaLicenza.setText("");
					fieldDataPrimaLicenza.setForeground(Color.BLACK);
				}
			}
		});
		
		buttonInserisci = new JButton("Inserisci");
		
		buttonInserisci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fieldVettura.getText().isEmpty() || fieldNome.getText().isEmpty() || fieldCognome.getText().isEmpty() || fieldDataNascita.getText().isEmpty() || fieldNazionalita.getText().isEmpty() || fieldDataPrimaLicenza.getText().isEmpty()) {
					new WarningException("Devi inserire tutti i campi!");
				}else{
					
					int vettura = Integer.parseInt(fieldVettura.getText());
					String scuderia = fieldScuderia.getText();
					String nome = fieldNome.getText();
					String cognome = fieldCognome.getText();
					String dataNascita = fieldDataNascita.getText();
					String nazionalita = fieldNazionalita.getText();
					String dataPrimaLicenza = fieldDataPrimaLicenza.getText();
					int quota = Integer.parseInt(fieldQuota.getText());
					
					if(LoginPanel.db.insert4(vettura, scuderia, nome, cognome, dataNascita, nazionalita, dataPrimaLicenza, quota)) {
						new MessageException("Gentleman driver inserito!");
						fieldVettura.setText("");
						fieldScuderia.setText("");
						fieldNome.setText("");
						fieldCognome.setText("");
						fieldDataNascita.setText("");
						fieldNazionalita.setText("");
						fieldDataPrimaLicenza.setText("");
						fieldQuota.setText("");
					}else new ErrorException("Errore nell'inserimento del gentleman driver!");
				}
			}
		});
		
		fieldQuota.addKeyListener(new KeyListener() {
			
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
		setBorder(BorderFactory.createTitledBorder("Gentleman driver"));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//RIGA 1: label vettura
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelVettura, gbc);
		
		//RIGA 1: field vettura
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldVettura, gbc);
	
		//RIGA 2: label scuderia
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelScuderia, gbc);
		
		//RIGA 2: field scuderia
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldScuderia, gbc);
		
		//RIGA 3: label nome
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelNome, gbc);
		
		//RIGA 2: field nome
		gbc.gridx = 1;
		gbc.gridy = 2;
		
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldNome, gbc);
		
		//RIGA 4: label cognome
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelCognome, gbc);
		
		//RIGA 4: field cognome
		gbc.gridx = 1;
		gbc.gridy = 3;
		
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldCognome, gbc);
		
		//RIGA 5: label dataNascita
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelDataNascita, gbc);
		
		//RIGA 5: field dataNascita
		gbc.gridx = 1;
		gbc.gridy = 4;
		
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldDataNascita, gbc);
		
		//RIGA 6: label nazionalita
		gbc.gridx = 0;
		gbc.gridy = 5;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelNazionalita, gbc);
		
		//RIGA 6: field nazionalita
		gbc.gridx = 1;
		gbc.gridy = 5;
		
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldNazionalita, gbc);
		
		//RIGA 7: label dataPrimaLicenza
		gbc.gridx = 0;
		gbc.gridy = 6;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelDataPrimaLicenza, gbc);
		
		//RIGA 7: field dataPrimaLicenza
		gbc.gridx = 1;
		gbc.gridy = 6;
		
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldDataPrimaLicenza, gbc);	
		
		//RIGA 8: label quota
		gbc.gridx = 0;
		gbc.gridy = 7;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelQuota, gbc);
		
		//RIGA 8: field quota
		gbc.gridx = 1;
		gbc.gridy = 7;
		
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldQuota, gbc);	
		
		//RIGA 9: button inserisci
		gbc.gridx = 0;
		gbc.gridy = 8;
		
		gbc.insets.set(5, 108, 20, 0); 
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		
		add(buttonInserisci, gbc);
		
	}
	
}