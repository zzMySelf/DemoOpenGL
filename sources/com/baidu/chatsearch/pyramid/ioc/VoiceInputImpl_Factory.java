package com.baidu.chatsearch.pyramid.ioc;

public class VoiceInputImpl_Factory {
    private static volatile VoiceInputImpl instance;

    private VoiceInputImpl_Factory() {
    }

    public static synchronized VoiceInputImpl get() {
        VoiceInputImpl voiceInputImpl;
        synchronized (VoiceInputImpl_Factory.class) {
            if (instance == null) {
                instance = new VoiceInputImpl();
            }
            voiceInputImpl = instance;
        }
        return voiceInputImpl;
    }
}
