package com.baidu.searchbox.common.security;

public class SecUbcLog {
    private static UbcLogable sUbcImpl;

    public interface UbcLogable {
        void onEvent(String str, String str2);
    }

    public static void init(UbcLogable logable) {
        sUbcImpl = logable;
    }

    public static void onEvent(String eventId, String content) {
        UbcLogable impl = sUbcImpl;
        if (impl != null) {
            impl.onEvent(eventId, content);
        }
    }
}
