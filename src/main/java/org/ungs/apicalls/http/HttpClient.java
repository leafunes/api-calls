package org.ungs.apicalls.http;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.ungs.apicalls.api.Endpoints;
import org.ungs.apicalls.dtos.ClientDto;
import org.ungs.apicalls.dtos.ClientResponseDto;
import org.ungs.apicalls.dtos.CredentialsDto;
import org.ungs.apicalls.dtos.OrderDto;
import org.ungs.apicalls.dtos.OrdersResponseDto;
import org.ungs.apicalls.json.JsonParser;

import com.google.gson.Gson;

public class HttpClient {
	
	private Endpoints endpoints;
	private String token;
	private Gson parser;
	
	public HttpClient() {
		token = "";
		endpoints = Endpoints.getInstance();
		parser = JsonParser.getParser();
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public HttpResponse get(URL url) {
		//TODO: Mockeado
		if(url.equals(endpoints.clientsEndpoint())) {
			return buildClientsResponse();
		}else if(url.equals(endpoints.ordersEndpoint())) {
			return buildOrdersResponse();
		}
		return null;
	}
	
	public HttpResponse post(URL url, HttpRequest req) {
		//TODO: mockeado
		
		if(url.equals(endpoints.authEndpoint())) {
			return buildAuth(parser.fromJson(req.getBody(), CredentialsDto.class));
		}
		return null;
	}
	
	private HttpResponse buildClientsResponse() {
		if(!token.equals("TokenValido"))return new HttpResponse(HttpStatusCodes.UNAUTHORIZED, "");

		
		return new HttpResponse(HttpStatusCodes.OK, parser.toJson(getClients()));
	}
	
	private HttpResponse buildOrdersResponse() {
		if(!token.equals("TokenValido")) return new HttpResponse(HttpStatusCodes.UNAUTHORIZED, "");
		
		return new HttpResponse(HttpStatusCodes.OK, parser.toJson(getOrders()));
	}
	
	private HttpResponse buildAuth(CredentialsDto dto) {
		
		if(dto.getUser().equals("user") && dto.getPassword().equals("pass")) {
			String body = "TokenValido";
			HttpResponse res = new HttpResponse(HttpStatusCodes.OK, body);
			return res;
		}else if(dto.getUser().equals("admin") && dto.getPassword().equals("pass")) {
			String body = "SuperToken";
			HttpResponse res = new HttpResponse(HttpStatusCodes.OK, body);
			return res;
		}else {
			return new HttpResponse(HttpStatusCodes.UNAUTHORIZED, ""); 
		}
	}
	
	private ClientResponseDto getClients(){
		
		List<ClientDto> dtos = new ArrayList<>();
		ClientDto c1 = new ClientDto();
		c1.setID(1);
		c1.setName("Leandro");
		

		ClientDto c2 = new ClientDto();
		c1.setID(2);
		c1.setName("Juan");
		

		ClientDto c3 = new ClientDto();
		c1.setID(3);
		c1.setName("Pedro");
		
		dtos.add(c1);
		dtos.add(c2);
		dtos.add(c3);
		
		ClientResponseDto toRet = new ClientResponseDto();
		
		toRet.setClients(dtos);
		
		return toRet;
	}
	
	private OrdersResponseDto getOrders(){
		
		List<OrderDto> dtos = new ArrayList<>();
		

		ClientDto c1 = new ClientDto();
		c1.setID(1);
		c1.setName("Leandro");
		
		OrderDto o1 = new OrderDto();
		o1.setID(1);
		o1.setQuantity(new BigDecimal("20"));
		o1.setClient(c1);
		
		dtos.add(o1);
		OrdersResponseDto toRet = new OrdersResponseDto();
		
		toRet.setOrders(dtos);
		
		return toRet;
	}
	
	
}
