package com.capstone.wfh.repository;

import com.capstone.wfh.model.WfhRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WfhRepository extends MongoRepository<WfhRequest, String> {

    List<WfhRequest> findByFromDate(String fromDate);

}
