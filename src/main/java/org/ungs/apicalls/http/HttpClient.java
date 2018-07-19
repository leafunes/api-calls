package org.ungs.apicalls.http;

import java.net.URL;

import org.ungs.apicalls.api.Endpoints;

public class HttpClient {

	private Endpoints endpoints = Endpoints.getInstance();
	
	public HttpResponse get(URL url) {
		//TODO: Mockeado
		if(url.equals(endpoints.clientsEndpoint())) {
			return buildClientsResponse();
		}
		return null;
	}
	
	public HttpResponse post(URL url, HttpRequest req) {
		return null;
	}
	
	private HttpResponse buildClientsResponse() {
		return new HttpResponse(HttpStatusCodes.UNAUTHORIZED, "");
	}
}
