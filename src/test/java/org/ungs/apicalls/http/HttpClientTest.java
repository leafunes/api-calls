package org.ungs.apicalls.http;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.ungs.apicalls.api.Endpoints;

public class HttpClientTest {

	private Endpoints endpoints = Endpoints.getInstance();
	

	@Test
	public void test() {
		
		HttpClient client = new HttpClient();
		HttpResponse res = client.get(endpoints.clientsEndpoint());
		
		assertEquals(HttpStatusCodes.UNAUTHORIZED, res.getCode());
		
	}

}
