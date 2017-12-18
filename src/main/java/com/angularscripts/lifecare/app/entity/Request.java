package com.angularscripts.lifecare.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="RequestId", unique=true)
	String requestId;
	@Column(name="ContactPerson")
	String contactPersonName;
	@Column(name="ServiceRequested")
	String serviceRequested;
	@Column(name="City")
	String city;
	@Column(name="Address")
	String address;
	@Column(name="EmailId")
	String emailId;
	@Column(name="ContactNo")
	String contactNumber;
	@Column(name="PatientName")
	String patientName;
	@Column(name="PatientGender")
	String patientGender;
	@Column(name="PatientAge")
	String patientAge;
	@Column(name="Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	Date date;
	
	public Request() {
		
	}
	
	public Request(String requestId, String contactPersonName, String serviceRequested, String city,
			String address, String emailId, String contactNumber, String patientName, String patientGender,
			String patientAge, Date date) {
		super();
		this.requestId = requestId;
		this.contactPersonName = contactPersonName;
		this.serviceRequested = serviceRequested;
		this.city = city;
		this.address = address;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.date = date;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getServiceRequested() {
		return serviceRequested;
	}

	public void setServiceRequested(String serviceRequested) {
		this.serviceRequested = serviceRequested;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setcontactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((contactPersonName == null) ? 0 : contactPersonName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((patientAge == null) ? 0 : patientAge.hashCode());
		result = prime * result + ((patientGender == null) ? 0 : patientGender.hashCode());
		result = prime * result + ((patientName == null) ? 0 : patientName.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((serviceRequested == null) ? 0 : serviceRequested.hashCode());
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
		Request other = (Request) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (contactPersonName == null) {
			if (other.contactPersonName != null)
				return false;
		} else if (!contactPersonName.equals(other.contactPersonName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (patientAge == null) {
			if (other.patientAge != null)
				return false;
		} else if (!patientAge.equals(other.patientAge))
			return false;
		if (patientGender == null) {
			if (other.patientGender != null)
				return false;
		} else if (!patientGender.equals(other.patientGender))
			return false;
		if (patientName == null) {
			if (other.patientName != null)
				return false;
		} else if (!patientName.equals(other.patientName))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (serviceRequested == null) {
			if (other.serviceRequested != null)
				return false;
		} else if (!serviceRequested.equals(other.serviceRequested))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceRequest [requestId=" + requestId + ", contactPersonName=" + contactPersonName
				+ ", serviceRequested=" + serviceRequested + ", city=" + city + ", address=" + address + ", emailId="
				+ emailId + ", contactNumber=" + contactNumber + ", patientName=" + patientName + ", patientGender="
				+ patientGender + ", patientAge=" + patientAge + ", date=" + date + "]";
	}
	
}
