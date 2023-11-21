package com.capstone.wfh;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WfhRepository extends MongoRepository<WfhRequest, String> {
    List<WfhRequest> findByFromDate(String fromDate);
}
