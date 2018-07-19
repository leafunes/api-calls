package org.ungs.apicalls.http;

public class HttpResponse {

	private HttpStatusCodes code;
	private String body;
	
	public HttpResponse(HttpStatusCodes code, String body) {
		super();
		this.code = code;
		this.body = body;
	}
	
	
	public HttpStatusCodes getCode() {
		return code;
	}
	public String getBody() {
		return body;
	}
	
	
	
}
