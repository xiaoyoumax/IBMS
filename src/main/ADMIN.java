package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;

import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ListSelectionModel;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionListener;

import javax.swing.JScrollBar;

public class ADMIN extends JFrame{

	private JFrame frame;
	private JTable table;
	private final Action action = new SwingAction();
	Vector<String> columname=new Vector<String>();
	Vector<Vector<Object>> dataVector=new Vector<Vector<Object>>();
	DefaultTableModel model;
	
	
	private static Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private static boolean exit=false;
	
	public static void setexit(boolean e)
	{
		exit=e;
	}
	/**
	 * Create the application.
	 */
	
	public ADMIN() {
		initialize();
	}

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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 508);
		frame.getContentPane().setLayout(null);
		
		DLu dlu=new DLu();
		conn=dlu.getConnection();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 805, 33);
		frame.getContentPane().add(menuBar);
		
		JMenu menu = new JMenu("\u67E5\u770B");
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u987E\u5BA2\u4FE1\u606F");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="select * from CUSTOMER";
				try {
					dataVector.removeAllElements();
					columname.removeAllElements();
					
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					String IDNUM,NAME,MEMBER,PASSWORD;
					double BAL;
					columname.add("IDNUM");
					columname.add("NAME");
					columname.add("MEMBERORNOT");
					columname.add("PASSWORD");
					columname.add("BALANCE");
					/*Vector<Object>v=new Vector<Object>();
					v.add("IDNUM");
					v.add("NAME");
					v.add("MEMBERORNOT");
					v.add("PASSWORD");
					v.add("BALANCE");
					dataVector.add(v);*/
					while(rs.next())
					{
						Vector<Object>vec=new Vector<Object>();
						for(int i=1;i<=5;i++)
							vec.add(rs.getObject(i));
						dataVector.add(vec);
						
					}
					model=new DefaultTableModel();
					model.setDataVector(dataVector,columname);
					table.setModel(model);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		menu.add(mntmNewMenuItem);
		
		JMenuItem menuItem_7 = new JMenuItem("\u7535\u8111\u72B6\u6001");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {/**********************************查看所有电脑信息*********/
				String sql="select * from COMPUTER";
				try {
					dataVector.removeAllElements();
					columname.removeAllElements();
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					columname.add("NUM");
					columname.add("OCCUPIEDORNOT");
					/*Vector<Object>v=new Vector<Object>();
					v.add("NUM");
					v.add("OCCUPIEDORNOT");
					dataVector.add(v);*/
					while(rs.next())
					{
						Vector<Object>vec=new Vector<Object>();
						for(int i=1;i<=2;i++)
							vec.add(rs.getObject(i));
						dataVector.add(vec);
						
					}
					model=new DefaultTableModel();
					model.setDataVector(dataVector,columname);
					table.setModel(model);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		menu.add(menuItem_7);
		
		JMenu menu_1 = new JMenu("\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenu menu_4 = new JMenu("\u67E5\u8BE2");
		menu_1.add(menu_4);
		
		JMenuItem menuItem_6 = new JMenuItem("\u987E\u5BA2");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {/*************查询顾客****************/
				//查询顾客
				chaxun_guke cx=new chaxun_guke();
			}
		});
		menu_4.add(menuItem_6);
		
		JMenuItem menuItem_8 = new JMenuItem("\u7535\u8111");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chaxun_diannao cx=new chaxun_diannao();/*************************查询电脑**********/
			}
		});
		menu_4.add(menuItem_8);
		
		JMenu menu_6 = new JMenu("\u4FEE\u6539");
		menu_1.add(menu_6);
		
		JMenuItem menuItem_1 = new JMenuItem("\u987E\u5BA2");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {/***********************修改顾客信息************/
				String IDNUM,NAME,MEMBER,PASSWORD,BAL;
				int count=1;
				if(table.getSelectedRow()>0)
				{
					count=table.getSelectedRow();
				}
				
				IDNUM=table.getValueAt(count, 0).toString();
				NAME=table.getValueAt(count, 1).toString();
				MEMBER=table.getValueAt(count, 2).toString();
				PASSWORD=table.getValueAt(count, 3).toString();
				BAL=table.getValueAt(count, 4).toString();
				xiugai_guke xg1=new xiugai_guke();

				xg1.setid(IDNUM);
				xg1.setname(NAME);
				xg1.setpassword(PASSWORD);
				xg1.setmember(MEMBER);
				xg1.setbal(BAL);
				xg1.setidNUM();
			}
		});
		menu_6.add(menuItem_1);
		
		JMenuItem menuItem_10 = new JMenuItem("\u7535\u8111");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {/***************************************修改电脑信息**********/
				String num,occu;
				int count=1;
				if(table.getSelectedRow()>0)
				{
					count=table.getSelectedRow();
				}
				
				num=table.getValueAt(count, 0).toString();
				occu=table.getValueAt(count, 1).toString();
				xiugai_diannao xg2=new xiugai_diannao();
				xg2.setnum(num);
				xg2.setoccu(occu);
				xg2.setNum();
			}
		});
		menu_6.add(menuItem_10);
		
		JMenu menu_7 = new JMenu("\u589E\u52A0");
		menu_1.add(menu_7);
		
		JMenuItem menuItem_11 = new JMenuItem("\u987E\u5BA2");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {/********************增加顾客***************/
					add_guke ad=new add_guke();		
			}
		});
		menu_7.add(menuItem_11);
		
		JMenuItem menuItem_12 = new JMenuItem("\u7535\u8111");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add_diannao ad=new add_diannao();/*********************************增加电脑**************/
			}
		});
		menu_7.add(menuItem_12);
		
		JMenu menu_2 = new JMenu("\u4F1A\u5458");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u67E5\u770B\u4F1A\u5458");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {/**********************查看所有顾客信息*********/
				String sql="select * from CUSTOMER WHERE MEMBERORNOT='T'";
				try {
					dataVector.removeAllElements();
					columname.removeAllElements();
					DLu dlu=new DLu();
					//System.out.println("hello");
					conn=dlu.getConnection();
					//System.out.println("world");
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					String IDNUM,NAME,MEMBER,PASSWORD;
					double BAL;
					columname.add("IDNUM");
					columname.add("NAME");
					columname.add("MEMBERORNOT");
					columname.add("PASSWORD");
					columname.add("BALANCE");
					/*Vector<Object>v=new Vector<Object>();
					v.add("IDNUM");
					v.add("NAME");
					v.add("MEMBERORNOT");
					v.add("PASSWORD");
					v.add("BALANCE");
					dataVector.add(v);*/
					while(rs.next())
					{
						Vector<Object>vec=new Vector<Object>();
						for(int i=1;i<=5;i++)
							vec.add(rs.getObject(i));
						dataVector.add(vec);
						
					}
					model=new DefaultTableModel();
					model.setDataVector(dataVector,columname);
					table.setModel(model);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6CE8\u518C\u4F1A\u5458");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {/***************************注册会员***********/
				add_guke ad=new add_guke();	
			}
		});
		menu_2.add(menuItem_2);
		
		JMenu menu_3 = new JMenu("\u7CFB\u7EDF");
		menuBar.add(menu_3);
		
		
		JMenuItem menuItem_4 = new JMenuItem("\u9000\u51FA\u767B\u9646");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {/******************************退出系统***********/
				System.exit(0);
			}
		});
		menu_3.add(menuItem_4);
		
		table = new JTable();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		table.setToolTipText("");
		table.setBounds(10, 53, 743, 345);
		//frame.getContentPane().add(table);
		
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(10, 53, 743, 345);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
