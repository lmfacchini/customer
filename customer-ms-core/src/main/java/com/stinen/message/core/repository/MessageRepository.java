package com.stinen.message.core.repository;

import com.stinen.message.bridge.constants.MessageStatus;
import com.stinen.message.domain.MessageVO;
import nom.springbased.data.vo.DomainRepository;

import java.util.List;
import java.util.Set;

public interface MessageRepository extends DomainRepository<MessageVO> {





    int countByStatusAndRecipientsInAndExclusionIsNull(MessageStatus status, Set<String> recipients);
}
