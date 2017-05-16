package ec.guitar.dao.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ec.guitar.dao.GuitarDao;
import ec.guitar.dbutil.Dbutil;
import ec.guitar.po.Guitar;
import ec.guitar.po.Inventory;

public abstract class GuitarDaoImpl implements GuitarDao {
	@Override
	public boolean add() {
		// TODO Auto-generated method stub
		return Dbutil.executeUpdate("insert into inv_inf values(?,?,?,?,?,?,?)",new Object[]{});		
	}

	 private List guitars;

	  public GuitarDaoImpl() {
	    guitars = new LinkedList();
	  }
	  
	public Guitar getAll() {
		Guitar guitar = new Guitar(null, 0, null, null, null, null, null);
		Dbutil db=new Dbutil();
		String sql="select * from inv_inf";
		try{
			Connection conn = db.getConnection();; 
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

	public List<Guitar> search(String builder) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from inv_inf where builder=?";
		Dbutil db=new Dbutil();
		List<Guitar> list =new LinkedList();
		try {
			Connection conn = db.getConnection();; 
			Statement stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			//rs.setString(1, serialNumber);
			while(rs.next()){
				Guitar guitar=new Guitar(rs.getString("serialNumber"), rs.getDouble("price"), rs.getString("builder"),
									rs.getString("model"),rs.getString("type"), rs.getString("bacwood"), 
									rs.getString("topwood"));
					list.add(guitar);	
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
