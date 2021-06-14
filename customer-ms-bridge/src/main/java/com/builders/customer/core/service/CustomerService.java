package com.builders.customer.core.service;

import com.builders.customer.core.search.CustomerSearch;
import com.builders.customer.core.to.CustomerTO;

import java.util.Set;

public interface CustomerService {
    CustomerTO create(CustomerTO customer);
    CustomerTO update(CustomerTO customer);

    CustomerTO delete(String email);

    Set<CustomerTO> list(CustomerSearch search);
}
