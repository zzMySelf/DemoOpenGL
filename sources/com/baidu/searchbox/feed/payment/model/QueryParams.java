package com.baidu.searchbox.feed.payment.model;

import com.google.gson.Gson;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/QueryParams;", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "()V", "id", "pack", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnDao.kt */
public final class QueryParams extends LinkedHashMap<String, Object> {
    public final /* bridge */ boolean containsKey(Object key) {
        if (!(key instanceof String)) {
            return false;
        }
        return containsKey((String) key);
    }

    public /* bridge */ boolean containsKey(String key) {
        return super.containsKey(key);
    }

    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Object get(Object key) {
        if (!(key instanceof String)) {
            return null;
        }
        return get((String) key);
    }

    public /* bridge */ Object get(String key) {
        return super.get(key);
    }

    public /* bridge */ Set<Map.Entry<String, Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public final /* bridge */ Object getOrDefault(Object key, Object defaultValue) {
        return !(key instanceof String) ? defaultValue : getOrDefault((String) key, defaultValue);
    }

    public /* bridge */ Object getOrDefault(String key, Object defaultValue) {
        return super.getOrDefault(key, defaultValue);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    public final /* bridge */ Object remove(Object key) {
        if (!(key instanceof String)) {
            return null;
        }
        return remove((String) key);
    }

    public /* bridge */ Object remove(String key) {
        return super.remove(key);
    }

    public final /* bridge */ boolean remove(Object key, Object value) {
        if ((key instanceof String) && value != null) {
            return remove((String) key, value);
        }
        return false;
    }

    public /* bridge */ boolean remove(String key, Object value) {
        return super.remove(key, value);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    public final QueryParams id(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        put("id", id);
        return this;
    }

    public final String pack() {
        String json = new Gson().toJson((Object) this);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
        return json;
    }
}
