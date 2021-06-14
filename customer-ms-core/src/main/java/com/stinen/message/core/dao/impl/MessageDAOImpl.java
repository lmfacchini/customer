package com.stinen.message.core.dao.impl;

import com.stinen.message.bridge.constants.MessageStatus;
import com.stinen.message.bridge.search.MessageSearch;
import com.stinen.message.core.dao.MessageDAO;
import com.stinen.message.core.repository.MessageRepository;
import com.stinen.message.domain.MessageVO;
import org.apache.commons.lang3.StringUtils;
import nom.springbased.data.dao.AbstractDAO;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class MessageDAOImpl extends AbstractDAO<MessageVO, MessageSearch, MessageRepository> implements MessageDAO {

    public MessageDAOImpl(MessageRepository repository) {
        super(repository);
    }

    @Override
    public List<MessageVO> findByRecipients(int page, int size, Set<String> recipients) {

        Criteria criteria = Criteria.where("recipients").in(recipients);
        return find(criteria, page, size);
    }

    @Override
    public int countByStatusAndRecipients(MessageStatus status, Set<String> recipients) {
        return repository.countByStatusAndRecipientsInAndExclusionIsNull(status, recipients);
    }
}
