package main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {
	
	
	public DBConnection(){
		
	}
	/*
	 * 连接
	 */
	public final static Connection getConnection(){
		Connection conn=null;
		try{
		String DRIVER="oracle.jdbc.OracleDriver";
		String URL="jdbc:oracle:thin:@localhost:1521:xe";
		String USER="CS";
		String PASSWORD="cug";
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL, USER, PASSWORD);
	}catch(Exception e){
	    e.printStackTrace();
	}
		return conn;
	}
	
	/*
	 * 添加顾客
	 */
	public final static void insert_guke(Connection conn,Object obj[]){
		PreparedStatement ps=null;
		try{
			ps=conn.prepareStatement("insert into CUSTOMER(IDNUM,NAME,MEMBERORNOT,PASSWORD,BALANCE)values(?,?,?,?,?)");
			ps.setString(1, obj[0].toString());
			ps.setString(2, obj[1].toString());
			ps.setString(3, obj[2].toString());
			ps.setString(4, obj[3].toString());
			ps.setString(5, obj[4].toString());
			ps.execute();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Default","操作失败",JOptionPane.NO_OPTION );
		}
	}
	/*
	 * 添加电脑
	 */
	public final static void insert_diannao(Connection conn,Object obj[]){
		PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement("insert into COMPUTER(NUM,OCCUPIEDORNOT)values(?,?)");
				ps.setInt(1, Integer.parseInt(obj[0].toString()));
				ps.setString(2, obj[1].toString());
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Default","操作失败",JOptionPane.NO_OPTION );
			}
			
		
	}
	/*
	 * 查询所有顾客数据
	 */
	public final static ResultSet query(Connection con){
		
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement("select * from CUSTOMER");
			 rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//删除数据
	public final static void delete(Connection conn,String s){
		try {
			PreparedStatement ps;
			 ps=conn.prepareStatement("delete from CUSTOMER where IDNUM=?");
		    ps.setObject(1,s);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
	}
	public final static boolean importDB()throws InterruptedException
	{
		String USER="CS";
		String PASSWORD="cug";
		String filePATH="C:\\Documents and Settings\\Administrator\\桌面";
		String fromUSER=USER;
		String SID="XE";
		String toUSRE=USER;
		try{
			Process process=Runtime.getRuntime().exec("imp"+USER+"/"+PASSWORD+"@"+SID+"frmoUSER="+fromUSER+"tousr="+toUSRE+"file="+filePATH+".dmp");
			if(process.waitFor()==0){
				return true;
			}
		}catch(IOException i)
		{
			i.printStackTrace();
		}
		return false;
	}
	public final static boolean exportDB()throws InterruptedException
	{
		String USER="CS";
		String PASSWORD="cug";
		String savePATH="C:/Documents and Settings/Administrator/桌面";
		String SID="PLSExtProc";
		String fileNAME="test";
		File saveFile = new File(savePATH);
		if (!saveFile.exists()) {// 如果目录不存在
			saveFile.mkdirs();// 创建文件夹
		}
		try {
			Process process = Runtime.getRuntime().exec("exp " + USER + "/" + PASSWORD + "@" + SID + " file=" + savePATH + "/" + fileNAME + ".dmp");
			if(process.waitFor() == 0){//0 表示线程正常终止。 
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
		/*String USER="CS";
		String PASSWORD="cug";
		String port="1521";
		String database="IBMS";
		String backupfile="test";
		String mysqlPath="C:/Documents and Settings/Administrator/桌面";
		 String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s   -hlocalhost   -P%d %s -r \"%s\"";
		 
	     String command = String.format(commandFormat, mysqlPath, USER, PASSWORD,port ,database, backupfile);
	        try {
				Runtime.getRuntime().exec(command);
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return false;
	}	*/
}
