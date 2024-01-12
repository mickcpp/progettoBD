package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class InserisciPanel2 extends JPanel{

	//VETTURA
	private JLabel labelNumerodaGara;
	private JLabel labelScuderia;
	private JLabel labelModello;
	private JTextField fieldNumeroDaGara;
	private JTextField fieldScuderia;
	private JTextField fieldModello;
	
	//COMPONENTI
	private JLabel labelCambio;
	private JLabel labelMotore;
	private JLabel labelTelaio;
	private JCheckBox checkCambio;
	private JCheckBox checkMotore;
	private JCheckBox checkTelaio;
	
	//CAMBIO
	private JLabel labelCostruttoreCambio;
	private JLabel labelCostoCambio;
	private JLabel labelDataInstallazioneCambio;
	private JLabel labelMarce;
	private JTextField fieldCostruttoreCambio;
	private JTextField fieldCostoCambio;
	private JTextField fieldDataInstallazioneCambio;
	private JSpinner spinnerMarce;
	
	//MOTORE
	private JLabel labelCostruttoreMotore;
	private JLabel labelCostoMotore;
	private JLabel labelDataInstallazioneMotore;
	private JLabel labelNumCilindri;
	private JLabel labelCilindrata;
	private JLabel labelTipo;
	private JTextField fieldCostruttoreMotore;
	private JTextField fieldCostoMotore;
	private JTextField fieldDataInstallazioneMotore;
	private JTextField fieldNumCilindri;
	private JSlider sliderCilindrata;
	private JComboBox comboTipo;
	
	//TELAIO
	private JLabel labelCostruttoreTelaio;
	private JLabel labelCostoTelaio;
	private JLabel labelDataInstallazioneTelaio;
	private JLabel labelComposizione;
	private JLabel labelPeso;
	private JTextField fieldCostruttoreTelaio;
	private JTextField fieldCostoTelaio;
	private JTextField fieldDataInstallazioneTelaio;
	private JTextField fieldComposizione;
	private JTextField fieldPeso;
	
	//INSERISCI
	private JButton buttonInserisci;
	
	public InserisciPanel2() {
	
		//VETTURA
		labelNumerodaGara = new JLabel("Numero da gara:");
		labelScuderia = new JLabel("Scuderia:");
		labelModello = new JLabel("Modello:");
		fieldNumeroDaGara = new JTextField(15);
		fieldScuderia = new JTextField(15);
		fieldModello = new JTextField(15);
		
		//COMPONENTI
		labelCambio = new JLabel("Cambio:");
		labelMotore = new JLabel("Motore:");
		labelTelaio = new JLabel("Telaio");
		checkCambio = new JCheckBox();
		checkMotore = new JCheckBox();
		checkTelaio = new JCheckBox();
		
		//CAMBIO
		labelCostruttoreCambio = new JLabel("Costruttore:");
		labelCostoCambio = new JLabel("Costo:");
		labelDataInstallazioneCambio = new JLabel("Data installazione:");
		labelMarce = new JLabel("Numero marce:");	
		fieldCostruttoreCambio = new JTextField(10);
		fieldCostoCambio = new JTextField(10);
		fieldDataInstallazioneCambio = new JTextField(10);
		
		fieldDataInstallazioneCambio.setText("AAAA/MM/GG");
		fieldDataInstallazioneCambio.setForeground(Color.gray);
		
		fieldDataInstallazioneCambio.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (fieldDataInstallazioneCambio.getText().isEmpty()) {
                    fieldDataInstallazioneCambio.setText("AAAA/MM/GG");
                    fieldDataInstallazioneCambio.setForeground(Color.GRAY);
                }
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldDataInstallazioneCambio.getText().equals("AAAA/MM/GG")) {
                    fieldDataInstallazioneCambio.setText("");
                    fieldDataInstallazioneCambio.setForeground(Color.BLACK);
				}
			}
		});
		
		spinnerMarce = new JSpinner();
		SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(7, 7, 8, 1);
		spinnerMarce.setModel(spinnerNumberModel);
		
		// Imposta l'editor personalizzato per disabilitare l'input testuale
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spinnerMarce.getEditor();
        editor.getTextField().setEditable(false);
		
        //MOTORE
        labelCostruttoreMotore = new JLabel("Costruttore:");
		labelCostoMotore = new JLabel("Costo:");
		labelDataInstallazioneMotore = new JLabel("Data installazione:");	
		labelNumCilindri = new JLabel("Numero cilindri:");
		labelCilindrata = new JLabel("Cilindrata:");
		labelTipo = new JLabel("Tipo:");
		fieldCostruttoreMotore = new JTextField(10);
		fieldCostoMotore = new JTextField(10);
		fieldDataInstallazioneMotore = new JTextField(10);
        fieldNumCilindri = new JTextField(10);
        comboTipo = new JComboBox();
        
        comboTipo.addItem("turbo");
        comboTipo.addItem("aspirato");
        
        sliderCilindrata = new JSlider(1500, 4000);
        sliderCilindrata.setPreferredSize(new Dimension(195, 60));
        sliderCilindrata.setMajorTickSpacing(500);
		sliderCilindrata.setMinorTickSpacing(100);
		sliderCilindrata.setPaintTicks(true);
		sliderCilindrata.setPaintLabels(true);
		sliderCilindrata.setSnapToTicks(true);
        
		fieldDataInstallazioneMotore.setText("AAAA/MM/GG");
		fieldDataInstallazioneMotore.setForeground(Color.gray);
		
		fieldDataInstallazioneMotore.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (fieldDataInstallazioneMotore.getText().isEmpty()) {
                    fieldDataInstallazioneMotore.setText("AAAA/MM/GG");
                    fieldDataInstallazioneMotore.setForeground(Color.GRAY);
				 }
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldDataInstallazioneMotore.getText().equals("AAAA/MM/GG")) {
                    fieldDataInstallazioneMotore.setText("");
                    fieldDataInstallazioneMotore.setForeground(Color.BLACK);
                }			}
		});
		
        //TELAIO
        labelCostruttoreTelaio = new JLabel("Costruttore:");
		labelCostoTelaio = new JLabel("Costo:");
		labelDataInstallazioneTelaio = new JLabel("Data installazione:");	
		labelComposizione = new JLabel("Composizione:");
		labelPeso = new JLabel("Peso:");
		fieldCostruttoreTelaio = new JTextField(10);
		fieldCostoTelaio = new JTextField(10);
		fieldDataInstallazioneTelaio = new JTextField(10);
        fieldComposizione = new JTextField(10);
        fieldPeso = new JTextField(10);
    
		fieldDataInstallazioneTelaio.setText("AAAA/MM/GG");
		fieldDataInstallazioneTelaio.setForeground(Color.gray);
		
		fieldDataInstallazioneTelaio.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				 if (fieldDataInstallazioneTelaio.getText().isEmpty()) {
	                    fieldDataInstallazioneTelaio.setText("AAAA/MM/GG");
	                    fieldDataInstallazioneTelaio.setForeground(Color.GRAY);
	                }
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldDataInstallazioneTelaio.getText().equals("AAAA/MM/GG")) {
                    fieldDataInstallazioneTelaio.setText("");
                    fieldDataInstallazioneTelaio.setForeground(Color.BLACK);
				}
			}
		});
		
        //INSERISCI
		buttonInserisci = new JButton("Inserisci");
		
		buttonInserisci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean check;
				
				int numeroDaGara = 0;
				String scuderia = "";
				String modello = "";
				
				String costruttoreCambio = "";
				int costoCambio = 0;
				String dataInstallazioneCambio = "";
				int numMarce = 0;
				
				String costruttoreMotore = "";
				int costoMotore = 0;
				String dataInstallazioneMotore = "";
				int numCilindri = 0;
				int cilindrata = 0;
				String tipo = "";
				
				String costruttoreTelaio = "";
				int costoTelaio = 0;
				String dataInstallazioneTelaio = "";
				String composizione = "";
				int peso = 0;
				
				if(fieldNumeroDaGara.getText().isEmpty() || fieldScuderia.getText().isEmpty() || fieldModello.getText().isEmpty()) {
					new WarningException("Devi inserire tutti i campi!");
				}else {
					
					numeroDaGara = Integer.parseInt(fieldNumeroDaGara.getText());
					scuderia = fieldScuderia.getText();
					modello = fieldModello.getText();
					
				}
				
				if(checkCambio.isSelected()) {
					if(fieldCostruttoreCambio.getText().isEmpty() || fieldCostoCambio.getText().isEmpty() || fieldDataInstallazioneCambio.getText().isEmpty()) {
						new WarningException("Devi inserire tutti i campi!");
					}
					costruttoreCambio = fieldCostruttoreCambio.getText();
					costoCambio = Integer.parseInt(fieldCostoCambio.getText());
					dataInstallazioneCambio = fieldDataInstallazioneCambio.getText();
					numMarce = (int) spinnerMarce.getValue();	
				}
				
				if(checkMotore.isSelected()) {
					if(fieldCostruttoreMotore.getText().isEmpty() || fieldCostoMotore.getText().isEmpty() || fieldDataInstallazioneMotore.getText().isEmpty() || fieldNumCilindri.getText().isEmpty()) {
						new WarningException("Devi inserire tutti i campi!");
					}
					costruttoreMotore = fieldCostruttoreMotore.getText();
					costoMotore = Integer.parseInt(fieldCostoMotore.getText());
					dataInstallazioneMotore = fieldDataInstallazioneMotore.getText();
					numCilindri = Integer.parseInt(fieldNumCilindri.getText());
					cilindrata = (sliderCilindrata.getValue());
					tipo = (String) comboTipo.getSelectedItem();	
				}
				
				if(checkTelaio.isSelected()) {
					if(fieldCostruttoreTelaio.getText().isEmpty() || fieldCostoTelaio.getText().isEmpty() || fieldDataInstallazioneTelaio.getText().isEmpty() || fieldComposizione.getText().isEmpty() || fieldPeso.getText().isEmpty()) {
						new WarningException("Devi inserire tutti i campi!");
					}
					costruttoreTelaio = fieldCostruttoreTelaio.getText();
					costoTelaio = Integer.parseInt(fieldCostoTelaio.getText());
					dataInstallazioneTelaio = fieldDataInstallazioneTelaio.getText();
					composizione = fieldComposizione.getText();
					peso = Integer.parseInt(fieldPeso.getText());
				}
				
				if(checkCambio.isSelected() && checkMotore.isSelected() && checkTelaio.isSelected()) {
					check = LoginPanel.db.insert2(numeroDaGara, scuderia, modello);
					if(check) new MessageException("Vettura inserita!");
					else new ErrorException("Errore nell'inserimento della vettura!");	
					
					check = LoginPanel.db.insertCambio(numeroDaGara, costruttoreCambio, costoCambio, dataInstallazioneCambio, numMarce);
					if(check) new MessageException("Cambio inserito!");
					else new ErrorException("Errore nell'inserimento del cambio!");	
					
					check = LoginPanel.db.insertMotore(numeroDaGara, costruttoreMotore, costoMotore, dataInstallazioneMotore, numCilindri, cilindrata, tipo);
					if(check) new MessageException("Motore inserito!");
					else new ErrorException("Errore nell'inserimento del motore!");	
					
					check = LoginPanel.db.insertTelaio(numeroDaGara, costruttoreTelaio, costoTelaio, dataInstallazioneTelaio, composizione, peso);
					if(check) new MessageException("Telaio inserito!");
					else new ErrorException("Errore nell'inserimento del telaio!");	
					
				}else if(!checkCambio.isSelected() && !checkMotore.isSelected() && !checkTelaio.isSelected()) {
					
					check = LoginPanel.db.insert2(numeroDaGara, scuderia, modello);
					if(check) new MessageException("Vettura inserita!");
					else new ErrorException("Errore nell'inserimento della vettura!");	
					
				}else if(!checkCambio.isSelected() && !checkMotore.isSelected() && checkTelaio.isSelected()) {
					
					check = LoginPanel.db.insert2(numeroDaGara, scuderia, modello);
					if(check) new MessageException("Vettura inserita!");
					else new ErrorException("Errore nell'inserimento della vettura!");	
					
					check = LoginPanel.db.insertTelaio(numeroDaGara, costruttoreTelaio, costoTelaio, dataInstallazioneTelaio, composizione, peso);
					if(check) new MessageException("Telaio inserito!");
					else new ErrorException("Errore nell'inserimento del telaio!");	
					
				}else if(!checkCambio.isSelected() && checkMotore.isSelected() && !checkTelaio.isSelected()) {
					
					check = LoginPanel.db.insert2(numeroDaGara, scuderia, modello);
					if(check) new MessageException("Vettura inserita!");
					else new ErrorException("Errore nell'inserimento della vettura!");	
					
					check = LoginPanel.db.insertMotore(numeroDaGara, costruttoreMotore, costoMotore, dataInstallazioneMotore, numCilindri, cilindrata, tipo);
					if(check) new MessageException("Motore inserito!");
					else new ErrorException("Errore nell'inserimento del motore!");	
					
				}else if(!checkCambio.isSelected() && checkMotore.isSelected() && checkTelaio.isSelected()) {
					
					check = LoginPanel.db.insert2(numeroDaGara, scuderia, modello);
					if(check) new MessageException("Vettura inserita!");
					else new ErrorException("Errore nell'inserimento della vettura!");	
					
					check = LoginPanel.db.insertMotore(numeroDaGara, costruttoreMotore, costoMotore, dataInstallazioneMotore, numCilindri, cilindrata, tipo);
					if(check) new MessageException("Motore inserito!");
					else new ErrorException("Errore nell'inserimento del motore!");	
					
					check = LoginPanel.db.insertTelaio(numeroDaGara, costruttoreTelaio, costoTelaio, dataInstallazioneTelaio, composizione, peso);
					if(check) new MessageException("Telaio inserito!");
					else new ErrorException("Errore nell'inserimento del telaio!");	
					
				}else if(checkCambio.isSelected() && !checkMotore.isSelected() && !checkTelaio.isSelected()) {
					
					check = LoginPanel.db.insert2(numeroDaGara, scuderia, modello);
					if(check) new MessageException("Vettura inserita!");
					else new ErrorException("Errore nell'inserimento della vettura!");	
					
					check = LoginPanel.db.insertCambio(numeroDaGara, costruttoreCambio, costoCambio, dataInstallazioneCambio, numMarce);
					if(check) new MessageException("Cambio inserito!");
					else new ErrorException("Errore nell'inserimento del cambio!");	
					
				}else if(checkCambio.isSelected() && !checkMotore.isSelected() && checkTelaio.isSelected()) {
					
					check = LoginPanel.db.insert2(numeroDaGara, scuderia, modello);
					if(check) new MessageException("Vettura inserita!");
					else new ErrorException("Errore nell'inserimento della vettura!");	
					
					check = LoginPanel.db.insertCambio(numeroDaGara, costruttoreCambio, costoCambio, dataInstallazioneCambio, numMarce);
					if(check) new MessageException("Cambio inserito!");
					else new ErrorException("Errore nell'inserimento del cambio!");	
					
					check = LoginPanel.db.insertTelaio(numeroDaGara, costruttoreTelaio, costoTelaio, dataInstallazioneTelaio, composizione, peso);
					if(check) new MessageException("Telaio inserito!");
					else new ErrorException("Errore nell'inserimento del telaio!");	
					
				}else if(checkCambio.isSelected() && checkMotore.isSelected() && !checkTelaio.isSelected()) {
					
					check = LoginPanel.db.insert2(numeroDaGara, scuderia, modello);
					if(check) new MessageException("Vettura inserita!");
					else new ErrorException("Errore nell'inserimento della vettura!");	
					
					check = LoginPanel.db.insertCambio(numeroDaGara, costruttoreCambio, costoCambio, dataInstallazioneCambio, numMarce);
					if(check) new MessageException("Cambio inserito!");
					else new ErrorException("Errore nell'inserimento del cambio!");	
					
					check = LoginPanel.db.insertMotore(numeroDaGara, costruttoreMotore, costoMotore, dataInstallazioneMotore, numCilindri, cilindrata, tipo);
					if(check) new MessageException("Motore inserito!");
					else new ErrorException("Errore nell'inserimento del motore!");	
				}
			}
		});
		
		checkCambio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkCambio.isSelected()) {
					labelCostruttoreCambio.setEnabled(true);
					labelCostoCambio.setEnabled(true);
					labelDataInstallazioneCambio.setEnabled(true);
					labelMarce.setEnabled(true);
					fieldCostruttoreCambio.setEnabled(true);
					fieldCostoCambio.setEnabled(true);
					fieldDataInstallazioneCambio.setEnabled(true);
					spinnerMarce.setEnabled(true);
				}else {
					labelCostruttoreCambio.setEnabled(false);
					labelCostoCambio.setEnabled(false);
					labelDataInstallazioneCambio.setEnabled(false);
					labelMarce.setEnabled(false);
					fieldCostruttoreCambio.setEnabled(false);
					fieldCostoCambio.setEnabled(false);
					fieldDataInstallazioneCambio.setEnabled(false);
					spinnerMarce.setEnabled(false);
					fieldCostruttoreCambio.setText("");
					fieldCostoCambio.setText("");
					fieldDataInstallazioneCambio.setText("");
				}
			}
		});
		
		checkMotore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkMotore.isSelected()) {
					labelCostruttoreMotore.setEnabled(true);
					labelCostoMotore.setEnabled(true);
					labelDataInstallazioneMotore.setEnabled(true);
					labelNumCilindri.setEnabled(true);
					labelCilindrata.setEnabled(true);
					labelTipo.setEnabled(true);
					fieldCostruttoreMotore.setEnabled(true);
					fieldCostoMotore.setEnabled(true);
					fieldDataInstallazioneMotore.setEnabled(true);
					fieldNumCilindri.setEnabled(true);
					sliderCilindrata.setEnabled(true);
					comboTipo.setEnabled(true);
				}else {
					labelCostruttoreMotore.setEnabled(false);
					labelCostoMotore.setEnabled(false);
					labelDataInstallazioneMotore.setEnabled(false);
					labelNumCilindri.setEnabled(false);
					labelCilindrata.setEnabled(false);
					labelTipo.setEnabled(false);
					fieldCostruttoreMotore.setEnabled(false);
					fieldCostoMotore.setEnabled(false);
					fieldDataInstallazioneMotore.setEnabled(false);
					fieldNumCilindri.setEnabled(false);
					sliderCilindrata.setEnabled(false);
					comboTipo.setEnabled(false);
					fieldCostruttoreMotore.setText("");
					fieldCostoMotore.setText("");
					fieldDataInstallazioneMotore.setText("");
					fieldNumCilindri.setText("");
				}
			}
		});
		
		checkTelaio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkTelaio.isSelected()) {
					labelCostruttoreTelaio.setEnabled(true);
					labelCostoTelaio.setEnabled(true);
					labelDataInstallazioneTelaio.setEnabled(true);
					labelComposizione.setEnabled(true);
					labelPeso.setEnabled(true);
					fieldCostruttoreTelaio.setEnabled(true);
					fieldCostoTelaio.setEnabled(true);
					fieldDataInstallazioneTelaio.setEnabled(true);
					fieldComposizione.setEnabled(true);
					fieldPeso.setEnabled(true);
				}else {
					labelCostruttoreTelaio.setEnabled(false);
					labelCostoTelaio.setEnabled(false);
					labelDataInstallazioneTelaio.setEnabled(false);
					labelComposizione.setEnabled(false);
					labelPeso.setEnabled(false);
					fieldCostruttoreTelaio.setEnabled(false);
					fieldCostoTelaio.setEnabled(false);
					fieldDataInstallazioneTelaio.setEnabled(false);
					fieldComposizione.setEnabled(false);
					fieldPeso.setEnabled(false);
					fieldCostruttoreTelaio.setText("");;
					fieldCostoTelaio.setText("");;
					fieldDataInstallazioneTelaio.setText("");
					fieldComposizione.setText("");
					fieldPeso.setText("");
				}
			}
		});
		
		setLayout(new BorderLayout());
		JPanel vetturaPanel = vetturaPanel();
		JPanel cambioPanel = cambioPanel();
		JPanel motorePanel = motorePanel();
		JPanel telaioPanel = telaioPanel();
		
		add(vetturaPanel, BorderLayout.NORTH);
		add(cambioPanel, BorderLayout.WEST);
		add(motorePanel, BorderLayout.CENTER);
		add(telaioPanel, BorderLayout.EAST);
		
	}
	
	public JPanel vetturaPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Vettura"));
		
		GridBagConstraints gbc = new GridBagConstraints();
	
		//RIGA 1: label numeroDaGara
		gbc.gridx = 0; 
		gbc.gridy = 0;
		
		gbc.insets.set(50, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		panel.add(labelNumerodaGara, gbc);
		
		//RIGA 1: field numeroDaGara
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		gbc.insets.set(50, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.CENTER;
		
		panel.add(fieldNumeroDaGara, gbc);
		
		//RIGA 2: label scuderia
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		panel.add(labelScuderia, gbc);
		
		//RIGA 2: field scuderia
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.CENTER;
		
		panel.add(fieldScuderia, gbc);
		
		//RIGA 3: label modello
		gbc.gridx = 0;
		gbc.gridy = 2;
				
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		panel.add(labelModello, gbc);
				
		//RIGA 3: field modello
		gbc.gridx = 1;
		gbc.gridy = 2;
				
		gbc.insets.set(0, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.CENTER;
		
		panel.add(fieldModello, gbc);
		
		//RIGA 4: label cambio
		gbc.gridx = 0;
		gbc.gridy = 3;
				
		gbc.insets.set(10, 0, 0, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		panel.add(labelCambio, gbc);
				
		//RIGA 4: checkbox cambio
		gbc.gridx = 1;
		gbc.gridy = 3;
				
		gbc.insets.set(10, 0, 0, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(checkCambio, gbc);
		
		//RIGA 5: label motore
		gbc.gridx = 0;
		gbc.gridy = 4;
				
		gbc.insets.set(0, 0, 0, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		panel.add(labelMotore, gbc);
				
		//RIGA 5: checkbox motore
		gbc.gridx = 1;
		gbc.gridy = 4;
				
		gbc.insets.set(0, 0, 0, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(checkMotore, gbc);
		
		//RIGA 6: label telaio
		gbc.gridx = 0;
		gbc.gridy = 5;
				
		gbc.insets.set(0, 0, 0, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		panel.add(labelTelaio, gbc);
				
		//RIGA 6: checkbox telaio
		gbc.gridx = 1;
		gbc.gridy = 5;
				
		gbc.insets.set(0, 0, 0, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(checkTelaio, gbc);
		
		//RIGA 7: button inserisci
		gbc.gridx = 0;
		gbc.gridy = 6;
		
		gbc.insets.set(5, 153, 20, 0); 
		gbc.gridwidth = 2;
		
		panel.add(buttonInserisci, gbc);
		
		return panel;
	}
	
	public JPanel cambioPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Cambio"));
		
		labelCostruttoreCambio.setEnabled(false);
		labelCostoCambio.setEnabled(false);
		labelDataInstallazioneCambio.setEnabled(false);
		labelMarce.setEnabled(false);
		fieldCostruttoreCambio.setEnabled(false);
		fieldCostoCambio.setEnabled(false);
		fieldDataInstallazioneCambio.setEnabled(false);
		spinnerMarce.setEnabled(false);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//RIGA 8: label costruttoreCambio
		gbc.gridx = 0;
		gbc.gridy = 7;
				
		gbc.insets.set(0, 100, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 1;
		
		panel.add(labelCostruttoreCambio, gbc);
		
		//RIGA 8: field costruttoreCambio
		gbc.gridx = 1;
		gbc.gridy = 7;
		
		gbc.insets.set(0, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(fieldCostruttoreCambio, gbc);
		
		//RIGA 9: label costoCambio
		gbc.gridx = 0;
		gbc.gridy = 8;
				
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		panel.add(labelCostoCambio, gbc);
		
		//RIGA 9: field costoCambio
		gbc.gridx = 1;
		gbc.gridy = 8;
		
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(fieldCostoCambio, gbc);

		//RIGA 10: label dataInstallazioneCambio
		gbc.gridx = 0;
		gbc.gridy = 9;
				
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
		
		panel.add(labelDataInstallazioneCambio, gbc);
		
		//RIGA 10: field dataInstallazioneCambio
		gbc.gridx = 1;
		gbc.gridy = 9;
		
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(fieldDataInstallazioneCambio, gbc);
		
		//RIGA 11: label marce
		gbc.gridx = 0;
		gbc.gridy = 10;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelMarce, gbc);
				
		//RIGA 11: spinner marce
		gbc.gridx = 1;
		gbc.gridy = 10;
				
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(spinnerMarce, gbc);
		
		return panel;
	}
	
	public JPanel motorePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Motore"));
		
		labelCostruttoreMotore.setEnabled(false);
		labelCostoMotore.setEnabled(false);
		labelDataInstallazioneMotore.setEnabled(false);
		labelNumCilindri.setEnabled(false);
		labelCilindrata.setEnabled(false);
		labelTipo.setEnabled(false);
		fieldCostruttoreMotore.setEnabled(false);
		fieldCostoMotore.setEnabled(false);
		fieldDataInstallazioneMotore.setEnabled(false);
		fieldNumCilindri.setEnabled(false);
		sliderCilindrata.setEnabled(false);
		comboTipo.setEnabled(false);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//RIGA 8: label costruttoreMotore
		gbc.gridx = 2;
		gbc.gridy = 7;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelCostruttoreMotore, gbc);
				
		//RIGA 8: field costruttoreMotore
		gbc.gridx = 3;
		gbc.gridy = 7;
				
		gbc.insets.set(0, 0, 4, 40); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(fieldCostruttoreMotore, gbc);
		
		//RIGA 9: label costoMotore
		gbc.gridx = 2;
		gbc.gridy = 8;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelCostoMotore, gbc);
				
		//RIGA 9: field costoMotore
		gbc.gridx = 3;
		gbc.gridy = 8;
				
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(fieldCostoMotore, gbc);
		
		//RIGA 10: label dataInstallazioneMotore
		gbc.gridx = 2;
		gbc.gridy = 9;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelDataInstallazioneMotore, gbc);
				
		//RIGA 10: field dataInstallazioneMotore
		gbc.gridx = 3;
		gbc.gridy = 9;
				
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(fieldDataInstallazioneMotore, gbc);
		
		//RIGA 11: label numCilindri
		gbc.gridx = 2;
		gbc.gridy = 10;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelNumCilindri, gbc);
				
		//RIGA 11: field numCilindri
		gbc.gridx = 3;
		gbc.gridy = 10;
				
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(fieldNumCilindri, gbc);
		
		//RIGA 12: label cilindrata
		gbc.gridx = 2;
		gbc.gridy = 11;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelCilindrata, gbc);
				
		//RIGA 12: slider cilindrata
		gbc.gridx = 3;
		gbc.gridy = 11;
				
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(sliderCilindrata, gbc);
		
		//RIGA 13: label tipo
		gbc.gridx = 2;
		gbc.gridy = 12;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelTipo, gbc);
				
		//RIGA 13: field tipo
		gbc.gridx = 3;
		gbc.gridy = 12;
				
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(comboTipo, gbc);
		
		return panel;
	}
	
	public JPanel telaioPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Telaio"));
		
		labelCostruttoreTelaio.setEnabled(false);
		labelCostoTelaio.setEnabled(false);
		labelDataInstallazioneTelaio.setEnabled(false);
		labelComposizione.setEnabled(false);
		labelPeso.setEnabled(false);
		fieldCostruttoreTelaio.setEnabled(false);
		fieldCostoTelaio.setEnabled(false);
		fieldDataInstallazioneTelaio.setEnabled(false);
		fieldComposizione.setEnabled(false);
		fieldPeso.setEnabled(false);

		GridBagConstraints gbc = new GridBagConstraints();
		
		//RIGA 8: label costruttoreTelaio
		gbc.gridx = 4;
		gbc.gridy = 7;
						
		gbc.insets.set(0, 50, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelCostruttoreTelaio, gbc);
				
		//RIGA 8: field costruttoreTelaio
		gbc.gridx = 5;
		gbc.gridy = 7;
				
		gbc.insets.set(0, 0, 4, 100); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(fieldCostruttoreTelaio, gbc);
		
		//RIGA 9: label costoTelaio
		gbc.gridx = 4;
		gbc.gridy = 8;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelCostoTelaio, gbc);
				
		//RIGA 9: field costoTelaio
		gbc.gridx = 5;
		gbc.gridy = 8;
				
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(fieldCostoTelaio, gbc);
		
		//RIGA 10: label dataInstallazioneTelaio
		gbc.gridx = 4;
		gbc.gridy = 9;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelDataInstallazioneTelaio, gbc);
				
		//RIGA 10: field dataInstallazioneTelaio
		gbc.gridx = 5;
		gbc.gridy = 9;
				
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(fieldDataInstallazioneTelaio, gbc);
		
		//RIGA 11: label composizione
		gbc.gridx = 4;
		gbc.gridy = 10;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelComposizione, gbc);
				
		//RIGA 11: field composizione
		gbc.gridx = 5;
		gbc.gridy = 10;
				
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(fieldComposizione, gbc);
		
		//RIGA 12: label peso
		gbc.gridx = 4;
		gbc.gridy = 11;
						
		gbc.insets.set(0, 0, 4, 15); 
		gbc.anchor = GridBagConstraints.LINE_END;
				
		panel.add(labelPeso, gbc);
				
		//RIGA 12: field peso
		gbc.gridx = 5;
		gbc.gridy = 11;
				
		gbc.insets.set(0, 0, 4, 0); 
		gbc.anchor = GridBagConstraints.LINE_START;
				
		panel.add(fieldPeso, gbc);
		
		return panel;
	}

}
