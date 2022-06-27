package com.marjana.smartwork.enums;

public enum TypeEnum {
	
	Work(0),
	Cellphone(1), 
	Home(2);
	
	private int type;
	
	public int value() {return this.value();}
	
	TypeEnum(int type)
	{
		this.type=type;
	}
	
}
