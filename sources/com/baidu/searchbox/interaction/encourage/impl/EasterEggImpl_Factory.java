package com.baidu.searchbox.interaction.encourage.impl;

public class EasterEggImpl_Factory {
    private static volatile EasterEggImpl instance;

    private EasterEggImpl_Factory() {
    }

    public static synchronized EasterEggImpl get() {
        EasterEggImpl easterEggImpl;
        synchronized (EasterEggImpl_Factory.class) {
            if (instance == null) {
                instance = new EasterEggImpl();
            }
            easterEggImpl = instance;
        }
        return easterEggImpl;
    }
}
