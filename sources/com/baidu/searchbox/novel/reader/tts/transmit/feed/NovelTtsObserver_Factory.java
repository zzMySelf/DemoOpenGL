package com.baidu.searchbox.novel.reader.tts.transmit.feed;

public class NovelTtsObserver_Factory {
    private static volatile NovelTtsObserver instance;

    private NovelTtsObserver_Factory() {
    }

    public static synchronized NovelTtsObserver get() {
        NovelTtsObserver novelTtsObserver;
        synchronized (NovelTtsObserver_Factory.class) {
            if (instance == null) {
                instance = new NovelTtsObserver();
            }
            novelTtsObserver = instance;
        }
        return novelTtsObserver;
    }
}
