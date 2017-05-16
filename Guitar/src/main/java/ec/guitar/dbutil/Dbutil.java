package ec.guitar.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Dbutil {

	static {
	// TODO Auto-generated method stub
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:sql.db"); 
			Statement stmt = conn.createStatement();
			conn.close();
			}catch(Exception e){
			e.printStackTrace();
			}
	}
	
	public static Connection getConnection(){
		 Connection conn=null;
		 try {
			 conn= DriverManager.getConnection("jdbc:sqlite:sql.db");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conn;
	 }
	
	 public static boolean executeUpdate(String sql,Object[] args){
		 boolean sign=false;
		 PreparedStatement pst=null;
		 try{
			 Connection conn=Dbutil.getConnection();
			 pst=conn.prepareStatement(sql);
			 if(args!=null&&args.length>0){
				 for(int i=0;i<args.length;i++){
					 pst.setObject(i+1, args[i]);
				 }
			 }
			 int rows=pst.executeUpdate();
			 sign=rows>0?true:false;
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return sign;
	 }
	 
	 public static ResultSet executeQuery(String sql,Object[] args){
		 PreparedStatement pst=null;
		 ResultSet rs=null;
		 try{
			 Connection conn=Dbutil.getConnection();
			 pst=conn.prepareStatement(sql);
			 if(args!=null&&args.length>0){
				 for(int i=0;i<args.length;i++){
					 pst.setObject(i+1, args[i]);
				 }
			 }
			 rs=pst.executeQuery();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return rs;
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
