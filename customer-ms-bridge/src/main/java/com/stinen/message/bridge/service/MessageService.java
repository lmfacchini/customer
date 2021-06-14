package com.stinen.message.bridge.service;

import com.stinen.message.bridge.constants.MessageStatus;
import com.stinen.message.bridge.search.MessageSearch;
import com.stinen.message.bridge.to.MessageTO;
import nom.framework.springbased.service.CrudService;

import java.util.List;
import java.util.Set;

public interface MessageService extends CrudService<MessageTO, MessageSearch> {

    List<MessageTO> listMyMessages(int page, int size);

    List<MessageTO> delete(Set<String> ids);

    Integer countByStatus(MessageStatus status);
}
