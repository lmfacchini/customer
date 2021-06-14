package com.builders.customer.core.dao;

import com.builders.customer.core.search.CustomerSearch;
import com.builders.customer.domain.CustomerVO;

import java.util.Set;

public interface CustomerDAO {
    CustomerVO findByEmail(String email);

    CustomerVO save(CustomerVO vo);

    CustomerVO delete(CustomerVO customer);

    Set<CustomerVO> list(CustomerSearch search);
}
