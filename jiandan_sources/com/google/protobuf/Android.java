package com.google.protobuf;

public final class Android {
    public static final boolean IS_ROBOLECTRIC = (getClassForName("org.robolectric.Robolectric") != null);
    public static final Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");

    public static <T> Class<T> getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    public static boolean isOnAndroidDevice() {
        return MEMORY_CLASS != null && !IS_ROBOLECTRIC;
    }
}
