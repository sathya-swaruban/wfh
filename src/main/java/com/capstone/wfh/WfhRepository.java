package com.capstone.wfh;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WfhRepository extends MongoRepository<WfhRequest, String> {
}
