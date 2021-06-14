package com.stinen.message.ws.controller;

import com.stinen.message.bridge.constants.MessageStatus;
import com.stinen.message.bridge.controller.MessageController;
import com.stinen.message.bridge.search.MessageSearch;
import com.stinen.message.bridge.service.MessageService;
import com.stinen.message.bridge.to.MessageTO;
import nom.springbased.web.controller.CrudController;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Controller
public class MessageControllerImpl extends CrudController<MessageTO, MessageSearch, MessageService> implements MessageController {

    public MessageControllerImpl(MessageService service) {
        super(service);
    }


    @Override
    public ResponseEntity<Collection<MessageTO>> listMyMessages(int page, int size) {
        return ok(service.listMyMessages(page, size));
    }

    @Override
    public ResponseEntity<MessageTO> setStatus(MessageTO message) {
        return ok(service.update(message));
    }

    @Override
    public ResponseEntity<Integer> countByStatus(MessageStatus status) {
        return ok(service.countByStatus(status));
    }

    @Override
    public ResponseEntity<Collection<MessageTO>> remove(Set<String> ids) {
        List<MessageTO> messages = service.delete(ids);
        if(CollectionUtils.isEmpty(messages)){
            return noContent().build();
        }
        return ResponseEntity.accepted().body(messages);
    }

}
