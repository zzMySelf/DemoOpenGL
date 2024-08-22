package com.baidu.searchbox.redux.impl.extension;

public class SimpleAction implements Action {
    public final Object payload;
    public final String type;

    public SimpleAction(String type2) {
        this(type2, (Object) null);
    }

    public SimpleAction(String type2, Object payload2) {
        this.type = type2;
        this.payload = payload2;
    }

    public <T> T getPayload() {
        return this.payload;
    }

    public String toString() {
        return this.type;
    }
}
