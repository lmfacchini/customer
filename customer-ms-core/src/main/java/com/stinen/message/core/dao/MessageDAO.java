package com.stinen.message.core.dao;

import com.stinen.message.bridge.constants.MessageStatus;
import com.stinen.message.bridge.search.MessageSearch;
import com.stinen.message.domain.MessageVO;
import nom.springbased.data.dao.DAO;

import java.util.List;
import java.util.Set;

public interface MessageDAO extends DAO<MessageVO, MessageSearch> {
    List<MessageVO> findByRecipients(int page, int size, Set<String> recipients);

    int countByStatusAndRecipients(MessageStatus status, Set<String> recipients);
}
