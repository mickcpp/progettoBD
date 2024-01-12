package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterrogaPanel extends JPanel{
	
	private JPanel controlPanel;
	private JPanel interrogatePanel;
	private Frame frame;
	
	public InterrogaPanel() {
		
		controlPanel = createControlPanel();
		interrogatePanel = createInterrogatePanel();
		
		setLayout(new BorderLayout());
		
		add(controlPanel, BorderLayout.NORTH);
		add(interrogatePanel, BorderLayout.CENTER);
		
	}
	
	public JPanel createControlPanel() {
		
		JRadioButton radioInterroga;
		JRadioButton radioModifica;
		ButtonGroup buttonGroup;
		
		controlPanel = new JPanel();
		
		radioInterroga = new JRadioButton("Interroga");
		radioModifica = new JRadioButton("Modifica");
		
		// Imposto di default radioInterroga a "selezionato"
		radioInterroga.setSelected(true);
		
		radioModifica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(radioModifica.isSelected()) {
					frame.switchToModificaPanel();
					radioInterroga.setSelected(true);
				}
			}
		});
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioInterroga);
		buttonGroup.add(radioModifica);

		controlPanel.add(radioInterroga);
		controlPanel.add(radioModifica);
		
		return controlPanel;
	}
	
	public JPanel createInterrogatePanel() {
		
		JPanel panel = new JPanel();
		JPanel panelQuery = new JPanel();
		JPanel panelOutput = new JPanel();
		TablePane table = new TablePane();
		
		JPanel scelta = new JPanel();
		
		JPanel sceltaVettura = new JPanel();
		JLabel labelVettura = new JLabel("Vettura:");
		JTextField fieldVettura = new JTextField(10);
		JButton checkVettura = new JButton("Cerca");
		
		JPanel sceltaGara = new JPanel();
		JLabel labelGara = new JLabel("Gara:");
		JTextField fieldGara = new JTextField(10);
		JButton checkGara = new JButton("Cerca");
		
		sceltaVettura.setVisible(false);
		sceltaGara.setVisible(false);
		
		JComboBox listaQuery;
		JButton buttonCerca;
	
		listaQuery = new JComboBox();
		buttonCerca = new JButton("Cerca");
		
		listaQuery.addItem(QUERY1);
		listaQuery.addItem(QUERY2);
		listaQuery.addItem(QUERY3);
		listaQuery.addItem(QUERY4);
		listaQuery.addItem(QUERY5);
		listaQuery.addItem(QUERY6);
		listaQuery.addItem(QUERY7);
		listaQuery.addItem(QUERY8);
		listaQuery.addItem(QUERY9);
		listaQuery.addItem(QUERY10);
		listaQuery.addItem(QUERY11);
		listaQuery.addItem(QUERY12);
		listaQuery.addItem(QUERY13);
		listaQuery.addItem(QUERY14);
		listaQuery.addItem(QUERY15);
		listaQuery.addItem(QUERY16);
		
		buttonCerca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String query = (String) listaQuery.getSelectedItem();
				String[] nomiCampi = new String[10];
				ResultSet result = null;
				TableModel tableModel;
				
				switch(query) {
				case QUERY1:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query1();
					nomiCampi[0] = "Scuderia";
					nomiCampi[1] = "Quota totale";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY2:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query2();
					nomiCampi[0] = "Scuderia";
					nomiCampi[1] = "Sede";
					nomiCampi[2] = "Numero finanziamenti";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY3:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query3();
					nomiCampi[0] = "ID_Pilota";
					nomiCampi[1] = "Vettura";
					nomiCampi[2] = "Nome";
					nomiCampi[3] = "Cognome";
					nomiCampi[4] = "Nazionalità";
					nomiCampi[5] = "Gara";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY4:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query4();
					nomiCampi[0] = "Scuderia";
					nomiCampi[1] = "Percentuale gentleman Driver";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY5:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);;
					result = LoginPanel.db.query5();
					nomiCampi[0] = "Costruttore";
					nomiCampi[1] = "Ragione sociale";
					nomiCampi[2] = "Componenti forniti";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY6:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query6();
					nomiCampi[0] = "Posizione";
					nomiCampi[1] = "Vettura";
					nomiCampi[2] = "Punti";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY7:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query7();
					nomiCampi[0] = "Posizione";
					nomiCampi[1] = "Tipo motore";
					nomiCampi[2] = "Vettura";
					nomiCampi[3] = "Punti";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY8:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query8();
					nomiCampi[0] = "Posizione";
					nomiCampi[1] = "Scuderia";
					nomiCampi[2] = "Rapporto punti/minuti";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY9:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query9();
					nomiCampi[0] = "Numero da gara";
					nomiCampi[1] = "Scuderia";
					nomiCampi[2] = "Modello";
					nomiCampi[3] = "Numero piloti";
					nomiCampi[4] = "Numero punti";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY10:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query10();
					nomiCampi[0] = "ID_Gara";
					nomiCampi[1] = "Circuito";
					nomiCampi[2] = "Nome";
					nomiCampi[3] = "Data";
					nomiCampi[4] = "Durata";
					nomiCampi[5] = "Tipo";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY11:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query11();
					nomiCampi[0] = "Gara";
					nomiCampi[1] = "Vettura";
					nomiCampi[2] = "Scuderia";
					nomiCampi[3] = "Punti";
					nomiCampi[4] = "Piazzamento";
					nomiCampi[5] = "Motivo ritiro";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY12:
					sceltaVettura.setVisible(false);
					sceltaGara.setVisible(true);
					String[] empty = {};
					tableModel = new TableModel(null, empty);
					table.setModel(tableModel);
					break;
				case QUERY13:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query13();
					nomiCampi[0] = "Nome";
					nomiCampi[1] = "Ragione sociale";
					nomiCampi[2] = "Sede";
					nomiCampi[3] = "Numero componenti";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY14:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query14();
					nomiCampi[0] = "ID_Pilota";
					nomiCampi[1] = "Vettura";
					nomiCampi[2] = "Nome";
					nomiCampi[3] = "Cognome";
					nomiCampi[4] = "Data nascita";
					nomiCampi[5] = "Nazionalità";
					nomiCampi[6] = "Data prima licenza";
					nomiCampi[7] = "Numero licenze";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY15:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(false);
					result = LoginPanel.db.query15();
					nomiCampi[0] = "ID_Pilota";
					nomiCampi[1] = "Vettura";
					nomiCampi[2] = "Scuderia";
					nomiCampi[3] = "Nome";
					nomiCampi[4] = "Cognome";
					nomiCampi[5] = "Data nascita";
					nomiCampi[6] = "Nazionalità";
					nomiCampi[7] = "Data prima licenza";
					nomiCampi[8] = "Quota";
					tableModel = new TableModel(result, nomiCampi);
					table.setModel(tableModel);
					break;
				case QUERY16:
					sceltaGara.setVisible(false);
					sceltaVettura.setVisible(true);
					String[] empty1 = {};
					tableModel = new TableModel(null, empty1);
					table.setModel(tableModel);
				}
			}
		});
		
		listaQuery.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					buttonCerca.doClick();
				}
			}
		});	
		
		checkVettura.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int vettura = Integer.parseInt(fieldVettura.getText());
				ResultSet result = LoginPanel.db.query16(vettura);
				String[] nomiCampi = {"Cambio", "Motore", "Telaio"};
				TableModel tableModel = new TableModel(result, nomiCampi);
				table.setModel(tableModel);

			}
		});
		
		checkGara.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int gara = Integer.parseInt(fieldGara.getText());
				ResultSet result = LoginPanel.db.query12(gara);
				String[] nomiCampi = {"Posizione", "Vettura", "Punti"};
				TableModel tableModel = new TableModel(result, nomiCampi);
				table.setModel(tableModel);
					
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
					checkVettura.doClick();
				}
			}
		});
		
		fieldGara.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkGara.doClick();
				}
			}
		});

		// Aggiungo listaQuery e buttonCerca al panelQuery
		panelQuery.add(listaQuery);
		panelQuery.add(buttonCerca);
		
		// Aggiungo componenti per scelta della gara (query12) in sceltaGara
		sceltaGara.add(labelGara);
		sceltaGara.add(fieldGara);
		sceltaGara.add(checkGara);
				
		// Aggiungo componenti per scelta della vettura (query14) in sceltaVettura
		sceltaVettura.add(labelVettura);
		sceltaVettura.add(fieldVettura);
		sceltaVettura.add(checkVettura);
		
		// Aggiungo sceltaGara e sceltaVettura al pannello di scelta
		scelta.add(sceltaGara);
		scelta.add(sceltaVettura);
		
		// Setto il layout del panelOutput
		panelOutput.setLayout(new BorderLayout());
		
		// Aggiungo l'oggetto table di tipo TablePane al panelOutput
		panelOutput.add(table, BorderLayout.CENTER);
		
		// Aggiungo il pannello di scelta al panelOutput
		panelOutput.add(scelta, BorderLayout.NORTH);
		
		// Setto il layout del pannello principale
		panel.setLayout(new BorderLayout());
		
		// Aggiungo panelQuery e panelOutput al pannello principale
		panel.add(panelQuery, BorderLayout.NORTH);
		panel.add(new JScrollPane(panelOutput), BorderLayout.CENTER);
		
		return panel;
	}
	
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	private final String QUERY1 = "1) Somma totale delle quote dei finanziamenti ricevute da ciascuna scuderia";
	private final String QUERY2 = "2) Stampa delle scuderie, compreso il numero di finanziamenti";
	private final String QUERY3 = "3) Piloti che hanno vinto nel circuito di casa";
	private final String QUERY4 = "4) Percentuale di gentleman driver di cui si compone l'equipaggio di ciascuna scuderia";
	private final String QUERY5 = "5) Stampa dei costruttori con il numero di componenti che hanno fornito";
	private final String QUERY6 = "6) Classifica delle vetture in base ai punti conseguiti";
	private final String QUERY7 = "7) Classifica delle vetture in base ai punti per tipo di motore";
	private final String QUERY8 = "8) Classifica delle scuderie sulla base del rapporto punti/minuti di gara";
	private final String QUERY9 = "9) Stampa delle vetture";
	private final String QUERY10 = "10) Stampa delle gare";
	private final String QUERY11 = "11) Stampa delle iscrizioni alle gare";
	private final String QUERY12 = "12) Classifica di una gara";
	private final String QUERY13 = "13) Stampa dei costruttori";
	private final String QUERY14 = "14) Stampa dei piloti";
	private final String QUERY15 = "15) Stampa dei gentleman driver";
	private final String QUERY16 = "16) Verifica della possibilità di montare un componente su una vettura";
}
