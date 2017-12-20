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
		Request createdRequest;
		try {
			createdRequest = requestService.createRequest(request);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		if(createdRequest!=null) {
			return Response.status(Status.CREATED).entity(createdRequest).build();	
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	@Path("/email")
	public Response sendEmail(Request request) throws Exception {
		requestService.sendEmail(request);
		return Response.status(Status.OK).build();
	}
}
