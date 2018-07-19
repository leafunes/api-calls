package org.ungs.apicalls.dtos;

public class ClientDto {

	private int ID;
	private String name;
	
	public ClientDto() {
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
