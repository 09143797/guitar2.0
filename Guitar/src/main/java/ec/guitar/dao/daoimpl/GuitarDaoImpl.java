package ec.guitar.dao.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ec.guitar.dao.GuitarDao;
import ec.guitar.dbutil.Dbutil;
import ec.guitar.po.Guitar;
import ec.guitar.po.Inventory;

public abstract class GuitarDaoImpl implements GuitarDao {
	

	 private List guitars;

	  public GuitarDaoImpl() {
	    guitars = new LinkedList();
	  }
	  
	public Guitar getAll() {
		Guitar guitar = new Guitar(null, 0, null, null, null, null, null);
		String sql="select * from inv_inf";
		try{
			Connection conn = DriverManager.getConnection("jdbc:sqlite://g:/r/Navicat for SQLite/sql.db");
			Statement stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
		
			while(rs.next()){					
				guitar = new Guitar(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				//guitars.add(guitar);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		//guitars.add(guitar);
		return guitar;
	}

	public List<Guitar> search(){
		// TODO Auto-generated method stub
		String sql="select * from inv_inf";
		List<Guitar> list =new LinkedList();
		
		try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			Connection conn = DriverManager.getConnection("jdbc:sqlite://g:/r/Navicat for SQLite/sql.db"); 
			Statement stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			//rs.setString(1, serialNumber);
			while(rs.next()){
				Guitar guitar=new Guitar(rs.getString("serialNumber"), rs.getDouble("price"), rs.getString("builder"),
									rs.getString("model"),rs.getString("type"), rs.getString("backWood"), 
									rs.getString("topWood"));
					list.add(guitar);
					
					
					    
					      return list;
					    }
					    return list;
									  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return list;
					}
	

}
