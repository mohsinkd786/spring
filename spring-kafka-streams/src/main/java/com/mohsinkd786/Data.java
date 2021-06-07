package com.mohsinkd786;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private String key;
    private List<String> messages = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
