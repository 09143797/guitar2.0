package ec.guitar.action;

import ec.guitar.po.*;
import ec.guitar.service.GuitarService;

public class SearchGuitarAction extends Inventory{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GuitarService guitarService=new GuitarService();
	
	private String builder;
	private String model;
	private String type;
	private String backWood;
	private String topWood;
	
	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBackWood() {
		return backWood;
	}

	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}



	public String getTopWood() {
		return topWood;
	}

	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}

	Guitar ErinLikes = new Guitar("",0,getBuilder(),getModel(),getType(),getBackWood(),getTopWood());

	
	public String execute() throws  Exception{
		//GuitarDaoImpl guitarDaoImpl=new GuitarDaoImpl();
		//guitarService.setGuitarDao(guitarDaoImpl);
		if(guitarService.search(ErinLikes)!=null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	}

