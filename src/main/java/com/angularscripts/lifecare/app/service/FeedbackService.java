package com.angularscripts.lifecare.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angularscripts.lifecare.app.entity.Feedback;
import com.angularscripts.lifecare.app.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepository;
	
	public Feedback createFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}
}
