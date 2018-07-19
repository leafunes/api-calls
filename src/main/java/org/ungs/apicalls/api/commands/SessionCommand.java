package org.ungs.apicalls.api.commands;

import org.ungs.apicalls.api.Session;

public abstract class SessionCommand  extends BaseCommand implements Command{
	
	protected String token;
	
	public SessionCommand() {
		super();
		this.token = Session.getSession().getToken();
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	

}
