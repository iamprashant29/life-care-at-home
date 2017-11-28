package com.angularscripts.lifecare.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angularscripts.lifecare.app.entity.Notification;
import com.angularscripts.lifecare.app.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	NotificationRepository notificationRepository;
	
	public Notification createNotification(Notification notification) {
		List<Notification> activeNotifications = notificationRepository.findByIsActive(true);
		if(activeNotifications.size()<5) {
			return notificationRepository.save(notification);
		}else {
			return null;
		}
	}
	
	public List<Notification> getActiveNotifications(){
		return notificationRepository.findByIsActive(true);
	}
}
