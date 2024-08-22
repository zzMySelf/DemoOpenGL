package com.baidu.searchbox.feed.tts;

public class NovelTtsServiceImpl_Factory {
    private static volatile NovelTtsServiceImpl instance;

    private NovelTtsServiceImpl_Factory() {
    }

    public static synchronized NovelTtsServiceImpl get() {
        NovelTtsServiceImpl novelTtsServiceImpl;
        synchronized (NovelTtsServiceImpl_Factory.class) {
            if (instance == null) {
                instance = new NovelTtsServiceImpl();
            }
            novelTtsServiceImpl = instance;
        }
        return novelTtsServiceImpl;
    }
}
