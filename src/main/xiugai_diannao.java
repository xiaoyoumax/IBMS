package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class xiugai_diannao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField1;
	private JTextField textField2;
	private String num,occu;
	private static String Num;

	/**
	 * Create the dialog.
	 */
	public xiugai_diannao() {
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNumber = new JLabel("NUMBER\uFF1A");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setBounds(52, 69, 92, 34);
		contentPanel.add(lblNumber);
		
		JLabel lblOccupiedornot = new JLabel("OCCUPIEDORNOT\uFF1A");
		lblOccupiedornot.setHorizontalAlignment(SwingConstants.CENTER);
		lblOccupiedornot.setBounds(52, 140, 92, 34);
		contentPanel.add(lblOccupiedornot);
		
		textField1 = new JTextField();
		textField1.setBounds(168, 76, 190, 27);
		contentPanel.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(168, 147, 190, 27);
		contentPanel.add(textField2);
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
				try {
					PreparedStatement ps;
					 ps=sin.prepareStatement("delete from COMPUTER where NUM=?");
				    ps.setObject(1,Num);
					ps.execute();
				} catch (SQLException h) {
					// TODO Auto-generated catch block
					h.printStackTrace();
				}
						String num=textField1.getText();
						String occu=textField2.getText();
						Object str[]={num,occu};
						Connection s=DBConnection.getConnection();
						DBConnection.insert_diannao(s, str);
						JOptionPane.showMessageDialog(null,"修改成功!","操作提示",JOptionPane.NO_OPTION );
				        dispose();
					
				
			   
			  }
		     }
		    }
	
	public void setNum()
	{
		this.Num=this.num;
	}
	public void setnum(String num)
	{
		this.num=num;
		textField1.setText(num);
		validate();
	}
	public void setoccu(String occu)
	{
		this.occu=occu;
		textField2.setText(occu);
		validate();
	}
}
