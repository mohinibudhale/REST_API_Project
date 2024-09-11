package com.project.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public Personv1 getFirstVersionOfPerson()
	{
		return new Personv1("Bob C.");
	}
	
	@GetMapping("/v2/person")
	public Personv2 getSecondVersionOfPerson()
	{
		return new Personv2(new Name("Mona","B"));
	}
	
	@GetMapping(path="/person", params = "version=1")
	public Personv1 getFirstVersionOfPersonRequestPara()
	{
		return new Personv1("Bob C.");
	}
	
	@GetMapping(path="/person", params = "version=2")
	public Personv2 getSecondVersionOfPersonRequestPara()
	{
		return new Personv2(new Name("Mona","B"));
	}
	
	@GetMapping(path="/person/header", headers = "X-API-VERSION=1")
	public Personv1 getFirstVersionOfPersonRequestHeader()
	{
		return new Personv1("Bob C.");
	}
	
	@GetMapping(path="/person/header", headers = "X-API-VERSION=2")
	public Personv2 getSecondVersionOfPersonRequestHeader()
	{
		return new Personv2(new Name("Mona","B"));
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public Personv1 getFirstVersionOfPersonAcceptHeader() {
		return new Personv1("Bob Charlie");
	}

	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public Personv2 getSecondVersionOfPersonAcceptHeader() {
		return new Personv2(new Name("Bob", "Charlie"));
	}
}
