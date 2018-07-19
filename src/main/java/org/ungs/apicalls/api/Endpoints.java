package org.ungs.apicalls.api;

import java.net.MalformedURLException;
import java.net.URL;

public class Endpoints {

	private static Endpoints instance;
	
	public static Endpoints getInstance() {
		if(instance == null)
			instance = new Endpoints();
		return instance;
	}
	
	private URL clientsEndpoint;
	private URL ordersEndpoint;
	private URL authEndpoint;
	private String prefix;
	
	private Endpoints() {
		prefix = "http://192.160.0.1";
		try {
			clientsEndpoint = new URL(prefix + "/api/clients");
			ordersEndpoint = new URL(prefix + "/api/orders");
			authEndpoint = new URL(prefix + "/api/auth");
		} catch (MalformedURLException ingnored) {
		}
	}
	
	public URL clientsEndpoint() {
		return clientsEndpoint;
	}
	
	public URL ordersEndpoint() {
		return ordersEndpoint;
	}

	public URL authEndpoint() {
		return authEndpoint;
	}
	
}
