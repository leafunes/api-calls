package org.ungs.apicalls.json;

import com.google.gson.Gson;

public class JsonParser {

	private static Gson instance;
	
	public static Gson getParser() {
		
		if(instance == null)
			instance = new Gson();
		return instance;
		
	}
	
}
