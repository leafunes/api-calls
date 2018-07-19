package org.ungs.apicalls.api.commands;

import org.ungs.apicalls.api.Endpoints;
import org.ungs.apicalls.dtos.CredentialsDto;
import org.ungs.apicalls.http.HttpRequest;
import org.ungs.apicalls.http.HttpResponse;
import org.ungs.apicalls.json.JsonParser;

public class PostAuthCommand extends BaseCommand{

	private CredentialsDto credentials;
	
	public PostAuthCommand(CredentialsDto credentials) {
		this.credentials = credentials;
	}
	
	@Override
	public HttpResponse execute() {
		
		HttpRequest req = new HttpRequest();
		req.setBody(JsonParser.getParser().toJson(credentials));
		
		return client.post(Endpoints.getInstance().authEndpoint(), req);
		
	}

}
