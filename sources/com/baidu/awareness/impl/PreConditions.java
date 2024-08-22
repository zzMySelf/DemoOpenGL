package com.baidu.awareness.impl;

import java.util.Collection;

public final class PreConditions {
    private PreConditions() {
        throw new UnsupportedOperationException();
    }

    static <T> T checkNotNull(T obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException();
    }

    public static void checkArgument(boolean condition) {
        checkArgument(condition, (String) null);
    }

    private static void checkArgument(boolean condition, String errorMsg) {
        if (!condition) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() <= 0;
    }
}
