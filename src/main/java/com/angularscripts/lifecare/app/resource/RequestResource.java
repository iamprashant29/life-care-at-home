package com.angularscripts.lifecare.app.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.angularscripts.lifecare.app.entity.Request;
import com.angularscripts.lifecare.app.service.RequestService;

@Component
@Path("/requests")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RequestResource {

	@Autowired
	RequestService requestService;
	
	@POST
	public Response createRequest(Request request) {
		Request createdRequest = requestService.createRequest(request);
		if(createdRequest!=null) {
			return Response.status(Status.CREATED).entity(createdRequest).build();	
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
