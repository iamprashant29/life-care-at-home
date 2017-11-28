package com.angularscripts.lifecare.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.angularscripts.lifecare.app.entity.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, String> {
	
	List<Notification> findByIsActive(boolean isActive);
	
}
