package com.baidu.swan.game.ad.utils;

import android.util.Log;
import java.util.List;
import java.util.Map;

public class CollectionUtils {
    public static final boolean DEBUG = false;
    private static final String TAG = "CollectionUtils";

    public static <T> void add(List<T> list, T o) {
        if (!isNull(list)) {
            try {
                list.add(o);
            } catch (Exception e2) {
                log(TAG, e2.toString());
                throwExceptionIfDebug(e2);
            }
        }
    }

    public static <T> void add(List<T> list, T o, int index) {
        if (!isNull(list) && isIndexValid((List) list, index)) {
            try {
                list.add(index, o);
            } catch (Exception e2) {
                log(TAG, e2.toString());
                throwExceptionIfDebug(e2);
            }
        }
    }

    public static <T> void set(List<T> list, T o, int index) {
        if (!isNull(list) && isIndexValid((List) list, index)) {
            try {
                list.set(index, o);
            } catch (Exception e2) {
                log(TAG, e2.toString());
                throwExceptionIfDebug(e2);
            }
        }
    }

    public static <T> void set(T[] array, T o, int index) {
        if (!isNull(array) && isIndexValid(array, index)) {
            try {
                array[index] = o;
            } catch (Exception e2) {
                log(TAG, e2.toString());
                throwExceptionIfDebug(e2);
            }
        }
    }

    public static <T> T get(List<T> list, int index) {
        if (isNullOrEmpty((List) list) || !isIndexValid((List) list, index)) {
            return null;
        }
        try {
            return list.get(index);
        } catch (Exception e2) {
            log(TAG, e2.toString());
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
            log(TAG, e2.toString());
            throwExceptionIfDebug(e2);
            return null;
        }
    }

    public static <T> boolean remove(List<T> list, T o) {
        if (isNullOrEmpty((List) list)) {
            return false;
        }
        try {
            return list.remove(o);
        } catch (Exception e2) {
            log(TAG, e2.toString());
            throwExceptionIfDebug(e2);
            return false;
        }
    }

    public static void remove(List list, int index) {
        if (!isNullOrEmpty(list) && isIndexValid(list, index)) {
            try {
                list.remove(index);
            } catch (Exception e2) {
                log(TAG, e2.toString());
                throwExceptionIfDebug(e2);
            }
        }
    }

    public static int size(List list) {
        if (isNull(list) || list.isEmpty()) {
            return 0;
        }
        try {
            return list.size();
        } catch (Exception e2) {
            log(TAG, e2.toString());
            throwExceptionIfDebug(e2);
            return 0;
        }
    }

    public static <K, V> int size(Map<K, V> map) {
        if (isNull(map) || map.isEmpty()) {
            return 0;
        }
        return map.size();
    }

    public static void clear(List list) {
        if (!isNullOrEmpty(list)) {
            try {
                list.clear();
            } catch (Exception e2) {
                log(TAG, e2.toString());
                throwExceptionIfDebug(e2);
            }
        }
    }

    public static <T> int indexOf(List<T> list, T o) {
        if (isNullOrEmpty((List) list)) {
            return -1;
        }
        try {
            return list.indexOf(o);
        } catch (Exception e2) {
            log(TAG, e2.toString());
            throwExceptionIfDebug(e2);
            return -1;
        }
    }

    public static boolean isNullOrEmpty(List list) {
        if (!isNull(list) && !list.isEmpty()) {
            return false;
        }
        log(TAG, "list is empty");
        return true;
    }

    public static <K, V> boolean isNullOrEmpty(Map<K, V> map) {
        return isNull(map) || map.isEmpty();
    }

    public static <T> boolean isNullOrEmpty(T[] array) {
        if (!isNull(array) && array.length != 0) {
            return false;
        }
        log(TAG, "array is empty");
        return true;
    }

    private static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isIndexValid(List list, int index) {
        if (isNull(list)) {
            return false;
        }
        if (index >= 0) {
            try {
                if (index < list.size()) {
                    return true;
                }
            } catch (Exception e2) {
                log(TAG, e2.toString());
                throwExceptionIfDebug(e2);
                return false;
            }
        }
        log(TAG, "list index out of bounds");
        return false;
    }

    private static <T> boolean isIndexValid(T[] array, int index) {
        if (isNull(array)) {
            return false;
        }
        if (index >= 0 && index < array.length) {
            return true;
        }
        log(TAG, "array index out of bounds");
        return false;
    }

    private static void throwExceptionIfDebug(Exception e2) {
    }

    private static void log(String tag, String info) {
        Log.e(tag, info);
    }
}
