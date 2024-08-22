package com.baidu.searchbox.player.model;

public final class ParamPair<V> implements NameValuePair {
    public final String name;
    public final V value;

    public ParamPair(String k, V v) {
        this.name = k;
        this.value = v;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        V v = this.value;
        if (v == null) {
            return "";
        }
        return v.toString();
    }

    public V getValueObject() {
        return this.value;
    }

    public String toString() {
        return getName() + '=' + getValue();
    }
}
