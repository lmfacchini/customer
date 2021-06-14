package com.stinen.message.bridge.to;

import com.stinen.message.bridge.constants.MessageStatus;
import nom.springbased.commons.data.Lower;
import nom.springbased.commons.data.TransactionObject;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

public class MessageTO extends TransactionObject {


    @NotNull
    @Size(min = 3,max = 20)
    private String subject;

    @NotNull
    @Size(min = 3,max = 255)
    private String content;


    @NotEmpty
    @NotNull
    private Set<String> recipients;

    @Null
    private String from;

    private MessageStatus status;

    public MessageTO() {
        recipients = new HashSet<>();
    }

    public MessageTO(String id) {
        setId(id);
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
