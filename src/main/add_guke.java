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

public class add_guke extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;

	

	/**
	 * Create the dialog.
	 */
	public add_guke() {
		setVisible(true);
		setBounds(100, 100, 473, 329);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIdnum = new JLabel("IDNUM\uFF1A");
		lblIdnum.setBounds(59, 37, 67, 23);
		lblIdnum.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblIdnum);
		
		JLabel lblName = new JLabel("NAME\uFF1A");
		lblName.setBounds(59, 70, 67, 23);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblName);
		{
			JLabel lblMemberornot = new JLabel("MEMBEROTNOT\uFF1A");
			lblMemberornot.setBounds(45, 103, 102, 23);
			lblMemberornot.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblMemberornot);
		}
		{
			JLabel lblPassword = new JLabel("PASSWORD\uFF1A");
			lblPassword.setBounds(59, 136, 67, 23);
			lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblPassword);
		}
		{
			JLabel lblBalance = new JLabel("BALANCE\uFF1A");
			lblBalance.setBounds(59, 169, 67, 23);
			lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblBalance);
		}
		
		textField1 = new JTextField();
		textField1.setBounds(158, 38, 160, 23);
		contentPanel.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(158, 71, 160, 23);
		textField2.setColumns(10);
		contentPanel.add(textField2);
		
		textField3 = new JTextField();
		textField3.setBounds(157, 104, 160, 23);
		textField3.setColumns(10);
		contentPanel.add(textField3);
		
		textField4 = new JTextField();
		textField4.setBounds(158, 137, 160, 23);
		textField4.setColumns(10);
		contentPanel.add(textField4);
		
		textField5 = new JTextField();
		textField5.setBounds(158, 170, 160, 23);
		textField5.setColumns(10);
		contentPanel.add(textField5);
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
				
				
					String idnum=textField1.getText();
					String name=textField2.getText();
					String member=textField3.getText();
					String password=textField4.getText();
					double bal=Double.parseDouble(textField5.getText());
					Object str[]={idnum,name,member,password,bal};
					Connection sin=DBConnection.getConnection();
					DBConnection.insert_guke(sin, str);
					JOptionPane.showMessageDialog(null,"添加成功!","操作提示",JOptionPane.NO_OPTION );
			        dispose();
			   
			  }
		 }
	}
}
