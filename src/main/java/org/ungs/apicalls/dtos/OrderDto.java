package org.ungs.apicalls.dtos;

import java.math.BigDecimal;

public class OrderDto {
	
	private int ID;
	private BigDecimal quantity;
	private ClientDto client;
	
	
	public OrderDto() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public ClientDto getClient() {
		return client;
	}
	public void setClient(ClientDto client) {
		this.client = client;
	}
	
	

}
