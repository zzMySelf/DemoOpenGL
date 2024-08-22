package com.baidu.searchbox.comment.guide;

public class InteractiveGuideImpl_Factory {
    private static volatile InteractiveGuideImpl instance;

    private InteractiveGuideImpl_Factory() {
    }

    public static synchronized InteractiveGuideImpl get() {
        InteractiveGuideImpl interactiveGuideImpl;
        synchronized (InteractiveGuideImpl_Factory.class) {
            if (instance == null) {
                instance = new InteractiveGuideImpl();
            }
            interactiveGuideImpl = instance;
        }
        return interactiveGuideImpl;
    }
}
