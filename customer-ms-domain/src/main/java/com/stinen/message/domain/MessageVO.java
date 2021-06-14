package com.stinen.message.domain;

import com.stinen.message.bridge.constants.MessageStatus;
import nom.springbased.data.vo.Domain;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "message")
public class MessageVO extends Domain {

    @Field
    private String subject;

    @Field
    private String content;

    @Field
    private Set<String> recipients;

    @Field
    private String from;

    @Field
    private MessageStatus status;

    public MessageVO() {
        recipients = new HashSet<>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(Set<String> recipients) {
        this.recipients = recipients;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
