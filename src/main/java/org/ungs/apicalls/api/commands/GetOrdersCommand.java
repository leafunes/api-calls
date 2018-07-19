package org.ungs.apicalls.api.commands;

import org.ungs.apicalls.api.Endpoints;
import org.ungs.apicalls.http.HttpResponse;

public class GetOrdersCommand extends SessionCommand{

	public GetOrdersCommand() {
		super();
	}
	
	@Override
	public HttpResponse execute() {
		
		client.setToken(token);
		return client.get(Endpoints.getInstance().ordersEndpoint());
		
	}

}
