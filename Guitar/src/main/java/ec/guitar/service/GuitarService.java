package ec.guitar.service;

import java.util.List;
import ec.guitar.dao.GuitarDao;
import ec.guitar.po.Guitar;
import ec.guitar.po.Inventory;

public class GuitarService {
	public GuitarService() {
		super();
	}
	private GuitarDao guitarDao;
	private Inventory inventory;
	public void setGuitarDao(GuitarDao guitarDao) {
		this.guitarDao = guitarDao;
	}
	
	public GuitarService(GuitarDao guitarDao){
		this.guitarDao = guitarDao;
	}
	
	public Guitar getAll(){
		return guitarDao.getAll();
		
	}
	
	public List<Guitar> search(Guitar ErinLikes) throws Exception{
		
		Inventory.guitars=guitarDao.search();
		return inventory.search(ErinLikes);

	}
}
