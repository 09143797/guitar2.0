package ec.guitar.dao;

import java.util.List;
import ec.guitar.po.Guitar;
import ec.guitar.po.Inventory;

public interface GuitarDao {
	public Guitar getAll();
	public List<Guitar> search();
}
