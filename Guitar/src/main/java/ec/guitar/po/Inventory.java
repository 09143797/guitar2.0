package ec.guitar.po;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import ec.guitar.dbutil.Dbutil;
import ec.guitar.po.Guitar;

public class Inventory extends ActionSupport{
  private List guitars;

  public Inventory() {
    guitars = new LinkedList();
  }

  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
	  Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    	
    guitars.add(guitar);
  }
  
  
  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }
  
  /*public List search(Guitar searchGuitar) {
	  List Guitarslist = new LinkedList();   		
	  for (Iterator i = guitars.iterator(); i.hasNext(); ) {
	      Guitar guitar = (Guitar)i.next();
	      // Ignore serial number since that's unique
	      // Ignore price since that's unique
	      String builder = searchGuitar.getBuilder();
	      if ((builder != null) && (!builder.equals("")) &&
	          (!builder.equals(guitar.getBuilder())))
	        continue;
	      String model = searchGuitar.getModel();
	      if ((model != null) && (!model.equals("")) &&
	          (!model.equals(guitar.getModel())))
	        continue;
	      String type = searchGuitar.getType();
	      if ((type != null) && (!searchGuitar.equals("")) &&
	          (!type.equals(guitar.getType())))
	        continue;
	      String backWood = searchGuitar.getBackWood();
	      if ((backWood != null) && (!backWood.equals("")) &&
	          (!backWood.equals(guitar.getBackWood())))
	        continue;
	      String topWood = searchGuitar.getTopWood();
	      if ((topWood != null) && (!topWood.equals("")) &&
	          (!topWood.equals(guitar.getTopWood())))
	        continue;
	      Guitarslist.add(guitar);
	    }
	    return Guitarslist;
	  }*/
  
  public Guitar search(Guitar searchGuitar) {
	    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
	      Guitar guitar = (Guitar)i.next();
	      // Ignore serial number since that's unique
	      // Ignore price since that's unique
	      String builder = searchGuitar.getBuilder();
	      if ((builder != null) && (!builder.equals("")) &&
	          (!builder.equals(guitar.getBuilder())))
	        continue;
	      String model = searchGuitar.getModel();
	      if ((model != null) && (!model.equals("")) &&
	          (!model.equals(guitar.getModel())))
	        continue;
	      String type = searchGuitar.getType();
	      if ((type != null) && (!searchGuitar.equals("")) &&
	          (!type.equals(guitar.getType())))
	        continue;
	      String backWood = searchGuitar.getBackWood();
	      if ((backWood != null) && (!backWood.equals("")) &&
	          (!backWood.equals(guitar.getBackWood())))
	        continue;
	      String topWood = searchGuitar.getTopWood();
	      if ((topWood != null) && (!topWood.equals("")) &&
	          (!topWood.equals(guitar.getTopWood())))
	        continue;
	      return guitar;
	    }
	    return null;
	  }
}
