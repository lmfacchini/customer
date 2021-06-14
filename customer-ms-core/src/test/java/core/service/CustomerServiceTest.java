package core.service;

import com.builders.customer.bridge.search.CustomerSearch;
import com.builders.customer.bridge.service.CustomerService;
import com.builders.customer.bridge.to.CustomerTO;
import com.builders.customer.core.dao.CustomerDAO;
import com.builders.customer.core.dao.impl.CustomerDAOImpl;
import com.builders.customer.core.service.CustomerServiceImpl;
import com.builders.customer.domain.CustomerVO;
import org.apache.commons.lang3.time.DateUtils;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerServiceTest  {





    @Test
    public void create() throws Exception{
        CustomerDAO dao = EasyMock.createMock(CustomerDAO.class);


        CustomerVO vo = new CustomerVO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        EasyMock.expect(dao.findByEmail(EasyMock.eq("lmfacchini@gmail.com"))).andReturn(null).once();
        EasyMock.expect(dao.save(EasyMock.eq(vo))).andReturn(vo).once();
        EasyMock.replay(dao);
        CustomerServiceImpl service = new CustomerServiceImpl(dao);
        CustomerTO to = new CustomerTO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        CustomerTO newto = service.create(to);

        assertNotNull(newto);

        assertEquals(newto, to);

    }


    @Test
    public void update() throws Exception{
        CustomerDAO dao = EasyMock.createMock(CustomerDAO.class);


        CustomerVO vo = new CustomerVO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        EasyMock.expect(dao.findByEmail(EasyMock.eq("lmfacchini@gmail.com"))).andReturn(vo).once();
        EasyMock.expect(dao.save(EasyMock.eq(vo))).andReturn(vo).once();
        EasyMock.replay(dao);
        CustomerServiceImpl service = new CustomerServiceImpl(dao);
        CustomerTO to = new CustomerTO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        CustomerTO newto = service.update(to);

        assertNotNull(to);

        assertEquals(newto, to);
    }


    @Test
    public void delete() throws Exception{
        CustomerDAO dao = EasyMock.createMock(CustomerDAO.class);


        CustomerVO vo = new CustomerVO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        EasyMock.expect(dao.findByEmail(EasyMock.eq("lmfacchini@gmail.com"))).andReturn(vo).once();
        EasyMock.expect(dao.delete(EasyMock.eq(vo))).andReturn(vo).once();
        EasyMock.replay(dao);
        CustomerServiceImpl service = new CustomerServiceImpl(dao);
        CustomerTO to = new CustomerTO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        CustomerTO newto = service.delete("lmfacchini@gmail.com");

        assertNotNull(to);

        assertEquals(newto, to);
    }


    @Test
    public void list()throws Exception {

        CustomerDAO dao = EasyMock.createMock(CustomerDAO.class);


        CustomerVO vo = new CustomerVO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");

        CustomerSearch search = new CustomerSearch();
        search.setName("Marquini");

        Set<CustomerVO> result = new HashSet<>();
        result.add(new CustomerVO("Marcio Ruanes Marquini", DateUtils.parseDate("25/01/1964", "dd/MM/yyyy"), "mrmarquini@gmail.com"));
        result.add(new CustomerVO("Romarinho Marquini", DateUtils.parseDate("15/10/1978", "dd/MM/yyyy"), "rmarquini@gmail.com"));
        EasyMock.expect(dao.list(EasyMock.eq(search))).andReturn(result).once();
        EasyMock.replay(dao);
        CustomerServiceImpl service = new CustomerServiceImpl(dao);

        Set<CustomerTO> set = service.list(search);

        assertNotNull(set);

        assertEquals(result.size(), set.size());
    }

}
