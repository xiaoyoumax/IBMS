package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PT {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public PT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 674, 515);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu_1 = new JMenu("\u7CFB\u7EDF");
		menuBar.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA\u767B\u9646");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu_1.add(menuItem);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}
}
