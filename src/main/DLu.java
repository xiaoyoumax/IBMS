package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class DLu{
	
	private final static String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USER="CS";
	private final static String PASSWORD="cug";
	private final static String DRIVER="oracle.jdbc.OracleDriver";
	private static Connection conn=null;
	
	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DLu window = new DLu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/*
	 * 连接数据库
	 */
	public static Connection getConnection(){
		if(conn!=null){
			return conn;
		}else{
			try{
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("连接建立成功，已连接数据库");
			}catch(ClassNotFoundException e){
				System.err.println("驱动加载失败");
				e.printStackTrace();
			}catch(SQLException e){
				System.err.println("链接建立失败");
				e.printStackTrace();
			}
			return conn;
		}
	}
	
	/*
	 * 普通登陆
	 */
	private static boolean login(String username,String password)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=getConnection();
			String sql="select count(1) from CUSTOMER where IDNUM=? and PASSWORD=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				int result=rs.getInt(1);
				return result>0;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * 管理员登陆
	 */
	private static boolean loginP(String username,String password)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=getConnection();
			String sql="select count(1) from ADMINISTRATOR where ACCOUNT=? and PASSWORD=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				int result=rs.getInt(1);
				return result>0;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Create the application.
	 */
	public DLu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setSize(414,253);
		frame.setLocation(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setBounds(30, 35, 149, 40);
		frame.getContentPane().add(label);
		label.setBackground(Color.LIGHT_GRAY);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(29, 83, 149, 40);
		frame.getContentPane().add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField1 = new JTextField();
		textField1.setBounds(169, 35, 151, 34);
		frame.getContentPane().add(textField1);
		textField1.setColumns(15);
		
		textField2 = new JTextField();
		textField2.setBounds(168, 91, 152, 34);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		JButton button1 = new JButton("\u666E\u901A\u767B\u9646");
		button1.setForeground(Color.BLACK);
		button1.setFont(new Font("宋体", Font.PLAIN, 12));
		button1.setBackground(Color.WHITE);
		button1.setBounds(87, 162, 89, 34);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean result=login(textField1.getText(),textField2.getText());
				if(result)
				{
					System.out.println("Login Successfully...");
					PT p=new PT();
				}else
				{
					System.out.println("Login Defealted...");
				}
			}
		});
		frame.getContentPane().add(button1);
		
		JButton button2 = new JButton("\u7BA1\u7406\u5458\u767B\u9646");
		button2.setFont(new Font("宋体", Font.PLAIN, 12));
		button2.setBackground(Color.WHITE);
		button2.setBounds(210, 162, 99, 34);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean result=loginP(textField1.getText(),textField2.getText());
				if(result)
				{
					System.out.println("Login Successfully...");
					ADMIN ad=new ADMIN();
					
				}else
				{
					System.out.println("Login Defealted...");
				}
			}
		});
		frame.getContentPane().add(button2);
	}

}
