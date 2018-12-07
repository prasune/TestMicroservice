package com.prasune.spring.security.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/rest")
public class AdminController {

	@GetMapping(path="/hello")
	public String hello() {
		return "hello admin";
	}
}
