package com.itextpdf.text.log;

public interface Logger {
    void ad(String str, Exception exc);

    Logger de(Class<?> cls);

    void fe(String str);

    boolean qw(Level level);
}
