package org.ungs.apicalls.api;

import org.ungs.apicalls.api.commands.Command;
import org.ungs.apicalls.api.commands.PostAuthCommand;
import org.ungs.apicalls.dtos.CredentialsDto;
import org.ungs.apicalls.exceptions.UnauthorizedException;
import org.ungs.apicalls.http.HttpResponse;

public class Api {

	private String token;
	private CredentialsDto credentials;
	
	public Api() {
		
		credentials = new CredentialsDto("", "");
		
	}
	
	public String execute(Command command) {
		
		HttpResponse res = command.execute();
		
		switch(res.getCode()) {
			case OK:
				break;
			case SERVER_ERROR:
				break;
			case UNAUTHORIZED:
				throw new UnauthorizedException();
		}
		
		return res.getBody();
		
	}
	
	
}
