package com.builders.customer.ws.controller;

import com.builders.customer.core.BusinessException;
import com.builders.customer.core.controller.CustomerController;
import com.builders.customer.core.search.CustomerSearch;
import com.builders.customer.core.service.CustomerService;
import com.builders.customer.core.to.CustomerTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class CustomerControllerImpl implements CustomerController {

    protected final Logger LOGGER;


    private final CustomerService service;

    public CustomerControllerImpl(CustomerService service) {
        this.service = service;
        LOGGER = LoggerFactory.getLogger(getClass());
    }

    @Override
    public ResponseEntity<CustomerTO> create(CustomerTO customer) {
        try{
            return ResponseEntity.ok(service.create(customer));
        }catch (Exception ex){
            LOGGER.error("CustomerController", ex);
            return ResponseEntity.badRequest().build();
        }

    }

    @Override
    public ResponseEntity<CustomerTO> update(CustomerTO customer) {
        try{
            return ResponseEntity.ok(service.update(customer));
        }catch (Exception ex){
            LOGGER.error("CustomerController", ex);
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<CustomerTO> delete(String email) {
        try{
            return ResponseEntity.ok(service.delete(email));
        }catch (Exception ex){
            LOGGER.error("CustomerController", ex);
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Collection<CustomerTO>> list(CustomerSearch search) {
        try{
            return ResponseEntity.ok(service.list(search));
        }catch (BusinessException ex){
            LOGGER.error("CustomerController", ex);
            return ResponseEntity.badRequest().build();
        }catch (Exception ex){
            LOGGER.error("CustomerController", ex);
            return ResponseEntity.badRequest().build();
        }
    }
}
