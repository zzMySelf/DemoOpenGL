package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class Platform {
    public static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>() {
        public char[] initialValue() {
            return new char[1024];
        }
    };

    public static char[] charBufferFromThreadLocal() {
        return DEST_TL.get();
    }
}
