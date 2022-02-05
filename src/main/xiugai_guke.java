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
import java.sql.SQLException;

public class xiugai_guke extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private String idnum,name,member,password,bal;
	private static String idNUM;
	public boolean exit=false;
	
	class ActionImp implements Runnable{
		public void run()
		{
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public xiugai_guke() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdnum = new JLabel("IDNUM\uFF1A");
		lblIdnum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdnum.setBounds(48, 49, 68, 31);
		contentPane.add(lblIdnum);
		
		JLabel lblName = new JLabel("NAME\uFF1A");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(53, 107, 63, 31);
		contentPane.add(lblName);
		
		JLabel lblMemberornot = new JLabel("MEMBERORNOT\uFF1A");
		lblMemberornot.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMemberornot.setBounds(24, 164, 92, 31);
		contentPane.add(lblMemberornot);
		
		JLabel lblPassword = new JLabel("PASSWORD\uFF1A");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(48, 214, 68, 31);
		contentPane.add(lblPassword);
		
		JLabel lblBalance = new JLabel("BALANCE\uFF1A");
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setBounds(48, 264, 68, 31);
		contentPane.add(lblBalance);
		
		textField1 = new JTextField();
		textField1.setBounds(159, 59, 112, 21);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(159, 117, 112, 21);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(159, 174, 112, 21);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		
		textField4 = new JTextField();
		textField4.setBounds(159, 224, 112, 21);
		contentPane.add(textField4);
		textField4.setColumns(10);
		
		textField5 = new JTextField();
		textField5.setBounds(159, 274, 112, 21);
		contentPane.add(textField5);
		textField5.setColumns(10);
		
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new Enter());
		btnNewButton.setBounds(53, 322, 77, 31);
		contentPane.add(btnNewButton);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	class Enter implements ActionListener{
		
		   public void actionPerformed(ActionEvent e){
			
			if(e.getActionCommand().equals("OK")){
					
				Connection sin=DBConnection.getConnection();
				try {
					PreparedStatement ps;
					 ps=sin.prepareStatement("delete from CUSTOMER where IDNUM=?");
				    ps.setObject(1,idNUM);
					ps.execute();
				} catch (SQLException h) {
					// TODO Auto-generated catch block
					h.printStackTrace();
				}
						String Idnum=textField1.getText();
						String Name=textField2.getText();
						String Member=textField3.getText();
						String Password=textField4.getText();
						String Bal=textField5.getText();
						Object str[]={Idnum,Name,Member,Password,Bal};
						Connection s=DBConnection.getConnection();
						DBConnection.insert_guke(s, str);
						JOptionPane.showMessageDialog(null,"修改成功!","操作提示",JOptionPane.NO_OPTION );
				        dispose();
					
				
			   
			  }
		     }
		    }
	public void setidNUM()
	{
		this.idNUM=this.idnum;
	}
	public void setid(String id)
	{
		this.idnum=id;
		textField1.setText(idnum);
		validate();
	}
	public void setname(String name)
	{
		this.name=name;
		textField2.setText(name);
		validate();
	}
	public void setmember(String member)
	{
		this.member=member;
		textField3.setText(member);
		validate();
	}
	public void setpassword(String password)
	{
		this.password=password;
		textField4.setText(password);
		validate();
	}
	public void setbal(String bal)
	{
		this.bal=bal;
		textField5.setText(bal);
		validate();
	}
	
	public String getid()
	{
		return idnum;
	}
	public String getname()
	{
		return name;
	}
	public String getmember()
	{
		return member;
	}
	public String getpassword()
	{
		return password;
	}
	public String getbal()
	{
		return bal;
	}
	
	

}
