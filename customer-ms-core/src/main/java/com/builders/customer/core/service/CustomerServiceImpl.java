package com.builders.customer.core.service;

import com.builders.customer.bridge.BusinessException;
import com.builders.customer.bridge.search.CustomerSearch;
import com.builders.customer.bridge.service.CustomerService;
import com.builders.customer.bridge.to.CustomerTO;
import com.builders.customer.core.dao.CustomerDAO;
import com.builders.customer.domain.CustomerVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerDAO dao;

    public CustomerServiceImpl(CustomerDAO dao) {
        this.dao = dao;
    }

    @Override
    public CustomerTO create(CustomerTO customer) {

        CustomerVO vo = dao.findByEmail(customer.getEmail());
        if(vo != null){
            throw new BusinessException(String.format("E-mail [%s] has already been registered.", customer.getEmail()));
        }
        vo = parse(customer);
        vo = dao.save(vo);
        return null;
    }

    @Override
    public CustomerTO update(CustomerTO customer) {
        CustomerVO vo = dao.findByEmail(customer.getEmail());
        if(vo == null){
            throw new BusinessException(String.format("E-mail [%s] not exists.", customer.getEmail()));
        }
        vo.setName(customer.getName());
        vo.setBirth(customer.getBirth());
        vo = dao.save(vo);
        return parse(vo);
    }

    @Override
    public CustomerTO delete(String email) {
        CustomerVO vo = dao.findByEmail(email);
        if(vo == null){
            throw new BusinessException(String.format("E-mail [%s] not exists.", email));
        }
        vo = dao.delete(vo);
        return parse(vo);
    }

    @Override
    public Set<CustomerTO> list(CustomerSearch search) {
        Set<CustomerVO> result = dao.list(search);
        return parse(result);

    }

    private Set<CustomerTO> parse(Set<CustomerVO> set){
        return set.stream().map(this::parse).collect(Collectors.toSet());
    }

    private CustomerVO parse(CustomerTO to){
        return new CustomerVO(to.getName(), to.getBirth(), to.getEmail());
    }

    private CustomerTO parse(CustomerVO vo){
        return new CustomerTO(vo.getName(), vo.getBirth(), vo.getEmail());
    }

}
