package ws.controller;

import com.builders.customer.core.search.CustomerSearch;
import com.builders.customer.core.service.CustomerService;
import com.builders.customer.core.to.CustomerTO;
import com.builders.customer.ws.controller.CustomerControllerImpl;
import org.apache.commons.lang3.time.DateUtils;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerControllerTest {




    @Test
    public void create() throws Exception {
        CustomerService service = EasyMock.createMock(CustomerService.class);


        CustomerTO to = new CustomerTO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        EasyMock.expect(service.create(EasyMock.eq(to))).andReturn(to).once();
        EasyMock.replay(service);
        CustomerControllerImpl controller = new CustomerControllerImpl(service);

        ResponseEntity<CustomerTO> response = controller.create(to);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(response.getBody(), to);



    }

    @Test
    public void update()throws Exception {
        CustomerService service = EasyMock.createMock(CustomerService.class);


        CustomerTO to = new CustomerTO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        EasyMock.expect(service.update(EasyMock.eq(to))).andReturn(to).once();
        EasyMock.replay(service);
        CustomerControllerImpl controller = new CustomerControllerImpl(service);

        ResponseEntity<CustomerTO> response = controller.update(to);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(response.getBody(), to);
    }


    @Test
    public void delete( )throws Exception {
        CustomerService service = EasyMock.createMock(CustomerService.class);


        CustomerTO to = new CustomerTO("Leonardo Marquini Facchini", DateUtils.parseDate("03/08/1983", "dd/MM/yyyy"), "lmfacchini@gmail.com");
        EasyMock.expect(service.delete(EasyMock.eq("lmfacchini@gmail.com"))).andReturn(to).once();
        EasyMock.replay(service);
        CustomerControllerImpl controller = new CustomerControllerImpl(service);

        ResponseEntity<CustomerTO> response = controller.delete("lmfacchini@gmail.com");

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(response.getBody(), to);
    }

    @Test
    public void list() throws Exception{
        CustomerService service = EasyMock.createMock(CustomerService.class);

        CustomerSearch search = new CustomerSearch();
        search.setName("Marquini");

        Set<CustomerTO> result = new HashSet<>();
        result.add(new CustomerTO("Marcio Ruanes Marquini", DateUtils.parseDate("25/01/1964", "dd/MM/yyyy"), "mrmarquini@gmail.com"));
        result.add(new CustomerTO("Romarinho Marquini", DateUtils.parseDate("15/10/1978", "dd/MM/yyyy"), "rmarquini@gmail.com"));

        EasyMock.expect(service.list(EasyMock.eq(search))).andReturn(result).once();
        EasyMock.replay(service);
        CustomerControllerImpl controller = new CustomerControllerImpl(service);


        ResponseEntity<Collection<CustomerTO>> response = controller.list(search);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().size(), result.size());
    }
}
