package org.apache.commons.lang3.text;

import java.util.Map;

public abstract class StrLookup<V> {
    public static final StrLookup<String> NONE_LOOKUP = new MapStrLookup((Map) null);
    public static final StrLookup<String> SYSTEM_PROPERTIES_LOOKUP = new SystemPropertiesStrLookup();

    public static class MapStrLookup<V> extends StrLookup<V> {
        public final Map<String, V> map;

        public MapStrLookup(Map<String, V> map2) {
            this.map = map2;
        }

        public String lookup(String str) {
            V v;
            Map<String, V> map2 = this.map;
            if (map2 == null || (v = map2.get(str)) == null) {
                return null;
            }
            return v.toString();
        }
    }

    public static class SystemPropertiesStrLookup extends StrLookup<String> {
        public SystemPropertiesStrLookup() {
        }

        public String lookup(String str) {
            if (str.length() <= 0) {
                return null;
            }
            try {
                return System.getProperty(str);
            } catch (SecurityException unused) {
                return null;
            }
        }
    }

    public static <V> StrLookup<V> mapLookup(Map<String, V> map) {
        return new MapStrLookup(map);
    }

    public static StrLookup<?> noneLookup() {
        return NONE_LOOKUP;
    }

    public static StrLookup<String> systemPropertiesLookup() {
        return SYSTEM_PROPERTIES_LOOKUP;
    }

    public abstract String lookup(String str);
}
