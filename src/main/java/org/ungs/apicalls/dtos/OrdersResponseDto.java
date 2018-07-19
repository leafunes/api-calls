package org.ungs.apicalls.dtos;

import java.util.ArrayList;
import java.util.List;

public class OrdersResponseDto {

	private List<OrderDto> orders;
	
	public OrdersResponseDto() {
	
		this.orders = new ArrayList<>();
	}

	public List<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}
	
	
	
	
}
