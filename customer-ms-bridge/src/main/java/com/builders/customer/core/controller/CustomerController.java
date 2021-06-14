package com.builders.customer.core.controller;

import com.builders.customer.core.search.CustomerSearch;
import com.builders.customer.core.to.CustomerTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RequestMapping("/customer")
public interface CustomerController {

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    ResponseEntity<CustomerTO> create(@RequestBody @Valid CustomerTO customer);

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    ResponseEntity<CustomerTO> update(@RequestBody @Valid CustomerTO customer);

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    ResponseEntity<CustomerTO> delete(@PathVariable("email") String email);

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    ResponseEntity<Collection<CustomerTO>> list(@RequestParam(required = false) CustomerSearch search);
}
