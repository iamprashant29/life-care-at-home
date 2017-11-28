package com.angularscripts.lifecare.app.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class TestResource {

	@GET
	public String test() {
		return "Hello Jersey!!!!";
	}
}
