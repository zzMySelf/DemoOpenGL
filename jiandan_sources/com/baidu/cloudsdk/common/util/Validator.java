package com.baidu.cloudsdk.common.util;

import android.text.TextUtils;
import java.util.Collection;

public final class Validator {
    public static final String CONTAINS_NO_NULLS_FMT = "Container '%s' cannot contain null values";
    public static final String NOT_NULL_FMT = "Argument '%s' cannot be null";
    public static final String NOT_NULL_OR_EMPTY_FMT = "Argument '%s' cannot be null or empty";
    public static final String NOT_ONE_OF_FMT = "Argument '%s' was not one of the allowed values";

    public static <T> void containsNoNulls(Collection<T> collection, String str) {
        notNull(collection, str);
        for (T t : collection) {
            if (t == null) {
                throw new NullPointerException(String.format(CONTAINS_NO_NULLS_FMT, new Object[]{str}));
            }
        }
    }

    public static <T> void notEmptyAndContainsNoNulls(Collection<T> collection, String str) {
        notNullOrEmpty(collection, str);
        for (T t : collection) {
            if (t == null) {
                throw new NullPointerException(String.format(CONTAINS_NO_NULLS_FMT, new Object[]{str}));
            }
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(String.format(NOT_NULL_FMT, new Object[]{str}));
        }
    }

    public static void notNullOrEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.format(NOT_NULL_OR_EMPTY_FMT, new Object[]{str2}));
        }
    }

    public static void oneOf(Object obj, String str, Object... objArr) {
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                if (obj2.equals(obj)) {
                    return;
                }
            } else if (obj == null) {
                return;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_ONE_OF_FMT, new Object[]{str}));
    }

    public static <T> void notNullOrEmpty(Collection<T> collection, String str) {
        if (Utils.isEmpty(collection)) {
            throw new IllegalArgumentException(String.format(NOT_NULL_OR_EMPTY_FMT, new Object[]{str}));
        }
    }

    public static <T> void notNullOrEmpty(T[] tArr, String str) {
        notNull(tArr, str);
        if (tArr.length == 0) {
            throw new IllegalArgumentException(String.format(NOT_NULL_OR_EMPTY_FMT, new Object[]{str}));
        }
    }
}
