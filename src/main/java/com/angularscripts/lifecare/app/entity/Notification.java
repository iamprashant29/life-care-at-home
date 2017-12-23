package com.angularscripts.lifecare.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Entity
public class Notification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NotificationId")
	private String notificationId;
	@Column(name="Title")
	private String title;
	@Column(name="Message")
	private String message;
	@Column(name="IsActive")
	private boolean isActive;
	@Column(name="CreateDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date createdDate;
	@Column(name="ActiveHours")
	private int activeHours;
	
	public Notification() {
	
	}

	public Notification(String notificationId, String title, String message, boolean isActive, Date createdDate,
			int activeHours) {
		super();
		this.notificationId = notificationId;
		this.title = title;
		this.message = message;
		this.isActive = isActive;
		this.createdDate = createdDate;
		this.activeHours = activeHours;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getActiveHours() {
		return activeHours;
	}

	public void setActiveHours(int activeHours) {
		this.activeHours = activeHours;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activeHours;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((notificationId == null) ? 0 : notificationId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		if (activeHours != other.activeHours)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (isActive != other.isActive)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (notificationId == null) {
			if (other.notificationId != null)
				return false;
		} else if (!notificationId.equals(other.notificationId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notofication [notificationId=" + notificationId + ", title=" + title + ", message=" + message
				+ ", isActive=" + isActive + ", createdDate=" + createdDate + ", activeHours=" + activeHours + "]";
	}
	
	
	
	
}
