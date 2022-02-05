package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class chaxun_diannao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	
	/**
	 * Create the dialog.
	 */
	public chaxun_diannao() {
		setVisible(true);
		setBounds(100, 100, 431, 278);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNumber = new JLabel("NUMBER\uFF1A");
			lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumber.setBounds(62, 82, 79, 26);
			contentPanel.add(lblNumber);
		}
		{
			textField = new JTextField();
			textField.setBounds(151, 85, 163, 23);
			contentPanel.add(textField);
			textField.setColumns(10);
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
				
			     Connection sin=DBConnection.getConnection();
					int num=Integer.parseInt(textField.getText());
					ResultSet rs=null;
					PreparedStatement ps=null;
					try {
						ps=sin.prepareStatement("select* from COMPUTER where NUM=?");
					    ps.setObject(1,num);
						rs=ps.executeQuery();
						while(rs.next()){
						String msg=rs.getString("NUM")+"    "+rs.getString("OCCUPIEDORNOT")+"\n";
						JOptionPane.showMessageDialog(null,msg,"²éÑ¯½á¹û£º",JOptionPane.NO_OPTION );
						}
						}catch (SQLException h) {
							// TODO Auto-generated catch block
							h.printStackTrace();
						}
					}
			        dispose();
			   
			   
			  }
	}
}
