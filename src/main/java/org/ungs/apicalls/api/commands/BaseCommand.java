package org.ungs.apicalls.api.commands;

import org.ungs.apicalls.http.HttpClient;

public abstract class BaseCommand implements Command{

	protected HttpClient client;
	
	public BaseCommand() {
		client = new HttpClient();
		client.setToken("");
	}

	public HttpClient getClient() {
		return client;
	}

	public void setClient(HttpClient client) {
		this.client = client;
	}
	
	
	
}
