package org.ungs.apicalls.api.commands;

import org.ungs.apicalls.api.Endpoints;
import org.ungs.apicalls.api.Session;
import org.ungs.apicalls.http.HttpResponse;

public class GetClientsCommand extends SessionCommand{
	
	public GetClientsCommand() {
		super();
	}

	@Override
	public HttpResponse execute() {
		
		client.setToken(token);
		return client.get(Endpoints.getInstance().clientsEndpoint());
		
	}
	
	
	
}
