package com.angularscripts.lifecare.app.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.angularscripts.lifecare.app.resource.FeedbackResource;
import com.angularscripts.lifecare.app.resource.JobCandidateResource;
import com.angularscripts.lifecare.app.resource.NotificationResource;
import com.angularscripts.lifecare.app.resource.RequestResource;

@Configuration
@ApplicationPath("lifecare/app")
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		register(JobCandidateResource.class);
		register(MultiPartFeature.class);
		register(FeedbackResource.class);
		register(RequestResource.class);
		register(NotificationResource.class);
	}

}
