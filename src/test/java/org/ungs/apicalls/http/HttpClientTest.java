package org.ungs.apicalls.http;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.ungs.apicalls.api.Endpoints;
import org.ungs.apicalls.dtos.ClientDto;
import org.ungs.apicalls.dtos.ClientResponseDto;
import org.ungs.apicalls.dtos.CredentialsDto;
import org.ungs.apicalls.dtos.OrdersResponseDto;
import org.ungs.apicalls.json.JsonParser;

import com.google.gson.Gson;

public class HttpClientTest {

	private Endpoints endpoints = Endpoints.getInstance();
	private Gson parser = JsonParser.getParser();

	@Test
	public void unauthorizedClientTest() {
		
		HttpClient client = new HttpClient();
		HttpResponse res = client.get(endpoints.clientsEndpoint());
		
		assertEquals(HttpStatusCodes.UNAUTHORIZED, res.getCode());
		
	}
	
	@Test
	public void clientTest() {
		
		HttpClient client = new HttpClient();
		client.setToken("TokenValido");
		
		HttpResponse res = client.get(endpoints.clientsEndpoint());
		
		ClientResponseDto responseDto = parser.fromJson(res.getBody(), ClientResponseDto.class);
		
		assertEquals(HttpStatusCodes.OK, res.getCode());
		assertEquals(responseDto.getClients().size(), 3);
		
	}
	
	@Test
	public void ordersTest() {
		HttpClient client = new HttpClient();
		client.setToken("TokenValido");
		
		HttpResponse res = client.get(endpoints.ordersEndpoint());
		
		OrdersResponseDto responseDto = parser.fromJson(res.getBody(), OrdersResponseDto.class);
		
		assertEquals(HttpStatusCodes.OK, res.getCode());
		assertEquals(responseDto.getOrders().size(), 1);
	}
	
	@Test
	public void authTest() {
		HttpClient client = new HttpClient();
		
		HttpRequest req = new HttpRequest();
		req.setBody(parser.toJson(new CredentialsDto("user", "pass")));
		
		HttpResponse res = client.post(endpoints.authEndpoint(), req);
		
		assertEquals(HttpStatusCodes.OK, res.getCode());
		assertEquals("TokenValido", res.getBody());
	}
	
	@Test
	public void authAdminTest() {
		HttpClient client = new HttpClient();
		
		HttpRequest req = new HttpRequest();
		req.setBody(parser.toJson(new CredentialsDto("admin", "pass")));
		
		HttpResponse res = client.post(endpoints.authEndpoint(), req);
		
		assertEquals(HttpStatusCodes.OK, res.getCode());
		assertEquals("SuperToken", res.getBody());
	}
	
	@Test
	public void authWrongCredentialsTest() {
		HttpClient client = new HttpClient();
		
		HttpRequest req = new HttpRequest();
		req.setBody(parser.toJson(new CredentialsDto("user", "password")));
		
		HttpResponse res = client.post(endpoints.authEndpoint(), req);
		
		assertEquals(HttpStatusCodes.UNAUTHORIZED, res.getCode());
	}

}
