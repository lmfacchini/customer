package com.builders.customer.core.repository;

import com.builders.customer.domain.CustomerVO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerVO, ObjectId> {
    CustomerVO findByEmail(String email);
}
