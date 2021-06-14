package com.stinen.message.bridge.search;

import com.stinen.message.bridge.constants.MessageStatus;
import nom.framework.springbased.SearchData;

public class MessageSearch extends SearchData {

    private String content;

    private String destination;

    private MessageStatus status;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }
}
