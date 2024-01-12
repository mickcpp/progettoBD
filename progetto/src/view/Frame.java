package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{

	private LoginPanel loginPanel;	
	private InterrogaPanel interrogaPanel;
	private ModificaPanel modificaPanel;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	
	public Frame() {
		// Creazione pannelli login, interroga e modifica
		createLoginPanel();
		createInterrogaPanel();
		createModificaPanel();
		
		// settaggio parametri frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setTitle("Login");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	
		// creazione pannello cardPanel con layout cardLayout
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		
		// aggiunta dei pannelli login, interroga e modifica a cardPanel
		cardPanel.add(loginPanel, "Login");
		cardPanel.add(interrogaPanel, "Interroga");
		cardPanel.add(modificaPanel, "Modifica");

		// aggiunta del pannello cardPanel al frame
		add(cardPanel, BorderLayout.CENTER);
		
		// mostra pannello login
		cardLayout.show(cardPanel, "Login");
		
		// Aggiunge un keyEventDispatcher al componente che ha attualmente il focus
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0); // Chiude l'applicazione quando viene premuto ESC
                }
                return false; // Non consuma l'evento
            }
        });

	}

	public void createLoginPanel() {
		loginPanel = new LoginPanel();
		loginPanel.setFrame(this);
	}
	
	public void createInterrogaPanel() {
		interrogaPanel = new InterrogaPanel();
		interrogaPanel.setFrame(this);
	}
	
	public void createModificaPanel() {
		modificaPanel = new ModificaPanel();
		modificaPanel.setFrame(this);
	}
	
	public void switchToInterrogaPanel() {
		cardLayout.show(cardPanel, "Interroga");
		setSize(1050, 620);
		setLocationRelativeTo(null);
	}	 
	
	public void switchToModificaPanel() {
		cardLayout.show(cardPanel, "Modifica");
		setSize(1050, 620);
		setLocationRelativeTo(null);
	}	
	
}
