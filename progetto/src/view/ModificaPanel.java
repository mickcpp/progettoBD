package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ModificaPanel extends JPanel{
	
	private JPanel controlPanel;
	private JPanel modifyPanel;
	private Frame frame;
	private InserisciPanel1 inserisciPanel1;
	private InserisciPanel2 inserisciPanel2;
	private InserisciPanel3 inserisciPanel3;
	private InserisciPanel4 inserisciPanel4;
	private InserisciPanel5 inserisciPanel5;
	private InserisciPanel6 inserisciPanel6;
	private DeletePanel deletePanel;
	
	public ModificaPanel() {
		
		controlPanel = createControlPanel();
		modifyPanel = createModifyPanel();
		
		setLayout(new BorderLayout());
		
		add(controlPanel, BorderLayout.NORTH);
		add(modifyPanel, BorderLayout.CENTER);
	}
	
	public JPanel createControlPanel() {
		
		JRadioButton radioInterroga;
		JRadioButton radioModifica;
		ButtonGroup buttonGroup;
		
		controlPanel = new JPanel();
		
		radioInterroga = new JRadioButton("Interroga");
		radioModifica = new JRadioButton("Modifica");
		
		// Imposto di default radioModifica a "selezionato"
		radioModifica.setSelected(true);
		
		radioInterroga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(radioInterroga.isSelected()) {
					frame.switchToInterrogaPanel();
					radioModifica.setSelected(true);
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
	
	public JPanel createModifyPanel() {
		
		JPanel panel;
		JPanel panelQuery;
		CardLayout cardLayout = new CardLayout();
		JPanel cardPanelInput = new JPanel(cardLayout);
		
		JComboBox listaQuery;
		JButton buttonCerca;
		JTextArea textArea;
		
		panelQuery = new JPanel();
		listaQuery = new JComboBox();
		buttonCerca = new JButton("Seleziona");
		
		listaQuery.addItem(INSERT1);
		listaQuery.addItem(INSERT2);
		listaQuery.addItem(INSERT3);
		listaQuery.addItem(INSERT4);
		listaQuery.addItem(INSERT5);
		listaQuery.addItem(INSERT6);
		listaQuery.addItem(DELETE);
		
		buttonCerca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String query = (String) listaQuery.getSelectedItem();
				
				switch(query) {
				case INSERT1:
					cardLayout.show(cardPanelInput, "INSERT1");
					break;
				case INSERT2:
					cardLayout.show(cardPanelInput, "INSERT2");
					break;
				case INSERT3:
					cardLayout.show(cardPanelInput, "INSERT3");
					break;
				case INSERT4:
					cardLayout.show(cardPanelInput, "INSERT4");
					break;
				case INSERT5:
					cardLayout.show(cardPanelInput, "INSERT5");
					break;
				case INSERT6:
					cardLayout.show(cardPanelInput, "INSERT6");
					break;
				case DELETE:
					cardLayout.show(cardPanelInput, "DELETE");
					break;
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

		panelQuery.add(listaQuery);
		panelQuery.add(buttonCerca);
		
	
		inserisciPanel1 = createInsertPanel1();
		inserisciPanel2 = createInsertPanel2();
		inserisciPanel3 = createInsertPanel3();
		inserisciPanel4 = createInsertPanel4();
		inserisciPanel5 = createInsertPanel5();
		inserisciPanel6 = createInsertPanel6();
		deletePanel = createDeletePanel();
		
		cardPanelInput.add(inserisciPanel1, "INSERT1");
		cardPanelInput.add(inserisciPanel2, "INSERT2");
		cardPanelInput.add(inserisciPanel3, "INSERT3");
		cardPanelInput.add(inserisciPanel4, "INSERT4");
		cardPanelInput.add(inserisciPanel5, "INSERT5");
		cardPanelInput.add(inserisciPanel6, "INSERT6");
		cardPanelInput.add(deletePanel, "DELETE");
		
		
		panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		panel.add(panelQuery, BorderLayout.NORTH);
		panel.add(cardPanelInput, BorderLayout.CENTER);
		
		return panel;
	}
	
	public InserisciPanel1 createInsertPanel1() {
		inserisciPanel1 = new InserisciPanel1();
		return inserisciPanel1;
	}
	
	public InserisciPanel2 createInsertPanel2() {
		inserisciPanel2 = new InserisciPanel2();
		return inserisciPanel2;
	}
	
	public InserisciPanel3 createInsertPanel3() {
		inserisciPanel3 = new InserisciPanel3();
		return inserisciPanel3;
	}
	
	public InserisciPanel4 createInsertPanel4() {
		inserisciPanel4 = new InserisciPanel4();
		return inserisciPanel4;
	}
	
	public InserisciPanel5 createInsertPanel5() {
		inserisciPanel5 = new InserisciPanel5();
		return inserisciPanel5;
	}
	
	public InserisciPanel6 createInsertPanel6() {
		inserisciPanel6 = new InserisciPanel6();
		return inserisciPanel6;
	}
	
	public DeletePanel createDeletePanel() {
		deletePanel = new DeletePanel();
		return deletePanel;
	}
	
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	private final String INSERT1 = "1) Registra una scuderia";
	private final String INSERT2 = "2) Registra una vettura e i componenti di cui è composta";
	private final String INSERT3 = "3) Registra un nuovo pilota";
	private final String INSERT4 = "4) Registra un gentleman driver";
	private final String INSERT5 = "5) Iscrivi una vettura ad una gara";
	private final String INSERT6 = "6) Registra i risultati di una gara";
	private final String DELETE = "7) Elimina un componente di una vettura";
	
}

