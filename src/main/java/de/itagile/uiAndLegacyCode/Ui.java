package de.itagile.uiAndLegacyCode;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ui extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JTextField input;
	private JButton doItButton;
	private JLabel label;

	public Ui() {
		initUI();
	}

	public final void initUI() {
		setTitle("Legacy Code and Ui");
		setSize(300, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		getContentPane().add(mainPanel);
		addTextField();
		addButton();
		addLabel();
	}

	private void addLabel() {
		label = new JLabel("Result:");
		mainPanel.add(label, BorderLayout.SOUTH);
	}

	private void addTextField() {
		input = new JTextField();
		mainPanel.add(input, BorderLayout.NORTH);
	}

	private void addButton() {
		doItButton = new JButton("Do it!");
		doItButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(input.getText().length()>=4) {
					label.setText(
							input.getText().charAt(0) + 
							new StringBuffer(input.getText().substring(1, input.getText().length()-1)).reverse().toString() + 
							input.getText().charAt(input.getText().length()-1));
				} else {
					label.setText("Result: "+ input.getText());
				}
			}
		});

		mainPanel.add(doItButton, BorderLayout.CENTER);
	}

}
