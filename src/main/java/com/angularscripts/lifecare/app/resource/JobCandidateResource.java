package com.angularscripts.lifecare.app.resource;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.angularscripts.lifecare.app.entity.JobCandidate;
import com.angularscripts.lifecare.app.service.JobCandidateService;

@Component
@Path("/candidate")

public class JobCandidateResource {

	@Autowired
	JobCandidateService jobCandidateService;
	
	@POST
	@Path("/resume/upload") 
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadResume(@FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition file) {
		String filePath = jobCandidateService.uploadResume(fileInputStream, file);
		if(filePath!=null) {
			return Response.status(Status.OK).entity(filePath).build();
		}else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveJobCandidateDetails(JobCandidate jobCandidate) {
		JobCandidate savedJobCandidate  = jobCandidateService.storeJobCandidateDetails(jobCandidate);
		if(savedJobCandidate!=null) {
			return Response.status(Status.OK).entity(savedJobCandidate).build();
		}else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
  }
