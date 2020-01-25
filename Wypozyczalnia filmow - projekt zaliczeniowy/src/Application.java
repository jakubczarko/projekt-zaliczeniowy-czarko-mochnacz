import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import tabs.ClientPanel;
import tabs.OrderPanel;
import tabs.SearchOrderPanel;
import tabs.UtilsPanel;
import tabs.VideoPanel;
import model.ClientSet;
import model.OrderSet;
import model.VideoSet;

public class Application {

	public OrderSet orderset = new OrderSet();
	public ClientSet clientset = new ClientSet();
	public VideoSet videoset = new VideoSet();

	/**
	 * Uruchomienie aplikacji
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Application();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Tworzenie aplikacji
	 */
	public Application() {
		initialize();
	}

	/**
	 * Inicjalizacja zawartosci ramki
	 */
	private void initialize() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EmptyBorder(0, 5, 0, 5));

		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);

		tabbedPane.addTab("Klienci", new ClientPanel(frame, clientset));
		tabbedPane.addTab("Filmy", new VideoPanel(frame, videoset));
		tabbedPane.addTab("Zamowienia", new OrderPanel(frame, orderset, clientset,
				videoset));
		tabbedPane.addTab("Wyszukaj", new SearchOrderPanel(frame, orderset,
				videoset, clientset));
		tabbedPane.addTab("Opcje", new UtilsPanel(frame, orderset, videoset,
				clientset));
		frame.pack();
		frame.setVisible(true);
	}

}
