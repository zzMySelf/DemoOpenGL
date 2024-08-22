package com.baidu.searchbox.font;

public class FontSizeBizFunImpl_Factory {
    private static volatile FontSizeBizFunImpl instance;

    private FontSizeBizFunImpl_Factory() {
    }

    public static synchronized FontSizeBizFunImpl get() {
        FontSizeBizFunImpl fontSizeBizFunImpl;
        synchronized (FontSizeBizFunImpl_Factory.class) {
            if (instance == null) {
                instance = new FontSizeBizFunImpl();
            }
            fontSizeBizFunImpl = instance;
        }
        return fontSizeBizFunImpl;
    }
}
