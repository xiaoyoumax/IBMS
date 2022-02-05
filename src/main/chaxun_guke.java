package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class chaxun_guke extends JFrame {
	private ADMIN pare;
	private JPanel contentPane;
	private JTextField textField;
	private String id;
	public boolean exit;
	

	/**
	 * Create the frame.
	 */
	public chaxun_guke()
	{
		//this.exit=exit;
		init();
	}
	
	public void init() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdnum = new JLabel("IDNUM\uFF1A");
		lblIdnum.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdnum.setBounds(52, 41, 95, 35);
		contentPane.add(lblIdnum);
		
		textField = new JTextField();
		textField.setBounds(157, 41, 139, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new Enter());
		btnOk.setBounds(351, 44, 93, 29);
		contentPane.add(btnOk);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	class Enter implements ActionListener{
		
		   public void actionPerformed(ActionEvent e){
			
			if(e.getActionCommand().equals("OK")){
				
			     Connection sin=DBConnection.getConnection();
					String idnum=textField.getText();
					ResultSet rs=null;
					PreparedStatement ps=null;
					try {
						
						 ps=sin.prepareStatement("select * from CUSTOMER where IDNUM=?");
					    ps.setObject(1,idnum);
						rs=ps.executeQuery();
						while(rs.next()){
						String msg=rs.getString("IDNUM")+"    "+rs.getString("NAME")+"    "+rs.getString("MEMBERORNOT")+"    "+rs.getString("PASSWORD")+"    "+rs.getString("BALANCE")+"\n";
						JOptionPane.showMessageDialog(null,msg,"²éÑ¯½á¹û£º",JOptionPane.NO_OPTION );
						}
					 		
						} catch (SQLException h) {
							// TODO Auto-generated catch block
							h.printStackTrace();
						}
					}
				
					
			        dispose();
			   
			   
			  }
		     }
	public String getid()
	{
		return id;
	}
	
}
