package com.angularscripts.lifecare.app.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.angularscripts.lifecare.app.entity.JobCandidate;

@Repository
public interface JobCandidateRepository extends CrudRepository<JobCandidate, UUID> {

}
