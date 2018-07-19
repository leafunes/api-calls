package org.ungs.apicalls.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.ungs.apicalls.api.commands.GetClientsCommand;
import org.ungs.apicalls.api.commands.PostAuthCommand;
import org.ungs.apicalls.dtos.ClientResponseDto;
import org.ungs.apicalls.dtos.CredentialsDto;
import org.ungs.apicalls.exceptions.UnauthorizedException;
import org.ungs.apicalls.json.JsonParser;

public class ApiTest {

	Api api;
	CredentialsDto userCredentials = new CredentialsDto("user", "pass");
	
	@Before
	public void before() {
		api = new Api();
	}
	
	@Test(expected = UnauthorizedException.class)
	public void unauthorizedTest() {
		
		GetClientsCommand command = new GetClientsCommand();
		api.execute(command);
		
	}
	
	@Test
	public void getClientsTest() {
		
		PostAuthCommand authCommand = new  PostAuthCommand(userCredentials);
		String token = api.execute(authCommand);
		
		Session.getSession().setToken(token);

		GetClientsCommand command = new GetClientsCommand();
		String json = api.execute(command);
		
		ClientResponseDto dto = JsonParser.getParser().fromJson(json, ClientResponseDto.class);
		
		assertEquals(3, dto.getClients().size());
		
	}
	
}
