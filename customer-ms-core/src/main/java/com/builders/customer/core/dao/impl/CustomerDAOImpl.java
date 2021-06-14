package com.builders.customer.core.dao.impl;

import com.builders.customer.bridge.search.CustomerSearch;
import com.builders.customer.core.dao.CustomerDAO;
import com.builders.customer.core.repository.CustomerRepository;
import com.builders.customer.domain.CustomerVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private final CustomerRepository repository;

    private final MongoTemplate template;

    public CustomerDAOImpl(CustomerRepository repository, MongoTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    @Override
    public CustomerVO findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public CustomerVO save(CustomerVO customer) {
        return repository.save(customer);
    }

    @Override
    public CustomerVO delete(CustomerVO customer) {
        repository.delete(customer);
        return customer;
    }

    @Override
    public Set<CustomerVO> list(CustomerSearch search) {
        Criteria criteria = Criteria.where("id").exists(true);
        if(StringUtils.isNotBlank(search.getEmail())){
            criteria = criteria.and("email").regex(String.format(".*%s.*"));
        }

        if(StringUtils.isNotBlank(search.getName())){
            criteria = criteria.and("name").regex(String.format(".*%s.*"));
        }

        if(search.getBirth() != null){
            criteria = criteria.and("birth").is(search.getBirth());
        }

        Query query = new Query().addCriteria(criteria).skip(search.getStart()).limit(search.getSize());
        List<CustomerVO> result = template.find(query, CustomerVO.class);
        if(CollectionUtils.isEmpty(result)){
            return Collections.emptySet();
        }
       return new HashSet<>(result);
    }
}
