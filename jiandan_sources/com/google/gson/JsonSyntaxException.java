package com.google.gson;

public final class JsonSyntaxException extends JsonParseException {
    public static final long serialVersionUID = 1;

    public JsonSyntaxException(String str) {
        super(str);
    }

    public JsonSyntaxException(String str, Throwable th2) {
        super(str, th2);
    }

    public JsonSyntaxException(Throwable th2) {
        super(th2);
    }
}
