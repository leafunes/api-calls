package org.ungs.apicalls.exceptions;

public class UnauthorizedException extends RuntimeException{

	public UnauthorizedException() {
		super("Not allowed");
	}
	
}
