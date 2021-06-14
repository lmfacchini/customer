package com.stinen.message.core.service;

import com.stinen.message.bridge.constants.MessageStatus;
import com.stinen.message.bridge.search.MessageSearch;
import com.stinen.message.bridge.service.MessageService;
import com.stinen.message.bridge.to.MessageTO;
import com.stinen.message.core.dao.MessageDAO;
import com.stinen.message.domain.MessageVO;
import nom.framework.springbased.exception.BusinessException;
import nom.framework.springbased.microservice.service.DomainService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.AuthenticatedUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl extends DomainService<MessageTO, MessageSearch, MessageVO, MessageDAO> implements MessageService {


    public MessageServiceImpl(MessageDAO dao) {
        super(dao);
    }


    @Override
    public MessageTO create(MessageTO to) {
        if(CollectionUtils.containsAny(to.getRecipients(), getPrincipal().getName())){
            throw new BusinessException("BMESG00000000003");
        }
        MessageVO vo = newDomain(to);
        vo.setStatus(MessageStatus.NEW);
        vo.setFrom(getPrincipal().getName());
        vo = dao.save(vo);
        return parse(vo);
    }

    @Override
    public MessageTO update(MessageTO to) {
        MessageVO vo = dao.findById(to.getOriginalId());
        if(vo == null){
            throw new BusinessException("BMESG00000000001");
        }
        if(to.getStatus() == null || (MessageStatus.READED.equals(vo.getStatus()) && MessageStatus.NEW.equals(to.getStatus()))){
            throw new BusinessException("BMESG00000000002");
        }
        vo.setStatus(to.getStatus());

        vo = dao.save(vo);
        return to;
    }

    @Override
    public List<MessageTO> listMyMessages(int page, int size) {
        Set<String> recipients = new HashSet<>();
        Authentication auth = getAuthentication();
        recipients.add(auth.getName());
        recipients.addAll(auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()));
        List<MessageVO> messages = dao.findByRecipients(page, size, recipients);
        messages.forEach(message->message.setRecipients(null));
        return parse(messages);
    }

    @Override
    public List<MessageTO> delete(Set<String> ids) {
        List<MessageTO> messages = new ArrayList<>();
        List<MessageVO> vos = new ArrayList<>();
        for(String id : ids){
            try{
                MessageTO to = new MessageTO(id);
                MessageVO vo = dao.findById(to.getOriginalId());
                if(vo != null){
                    vos.add(vo);
                }
            }catch (Exception ex){
                LOGGER.debug("Remove message", ex);
            }
        }
        dao.delete(vos);
        return parse(vos);
    }

    @Override
    public Integer countByStatus(MessageStatus status) {
        Set<String> recipients = new HashSet<>();
        Authentication auth = getAuthentication();
        recipients.add(auth.getName());
        recipients.addAll(auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()));
        int size = dao.countByStatusAndRecipients(status, recipients);
        return size;
    }

    @Override
    protected MessageTO parse(MessageVO vo) {
        MessageTO to = super.parse(vo);
        to.setSubject(vo.getSubject());
        to.setContent(vo.getContent());
        to.setRecipients(vo.getRecipients());
        to.setFrom(vo.getFrom());
        to.setStatus(vo.getStatus());
        return to;
    }

    @Override
    protected MessageVO parse(MessageTO to) {
        MessageVO vo = super.parse(to);
        vo.setSubject(to.getSubject());
        vo.setContent(to.getContent());
        vo.setRecipients(to.getRecipients());
        vo.setFrom(to.getFrom());
        vo.setStatus(to.getStatus());
        return vo;
    }
}
