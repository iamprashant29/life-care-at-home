package com.angularscripts.lifecare.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.angularscripts.lifecare.app.entity.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, String> {

}
