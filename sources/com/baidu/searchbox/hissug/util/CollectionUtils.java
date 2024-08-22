package com.baidu.searchbox.hissug.util;

import java.util.Collection;
import java.util.List;

public class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static int sizeOf(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static <T> T getLast(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T> T getFirst(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T getElement(List<T> list, int position) {
        if (isEmpty(list) || position < 0 || position >= list.size()) {
            return null;
        }
        return list.get(position);
    }
}
