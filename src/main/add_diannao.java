package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class add_diannao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField1;
	private JTextField textField2;

	
	/**
	 * Create the dialog.
	 */
	public add_diannao() {
		setVisible(true);
		setBounds(100, 100, 450, 274);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNumber = new JLabel("NUMBER\uFF1A");
			lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumber.setBounds(46, 25, 74, 32);
			contentPanel.add(lblNumber);
		}
		{
			JLabel lblOccupiedornot = new JLabel("OCCUPIEDORNOT\uFF1A");
			lblOccupiedornot.setHorizontalAlignment(SwingConstants.CENTER);
			lblOccupiedornot.setBounds(23, 97, 97, 32);
			contentPanel.add(lblOccupiedornot);
		}
		{
			textField1 = new JTextField();
			textField1.setBounds(151, 31, 158, 26);
			contentPanel.add(textField1);
			textField1.setColumns(10);
		}
		{
			textField2 = new JTextField();
			textField2.setColumns(10);
			textField2.setBounds(151, 103, 158, 26);
			contentPanel.add(textField2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new Enter());
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	class Enter implements ActionListener{
		
		   public void actionPerformed(ActionEvent e){
				
			if(e.getActionCommand().equals("OK")){
				
				
					int num=Integer.parseInt(textField1.getText());
					String occu=textField2.getText();
					Object str[]={num,occu};
					Connection sin=DBConnection.getConnection();
					DBConnection.insert_diannao(sin, str);
					JOptionPane.showMessageDialog(null,"添加成功!","提示",JOptionPane.NO_OPTION );
			        dispose();
			   
			  }
		 }
	}
}
