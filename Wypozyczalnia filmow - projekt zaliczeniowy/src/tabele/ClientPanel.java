package tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.Client;
import model.ClientSet;
import core.ClientDialog;

public class ClientPanel extends AbstractSetPanel {

	private static final long serialVersionUID = 1154784217374141115L;
	private JFrame frame;
	private ClientSet clientset;
	private JList<Client> list = new JList<>();

	public ClientPanel(JFrame frame, ClientSet clientset) {
		this.frame = frame;
		this.clientset = clientset;
		initialize();
	}

	private JScrollPane _makeScrollPane() {
		JScrollPane scrollPane = new JScrollPane();
		list.setModel(clientset);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(list);
		return scrollPane;
	}

	private void initialize() {
		this.setLayout(new BorderLayout(0, 0));
		this.add(_makeScrollPane(), BorderLayout.NORTH);

		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.SOUTH);

		// Przycisk Dodaj
		JButton btnAdd = new JButton("Dodaj");

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClientDialog dialog = new ClientDialog(frame, "Nowy klient");
				if (dialog.getStatus()) {
					clientset.addElement(dialog.getObject());
					JOptionPane.showMessageDialog(frame, dialog.getObject()
							+ " zostala zapisana!");
				}
				;
			}
		});
		panel.add(btnAdd);

		// Przycisk Edytuj Wybrane
		JButton btnEdit = new JButton("Edytuj wybrane");
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Client selectedObject = list.getSelectedValue();
				if (selectedObject == null) {
					return;
				}
				ClientDialog vw = new ClientDialog(frame, selectedObject
						.getName(), selectedObject);
				if (vw.getStatus()) {
					JOptionPane.showMessageDialog(frame, selectedObject
							+ " zostala zapisana!");
				}
			}
		});
		panel.add(btnEdit);
		super.standardButton(frame, list, panel, clientset);
	}
}
