package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.ComboPopup;

public class InserisciPanel6 extends JPanel{

	private JLabel labelGara;
	private JLabel labelVettura;
	private JLabel labelPiazzamento;
	private JLabel labelMotivoRitiro;
	
	private JTextField fieldGara;
	private JTextField fieldVettura;
	private JSpinner spinnerPiazzamento;
	private JComboBox comboRitiro;
	
	private JRadioButton radioPiazzamento;
	private JRadioButton radioRitiro;
	private ButtonGroup buttonGroup;
	
	private JButton buttonInserisci;
	
	public InserisciPanel6() {
	
		labelGara = new JLabel("Gara:");
		labelVettura = new JLabel("Vettura:");
		labelPiazzamento = new JLabel("Piazzamento:");
		labelMotivoRitiro = new JLabel("Motivo ritiro:");
		
		fieldGara = new JTextField(15);
		fieldVettura = new JTextField(15);
		spinnerPiazzamento = new JSpinner(new SpinnerNumberModel(1, 1, 60, 1));
		comboRitiro = new JComboBox();
		
		comboRitiro.addItem("incidente");
		comboRitiro.addItem("squalifica");
		comboRitiro.addItem("guasto meccanico");
		
		radioPiazzamento = new JRadioButton("");
		radioRitiro = new JRadioButton("");
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioPiazzamento);
		buttonGroup.add(radioRitiro);
		
		radioPiazzamento.setSelected(true);
		labelMotivoRitiro.setEnabled(false);
		comboRitiro.setEnabled(false);
		
		buttonInserisci = new JButton("Inserisci");
		
		radioPiazzamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				labelMotivoRitiro.setEnabled(false);
				comboRitiro.setEnabled(false);
				labelPiazzamento.setEnabled(true);
				spinnerPiazzamento.setEnabled(true);
			}
		});
		
		radioRitiro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				labelPiazzamento.setEnabled(false);
				spinnerPiazzamento.setEnabled(false);
				labelMotivoRitiro.setEnabled(true);
				comboRitiro.setEnabled(true);
			}
		});

		buttonInserisci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fieldGara.getText().isEmpty() || fieldVettura.getText().isEmpty()) {
					new WarningException("Devi inserire tutti i campi!");
				}else{
					int gara = Integer.parseInt(fieldGara.getText());
					int vettura = Integer.parseInt(fieldVettura.getText());
					int piazzamento = (int) spinnerPiazzamento.getValue();
					String motivoRitiro = (String) comboRitiro.getSelectedItem();
					
					if(spinnerPiazzamento.isEnabled()) {
						if(LoginPanel.db.insert6(gara, vettura, piazzamento, null)) {
							new MessageException("Piazzamento registrato!");
							fieldGara.setText("");
							fieldVettura.setText("");
						}else {
							new ErrorException("Errore nella registrazione del piazzamento!");
						}
					}else if(comboRitiro.isEnabled()) {
						if(LoginPanel.db.insert6(gara, vettura, 0, motivoRitiro)) {
							new MessageException("Motivo di ritiro registrato!");
							fieldGara.setText("");
							fieldVettura.setText("");
						}else {
							new ErrorException("Errore nella registrazione del motivo di ritiro!");
						}
					}
					
				}
			}
		});
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Piazzamento"));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//RIGA 1: label gara
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.insets.set(0, 0, 4, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelGara, gbc);
		
		//RIGA 1: field gara
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		gbc.insets.set(0, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldGara, gbc);
		
		//RIGA 2: label vettura
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelVettura, gbc);
		
		//RIGA 2: field vettura
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldVettura, gbc);
		
		//RIGA 3: label piazzamento
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelPiazzamento, gbc);
		
		//RIGA 3: spinner piazzamento
		gbc.gridx = 1;
		gbc.gridy = 2;
		
		gbc.insets.set(0, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(spinnerPiazzamento, gbc);
		
		//RIGA 3: radio piazzamento
		gbc.gridx = 2;
		gbc.gridy = 2;
		
		gbc.insets.set(0, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(radioPiazzamento, gbc);
		
		//RIGA 3: label motivo ritiro
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelMotivoRitiro, gbc);
		
		//RIGA 3: combo motivo ritiro
		gbc.gridx = 1;
		gbc.gridy = 3;
		
		gbc.insets.set(0, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(comboRitiro, gbc);
		
		//RIGA 3: spinner motivo ritiro
		gbc.gridx = 2;
		gbc.gridy = 3;
		
		gbc.insets.set(0, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(radioRitiro, gbc);
		
		//RIGA 4: button inserisci
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		gbc.insets.set(5, 44, 20, 50); 
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		
		add(buttonInserisci, gbc);
		
	}
	
}