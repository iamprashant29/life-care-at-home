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

import com.angularscripts.lifecare.app.entity.Feedback;
import com.angularscripts.lifecare.app.service.FeedbackService;

@Component
@Path("/feedbacks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FeedbackResource {

	@Autowired
	FeedbackService feedbackService;
	
	@POST
	public Response createFeedback(Feedback feedback) {
		Feedback createdFeedback = feedbackService.createFeedback(feedback);
		if(createdFeedback!=null) {
			return Response.status(Status.CREATED).entity(createdFeedback).build();
		}else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
