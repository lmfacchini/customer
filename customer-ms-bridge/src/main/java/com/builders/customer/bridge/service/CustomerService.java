package com.builders.customer.bridge.service;

import com.builders.customer.bridge.search.CustomerSearch;
import com.builders.customer.bridge.to.CustomerTO;

import java.util.Set;

public interface CustomerService {
    CustomerTO create(CustomerTO customer);
    CustomerTO update(CustomerTO customer);

    CustomerTO delete(String email);

    Set<CustomerTO> list(CustomerSearch search);
}
