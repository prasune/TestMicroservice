package com.user;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationRest {

	@GET
	public String sayPlainTextHello() {
		return "{\"message\":\"Hello Jersey\"}";
	}

}
