package com.builders.customer.core.dao.impl;

import com.builders.customer.core.search.CustomerSearch;
import com.builders.customer.core.repository.CustomerRepository;
import com.builders.customer.domain.CustomerVO;
import org.apache.commons.lang3.time.DateUtils;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CustomerDAOTest  {



    @Test
    public void findByEmail() throws Exception {
        CustomerRepository repository = EasyMock.createMock(CustomerRepository.class);
        MongoTemplate template = EasyMock.createMock(MongoTemplate.class);


        CustomerVO vo = new CustomerVO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        EasyMock.expect(repository.findByEmail("lmfacchini@gmail.com")).andReturn(vo).once();
        EasyMock.replay(repository, template);
        CustomerDAOImpl dao = new CustomerDAOImpl(repository, template);

        CustomerVO response = dao.findByEmail("lmfacchini@gmail.com");

        assertNotNull(response);
        assertEquals(response, vo);
    }

    @Test
    public void save() throws Exception{

        CustomerRepository repository = EasyMock.createMock(CustomerRepository.class);
        MongoTemplate template = EasyMock.createMock(MongoTemplate.class);


        CustomerVO vo = new CustomerVO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        EasyMock.expect(repository.save(vo)).andReturn(vo).once();
        EasyMock.replay(repository, template);
        CustomerDAOImpl dao = new CustomerDAOImpl(repository, template);

        CustomerVO response = dao.save(vo);

        assertNotNull(response);
        assertEquals(response, vo);
    }

    @Test
    public void delete()  throws Exception{
        CustomerRepository repository = EasyMock.createMock(CustomerRepository.class);
        MongoTemplate template = EasyMock.createMock(MongoTemplate.class);


        CustomerVO vo = new CustomerVO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        repository.delete(vo);
        EasyMock.replay(repository, template);
        CustomerDAOImpl dao = new CustomerDAOImpl(repository, template);

        CustomerVO response = dao.delete(vo);

        assertNotNull(response);
        assertEquals(response, vo);
    }

    @Test
    public void list() throws Exception{
        CustomerRepository repository = EasyMock.createMock(CustomerRepository.class);
        MongoTemplate template = EasyMock.createMock(MongoTemplate.class);


        CustomerSearch search = new CustomerSearch();
        search.setName("Marquini");

        List<CustomerVO> result = new ArrayList<>();
        result.add(new CustomerVO("Marcio Ruanes Marquini", DateUtils.parseDate("25/01/1964", "dd/MM/yyyy"), "mrmarquini@gmail.com"));
        result.add(new CustomerVO("Romarinho Marquini", DateUtils.parseDate("15/10/1978", "dd/MM/yyyy"), "rmarquini@gmail.com"));
        EasyMock.expect(template.find(EasyMock.anyObject(Query.class), EasyMock.eq(CustomerVO.class))).andReturn(result).once();
        EasyMock.replay(repository, template);
        CustomerDAOImpl dao = new CustomerDAOImpl(repository, template);

        Set<CustomerVO> set = dao.list(search);

        assertNotNull(set);
        assertEquals(set.size(), result.size());
    }
}
