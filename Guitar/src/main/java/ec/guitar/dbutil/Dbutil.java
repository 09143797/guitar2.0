package ec.guitar.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Dbutil {


	
	public static Connection getConnection(){
		 Connection conn=null;
		 try{
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite://g:/r/Navicat for SQLite/sql.db"); 
				Statement stmt = conn.createStatement();
				conn.close();
				}catch(Exception e){
				e.printStackTrace();
				}
		 return conn;
	 }
	
	
	 
	 public static void closeAll(ResultSet rs,Statement st,Connection conn){
		 try{
			 if(rs!=null) rs.close();
			 if(st!=null) st.close();
			 if(conn!=null) conn.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }

}
