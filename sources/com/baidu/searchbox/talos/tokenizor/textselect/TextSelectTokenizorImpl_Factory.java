package com.baidu.searchbox.talos.tokenizor.textselect;

public class TextSelectTokenizorImpl_Factory {
    private static volatile TextSelectTokenizorImpl instance;

    private TextSelectTokenizorImpl_Factory() {
    }

    public static synchronized TextSelectTokenizorImpl get() {
        TextSelectTokenizorImpl textSelectTokenizorImpl;
        synchronized (TextSelectTokenizorImpl_Factory.class) {
            if (instance == null) {
                instance = new TextSelectTokenizorImpl();
            }
            textSelectTokenizorImpl = instance;
        }
        return textSelectTokenizorImpl;
    }
}
