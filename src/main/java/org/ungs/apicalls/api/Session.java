package org.ungs.apicalls.api;

import org.ungs.apicalls.dtos.CredentialsDto;

public class Session {

	private static Session instance;
	
	public static Session getSession() {
		if(instance == null)
			instance = new Session();
		return instance;
	}
	
	public static void disposeSession() {
		instance = null;
	}
	
	private String token;
	
	private Session() {
		token = "";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
