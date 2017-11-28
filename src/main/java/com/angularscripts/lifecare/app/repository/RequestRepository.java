package com.angularscripts.lifecare.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.angularscripts.lifecare.app.entity.Request;

@Repository
public interface RequestRepository extends CrudRepository<Request, String>{

}
