package org.ungs.apicalls.dtos;

import java.util.ArrayList;
import java.util.List;

public class ClientResponseDto {
	
	private List<ClientDto> clients;
	
	public ClientResponseDto() {
		clients = new ArrayList<>();
	}

	public List<ClientDto> getClients() {
		return clients;
	}

	public void setClients(List<ClientDto> clients) {
		this.clients = clients;
	}
	
	

}
