package com.example.demo.rest;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@RequestMapping(method = RequestMethod.GET, 
			value = "/hello", 
			produces = MediaType.APPLICATION_JSON)
	public String hola() throws UnknownHostException {
		String hostname = null;
		try {
			hostname = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			hostname = "unknown";
		}
		return "Hola Spring Boot de " + hostname;

	}

}
