package com.example.demo.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rest.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/demo/user")
public class UserRestController {

	private static final String USER_TOPIC = "topic.notif.user";
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@RequestMapping(method = RequestMethod.GET, 
			path="{id}", produces = MediaType.APPLICATION_JSON)
	public User getUser(
		@PathVariable("id") 
		String id) {		
		//get user from db
		if(id.equals("1")) {
			User user = new User();
			user.setId("1");
			user.setName("prasune");
			user.setType("Admin");
			List<String> roles = new ArrayList<>();
			roles.add("VIEW");
			roles.add("MANAGE");
			user.setRoles(roles);
			return user;
		}
		throw new IllegalArgumentException("User with id " + id + " not found");
	}

	@RequestMapping(method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public User createUser(@RequestBody User user) throws JsonProcessingException {		
		// store user to DB
		
		// publish a kafka message for notifying other micro-services
		ObjectMapper mapper = new ObjectMapper();
		kafkaTemplate.send(USER_TOPIC, user.getId(), mapper.writeValueAsString(user));
		return user;
	}
}
