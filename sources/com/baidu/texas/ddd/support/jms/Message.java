package com.baidu.texas.ddd.support.jms;

public class Message {
    private final Object payload;

    public Message(Object payload2) {
        this.payload = payload2;
    }

    public <T> T getBody(Class<T> c2) {
        return c2.cast(this.payload);
    }
}
