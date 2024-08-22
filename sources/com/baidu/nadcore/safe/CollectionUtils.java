package com.baidu.nadcore.safe;

import android.util.Log;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CollectionUtils {
    public static final int INVALID_FLAG = -1;
    private static final String TAG = "CollectionUtils";

    public static <T> boolean add(List<T> list, T o) {
        if (isNull(list)) {
            return false;
        }
        try {
            return list.add(o);
        } catch (Exception e2) {
            throwExceptionIfDebug(e2);
            return false;
        }
    }

    public static <T> void add(List<T> list, T o, int index) {
        if (!isNull(list) && isIndexValid(list, index)) {
            try {
                list.add(index, o);
            } catch (Exception e2) {
                throwExceptionIfDebug(e2);
            }
        }
    }

    public static <T> T set(List<T> list, T o, int index) {
        if (isNull(list) || !isIndexValid(list, index)) {
            return null;
        }
        try {
            return list.set(index, o);
        } catch (Exception e2) {
            throwExceptionIfDebug(e2);
            return null;
        }
    }

    public static <T> void set(T[] array, T o, int index) {
        if (!isNull(array) && isIndexValid(array, index)) {
            try {
                array[index] = o;
            } catch (Exception e2) {
                throwExceptionIfDebug(e2);
            }
        }
    }

    public static <T> T get(List<T> list, int index) {
        if (isNullOrEmpty(list) || !isIndexValid(list, index)) {
            return null;
        }
        try {
            return list.get(index);
        } catch (Exception e2) {
            throwExceptionIfDebug(e2);
            return null;
        }
    }

    public static <T> T get(T[] array, int index) {
        if (isNullOrEmpty(array) || !isIndexValid(array, index)) {
            return null;
        }
        try {
            return array[index];
        } catch (Exception e2) {
            throwExceptionIfDebug(e2);
            return null;
        }
    }

    public static int get(int[] array, int index) {
        if (isNullOrEmpty(array) || !isIndexValid(array, index)) {
            return -1;
        }
        try {
            return array[index];
        } catch (Exception e2) {
            throwExceptionIfDebug(e2);
            return -1;
        }
    }

    public static long get(long[] array, int index) {
        if (isNullOrEmpty(array) || !isIndexValid(array, index)) {
            return -1;
        }
        try {
            return array[index];
        } catch (Exception e2) {
            throwExceptionIfDebug(e2);
            return -1;
        }
    }

    public static <T> boolean remove(List<T> list, T o) {
        if (isNullOrEmpty(list)) {
            return false;
        }
        try {
            return list.remove(o);
        } catch (Exception e2) {
            throwExceptionIfDebug(e2);
            return false;
        }
    }

    public static <T> T remove(List<T> list, int index) {
        if (isNullOrEmpty(list) || !isIndexValid(list, index)) {
            return null;
        }
        try {
            return list.remove(index);
        } catch (Exception e2) {
            throwExceptionIfDebug(e2);
            return null;
        }
    }

    public static <T> boolean removeAll(List<T> list, Collection<?> c2) {
        if (isNull(list)) {
            return false;
        }
        try {
            return list.removeAll(c2);
        } catch (Exception e2) {
            Log.e(TAG, "throw exception when List removeAll");
            throwExceptionIfDebug(e2);
            return false;
        }
    }

    public static <T> int size(List<T> list) {
        if (isNull(list) || list.isEmpty()) {
            return 0;
        }
        return list.size();
    }

    public static int size(byte[] list) {
        if (isNull(list)) {
            return 0;
        }
        return list.length;
    }

    public static int size(int[] list) {
        if (isNull(list)) {
            return 0;
        }
        return list.length;
    }

    public static int size(long[] list) {
        if (isNull(list)) {
            return 0;
        }
        return list.length;
    }

    public static <K, V> int size(Map<K, V> map) {
        if (isNull(map)) {
            return 0;
        }
        return map.size();
    }

    public static <T> void clear(List<T> list) {
        if (!isNullOrEmpty(list)) {
            try {
                list.clear();
            } catch (Exception e2) {
                throwExceptionIfDebug(e2);
            }
        }
    }

    public static <T> int indexOf(List<T> list, T o) {
        if (isNullOrEmpty(list)) {
            return -1;
        }
        try {
            return list.indexOf(o);
        } catch (Exception e2) {
            throwExceptionIfDebug(e2);
            return -1;
        }
    }

    public static <T> boolean isNullOrEmpty(List<T> list) {
        return isNull(list) || list.isEmpty();
    }

    public static <T> boolean isNullOrEmpty(T[] array) {
        return isNull(array) || array.length == 0;
    }

    public static <T> boolean isNullOrEmpty(int[] array) {
        return isNull(array) || array.length == 0;
    }

    public static <T> boolean isNullOrEmpty(long[] array) {
        return isNull(array) || array.length == 0;
    }

    public static <K, V> boolean isNullOrEmpty(Map<K, V> map) {
        return isNull(map) || map.isEmpty();
    }

    private static boolean isNull(Object o) {
        return o == null;
    }

    public static <T> boolean isIndexValid(List<T> list, int index) {
        if (isNull(list) || index < 0) {
            return false;
        }
        try {
            if (index < list.size()) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            throwExceptionIfDebug(e2);
            return false;
        }
    }

    private static <T> boolean isIndexValid(T[] array, int index) {
        if (!isNull(array) && index >= 0 && index < array.length) {
            return true;
        }
        return false;
    }

    private static boolean isIndexValid(int[] array, int index) {
        if (!isNull(array) && index >= 0 && index < array.length) {
            return true;
        }
        return false;
    }

    private static boolean isIndexValid(long[] array, int index) {
        if (!isNull(array) && index >= 0 && index < array.length) {
            return true;
        }
        return false;
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, (Comparator) null);
    }

    public static <T> void sort(List<T> list, Comparator<? super T> c2) {
        if (!isNull(list)) {
            try {
                Collections.sort(list, c2);
            } catch (Exception e2) {
                Log.e(TAG, "throw exception when List sort");
                throwExceptionIfDebug(e2);
            }
        }
    }

    private static void throwExceptionIfDebug(Exception e2) {
    }

    public static <T> void addAll(Collection<T> dest, Collection<T> src) {
        if (src != null && dest != null) {
            dest.addAll(src);
        }
    }
}
