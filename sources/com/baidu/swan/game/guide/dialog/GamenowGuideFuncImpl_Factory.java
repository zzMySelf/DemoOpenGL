package com.baidu.swan.game.guide.dialog;

public class GamenowGuideFuncImpl_Factory {
    private static volatile GamenowGuideFuncImpl instance;

    private GamenowGuideFuncImpl_Factory() {
    }

    public static synchronized GamenowGuideFuncImpl get() {
        GamenowGuideFuncImpl gamenowGuideFuncImpl;
        synchronized (GamenowGuideFuncImpl_Factory.class) {
            if (instance == null) {
                instance = new GamenowGuideFuncImpl();
            }
            gamenowGuideFuncImpl = instance;
        }
        return gamenowGuideFuncImpl;
    }
}
