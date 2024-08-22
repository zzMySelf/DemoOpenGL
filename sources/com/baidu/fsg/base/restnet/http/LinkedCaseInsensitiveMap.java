package com.baidu.fsg.base.restnet.http;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class LinkedCaseInsensitiveMap<V> extends LinkedHashMap<String, V> {
    private static final long serialVersionUID = 1;
    private final Map<String, String> caseInsensitiveKeys;
    private final Locale locale;

    public LinkedCaseInsensitiveMap() {
        this((Locale) null);
    }

    public LinkedCaseInsensitiveMap(int i2) {
        this(i2, (Locale) null);
    }

    public LinkedCaseInsensitiveMap(int i2, Locale locale2) {
        super(i2);
        this.caseInsensitiveKeys = new HashMap(i2);
        this.locale = locale2 == null ? Locale.getDefault() : locale2;
    }

    public LinkedCaseInsensitiveMap(Locale locale2) {
        this.caseInsensitiveKeys = new HashMap();
        this.locale = locale2 == null ? Locale.getDefault() : locale2;
    }

    public void clear() {
        this.caseInsensitiveKeys.clear();
        super.clear();
    }

    public boolean containsKey(Object obj) {
        return (obj instanceof String) && this.caseInsensitiveKeys.containsKey(convertKey((String) obj));
    }

    /* access modifiers changed from: protected */
    public String convertKey(String str) {
        return str.toLowerCase(this.locale);
    }

    public V get(Object obj) {
        if (obj instanceof String) {
            return super.get(this.caseInsensitiveKeys.get(convertKey((String) obj)));
        }
        return null;
    }

    public V put(String str, V v) {
        this.caseInsensitiveKeys.put(convertKey(str), str);
        return super.put(str, v);
    }

    public void putAll(Map<? extends String, ? extends V> map) {
        if (!map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                    put((String) next.getKey(), next.getValue());
                }
            }
        }
    }

    public V remove(Object obj) {
        if (obj instanceof String) {
            return super.remove(this.caseInsensitiveKeys.remove(convertKey((String) obj)));
        }
        return null;
    }
}
