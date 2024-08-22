package com.baidu.pass.http;

import com.baidu.pass.a;
import java.util.HashMap;
import java.util.Map;

public class HttpHashMap implements a {
    public Map<String, String> a = new HashMap();

    public void doSign(String str) {
    }

    public String get(String str) {
        return this.a.get(str);
    }

    public Map getMap() {
        return this.a;
    }

    public void put(String str, String str2) {
        this.a.put(str, str2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.a.putAll(map);
    }
}
