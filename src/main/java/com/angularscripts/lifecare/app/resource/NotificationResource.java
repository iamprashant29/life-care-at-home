package com.angularscripts.lifecare.app.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.angularscripts.lifecare.app.entity.Notification;
import com.angularscripts.lifecare.app.service.NotificationService;

@Component
@Path("/notifications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationResource {

	@Autowired
	NotificationService notificationService;
	
	@POST
	public Response createNotification(Notification notification) {
		Notification createdNotification = notificationService.createNotification(notification);
		if(createdNotification!=null) {
			return Response.status(Status.CREATED).entity(createdNotification).build();
		}else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	public Response getActiveNotifications() {
		List<Notification> activeNotifications = notificationService.getActiveNotifications();
		if(activeNotifications!=null) {
			if(activeNotifications.size()>0) {
				return Response.status(Status.OK).entity(activeNotifications).build();
			}else {
				return Response.status(Status.NO_CONTENT).build();
			}
		}else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
