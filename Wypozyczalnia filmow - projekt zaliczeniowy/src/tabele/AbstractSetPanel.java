package tabs;

import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import model.Set;
import actions.LoadAction;
import actions.RemoveAction;
import actions.SaveAction;

public abstract class AbstractSetPanel extends JPanel {


	private static final long serialVersionUID = -5940176757902363013L;

	static void standardButton(JFrame frame, JList<?> list, JPanel panel,
			Set<?> set) {
		// Przycisk Wczytaj
		JButton btnLoad = new JButton("Wczytaj");
		btnLoad.addActionListener(new LoadAction(frame, set));
		panel.add(btnLoad);

		// Przycisk Zapisz
		JButton btnSave = new JButton("Zapisz");
		btnSave.addActionListener(new SaveAction(frame, set));
		panel.add(btnSave);

		// Przycisk Usun Wybrane
		JButton btnRemove = new JButton("Usun wybrane");
		btnRemove.addActionListener(new RemoveAction(frame, list, set));
		panel.add(btnRemove);
	}

	public AbstractSetPanel() {
		super();
	}

	public AbstractSetPanel(LayoutManager layout) {
		super(layout);
	}

	public AbstractSetPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public AbstractSetPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

}