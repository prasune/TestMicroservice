package com.user;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Test;

import org.junit.Assert;

public class AuthenticationRestTest {

	@Test
	public void testSayPlainTextHello() {
        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());

        String json =
                target.path("rest").path("user").request().accept(MediaType.APPLICATION_JSON).get(String.class);
        
        Assert.assertEquals("{\"message\":\"Hello Jersey\"}", json);
    }

	private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/AuthService").build();
    }
}
