package org.ungs.apicalls.api.commands;

import org.ungs.apicalls.http.HttpResponse;

public interface Command {

	HttpResponse execute();
	
}
