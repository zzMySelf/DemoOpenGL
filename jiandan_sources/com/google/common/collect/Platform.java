package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Strings;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true)
public final class Platform {
    public static final String GWT_RPC_PROPERTY_NAME = "guava.gwt.emergency_reenable_rpc";

    public static void checkGwtRpcEnabled() {
        if (!Boolean.parseBoolean(System.getProperty("guava.gwt.emergency_reenable_rpc", "true"))) {
            throw new UnsupportedOperationException(Strings.lenientFormat("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", "guava.gwt.emergency_reenable_rpc", "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ"));
        }
    }

    public static <T> T[] copy(Object[] objArr, int i2, int i3, T[] tArr) {
        return Arrays.copyOfRange(objArr, i2, i3, tArr.getClass());
    }

    public static <T> T[] newArray(T[] tArr, int i2) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
    }

    public static <K, V> Map<K, V> newHashMapWithExpectedSize(int i2) {
        return CompactHashMap.createWithExpectedSize(i2);
    }

    public static <E> Set<E> newHashSetWithExpectedSize(int i2) {
        return CompactHashSet.createWithExpectedSize(i2);
    }

    public static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int i2) {
        return CompactLinkedHashMap.createWithExpectedSize(i2);
    }

    public static <E> Set<E> newLinkedHashSetWithExpectedSize(int i2) {
        return CompactLinkedHashSet.createWithExpectedSize(i2);
    }

    public static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    public static int reduceExponentIfGwt(int i2) {
        return i2;
    }

    public static int reduceIterationsIfGwt(int i2) {
        return i2;
    }

    public static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }
}
