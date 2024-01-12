package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeletePanel extends JPanel{

	private JLabel labelVettura;
	private JLabel labelComponente;
	
	private JTextField fieldVettura;
	private JComboBox comboComponente;
	
	private JButton buttonElimina;
	
	public DeletePanel() {
	
		labelVettura = new JLabel("Vettura:");
		labelComponente = new JLabel("Componente:");
		
		fieldVettura = new JTextField(15);
		comboComponente = new JComboBox();
		
		comboComponente.addItem("Cambio");
		comboComponente.addItem("Motore");
		comboComponente.addItem("Telaio");
		
		buttonElimina = new JButton("Elimina");
		
		buttonElimina.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fieldVettura.getText().isEmpty()) {
					new WarningException("Devi inserire una vettura!");
				}else {
					int vettura = Integer.parseInt(fieldVettura.getText());
					String componente = (String) comboComponente.getSelectedItem();
					
					if(componente.equals("Cambio")) {
						if(LoginPanel.db.delete1(vettura)) {
							new MessageException("Cambio eliminato!");
							fieldVettura.setText("");
						}else {
							new ErrorException("Errore nella rimozione del cambio!");
						}
					}
					if(componente.equals("Motore")) {
						if(LoginPanel.db.delete2(vettura)) {
							new MessageException("Motore eliminato!");
							fieldVettura.setText("");
						}else {
							new ErrorException("Errore nella rimozione del motore!");
						}
					}
					if(componente.equals("Telaio")) {
						if(LoginPanel.db.delete3(vettura)) {
							new MessageException("Telaio eliminato!");
							fieldVettura.setText("");
						}else {
							new ErrorException("Errore nella rimozione del telaio!");
						}
					}
				}
			}
		});
		
		comboComponente.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					buttonElimina.doClick();
				}
			}
		});	
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Componente"));
		
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
		
		gbc.insets.set(0, 0, 4, 50);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(fieldVettura, gbc);
		
		//RIGA 2: label componente
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		
		add(labelComponente, gbc);
		
		//RIGA 2: combo componente
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		gbc.insets.set(0, 0, 4, 50); 
		gbc.anchor = GridBagConstraints.LINE_START;
		
		add(comboComponente, gbc);
		
		//RIGA 3: button elimina
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.insets.set(5, 84, 20, 50); 
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		
		add(buttonElimina, gbc);
		
	}
	
}
