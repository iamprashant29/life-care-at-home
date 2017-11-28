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
@Produces(MediaType.MULTIPART_FORM_DATA)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class JobCandidateResource {

	@Autowired
	JobCandidateService jobCandidateService;
	@POST
	@Path("/resume/upload")  
	public Response saveJobCandidateDetails(@FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition file,
            @FormDataParam("candidate") JobCandidate candidate) {
		String filePath = jobCandidateService.uploadResume(fileInputStream, file);
		if(filePath!=null) {
			candidate.setCvFilePath(filePath);
			System.out.println(candidate);
			JobCandidate jobCandidate = jobCandidateService.storeJobCandidateDetails(candidate);
			return Response.status(Status.CREATED).entity(jobCandidate).build();
		}else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
  }
