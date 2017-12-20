package com.angularscripts.lifecare.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angularscripts.lifecare.app.entity.Request;
import com.angularscripts.lifecare.app.repository.RequestRepository;
import com.angularscripts.lifecare.app.utils.EmailUtils;

@Service
public class RequestService {

	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	EmailUtils emailUtils;
	
	public Request createRequest(Request request) throws Exception {
		Request createdRequest = requestRepository.save(request);
		return createdRequest;
	}
	
	public void sendEmail(Request request) throws Exception {
		emailUtils.sendRequestEmail(request);
		emailUtils.sendAcknowledgementMail(request);
	}
}
